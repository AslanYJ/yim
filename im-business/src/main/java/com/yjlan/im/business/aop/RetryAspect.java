package com.yjlan.im.business.aop;

import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.yjlan.im.business.annotation.RetryOnFailure;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

@Aspect
@Component
@Slf4j
public class RetryAspect implements ApplicationContextAware {

    @Resource
    private  ApplicationContext applicationContext;

    @Around("@annotation(retryOnFailure)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, RetryOnFailure retryOnFailure) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Retryer<Object> retryer = RetryerBuilder.newBuilder()
                .retryIfException()
                .withWaitStrategy(WaitStrategies.fixedWait(retryOnFailure.delayMillis(),retryOnFailure.delayTimeType()))
                .withStopStrategy(StopStrategies.stopAfterAttempt(retryOnFailure.maxAttempts()))
                .build();

        Callable<Object> callable = () -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        };

        try {
            return retryer.call(callable);
        } catch (ExecutionException | UncheckedExecutionException e) {
             handleFallback(joinPoint, method, retryOnFailure.fallbackFactory());

        }
        return null;
    }

    private void handleFallback(ProceedingJoinPoint joinPoint, Method method, Class<?> fallbackClass) throws Exception {
        if (fallbackClass.equals(Void.class)) {
             return;
        }
        Object bean = applicationContext.getBean(fallbackClass);
        // 假设降级方法为，参数与原方法相同
        Method fallbackMethod = fallbackClass.getMethod(method.getName(), method.getParameterTypes());
        Object[] args = joinPoint.getArgs();
        fallbackMethod.invoke(bean, args);
    }


    @SuppressWarnings("NullableProblems")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}