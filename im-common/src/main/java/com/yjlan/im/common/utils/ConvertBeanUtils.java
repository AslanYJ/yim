package com.yjlan.im.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * 转换工具
 * @author yjlan
 */
public class ConvertBeanUtils {
    
    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    public static final Mapper MAPPER = DozerBeanMapperBuilder.buildDefault();
    
    /**
     * List  实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     * @param <T> 源list
     * @param <S> 需要转换的类型
     * @return 转换的结果
     */
    public static <T, S> List<T> convertor(List<S> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        List<T> map = new ArrayList<>();
        for (S s : source) {
            map.add(MAPPER.map(s, clz));
        }
        return map;
    }
    
    /**
     * List  实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     * @param <T> 目标的List类型
     * @param <K> key类型
     * @param <V> value类型
     * @return 转换后的结果
     */
    public static <T, K, V> List<T> convertor(Map<K, V> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        List<T> map = new ArrayList<>();
        try {
            for (K k : source.keySet()) {
                V v = source.get(k);
                T t = clz.newInstance();
                Field[] fields = t.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.getType() == k.getClass()) {
                        field.setAccessible(true);
                        field.set(t, k);
                    }
                    if (field.getType() == v.getClass()) {
                        field.setAccessible(true);
                        field.set(t, v);
                    }
                }
                map.add(t);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }
    
    /**
     * Set 实体类 深度转换器
     *
     * @param source 原数据
     * @param clz    目标对象
     * @param <T> 目标类型
     * @param <S> 原来的类型
     * @return 转换后的集合
     */
    public static <T, S> Set<T> convertor(Set<S> source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        Set<T> set = new TreeSet<>();
        for (S s : source) {
            set.add(MAPPER.map(s, clz));
        }
        return set;
    }
    
    /**
     * 实体类 深度转换器
     *
     * @param source 源对象
     * @param clz 目标类型
     * @param <T> 目标类型
     * @param <S> 源类型
     * @return 转换后的结果
     */
    public static <T, S> T convertor(S source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        return MAPPER.map(source, clz);
    }
    
    /**
     * 浅度克隆
     * @param source 源
     * @param object 目标
     */
    public static void convertor(Object source, Object object) {
        MAPPER.map(source, object);
    }
}
