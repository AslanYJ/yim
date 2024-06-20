package com.yjlan.im.business.aop;

import com.yjlan.im.business.group.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceFallBackFactory implements RetryFallbackFactory<PayService>{
    @Override
    public PayService create(Throwable cause) {
        return new PayService() {

            @Override
            public int minGoodsNum(int num){
                log.error("minGoodsNum--------error");
                return 0;
            }
        };
    }
}
