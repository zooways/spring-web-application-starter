package com.zoowayss.app.common.common.aspect;

import cn.hutool.core.util.StrUtil;
import com.zoowayss.app.common.common.annotation.RedisCache;
import com.zoowayss.app.common.common.annotation.RmRedisCache;
import com.zoowayss.app.common.common.utils.RedisUtils;
import com.zoowayss.app.common.common.utils.SpElUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description:
 * @Author: <a href="https://github.com/zooways">zooways</a>
 * @Date: 2023/7/20 15:39
 */
@Slf4j
@AllArgsConstructor
@Aspect
@Component
public class RedisCacheAspect {
    @Around("@annotation(com.zoowayss.app.common.common.annotation.RedisCache)")
    public Object around(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        RedisCache redisCache = method.getAnnotation(RedisCache.class);
        String prefix = StrUtil.isBlank(redisCache.prefixKey()) ? SpElUtils.getMethodKey(method) : redisCache.prefixKey();//默认方法限定名+注解排名（可能多个）
        String key = SpElUtils.parseSpEl(method, joinPoint.getArgs(), redisCache.key());
        try {
            Object o = RedisUtils.get(prefix + StrUtil.C_COLON + key, method.getReturnType());
            if (Objects.nonNull(o)) {
                return o;
            }
            Object invoke = method.invoke(joinPoint.getTarget(), joinPoint.getArgs());
            RedisUtils.set(prefix + StrUtil.C_COLON + key, invoke, redisCache.expireTime(), redisCache.unit());
            return invoke;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Around("@annotation(com.zoowayss.app.common.common.annotation.RmRedisCache)")
    public Object rmAround(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        RmRedisCache rmRedisCache = method.getAnnotation(RmRedisCache.class);
        String prefix = StrUtil.isBlank(rmRedisCache.prefixKey()) ? SpElUtils.getMethodKey(method) : rmRedisCache.prefixKey();//默认方法限定名+注解排名（可能多个）
        String key = SpElUtils.parseSpEl(method, joinPoint.getArgs(), rmRedisCache.key());
        try {
            String redisKey =prefix + StrUtil.C_COLON + key;
            RedisUtils.del(redisKey);
            Object o = method.invoke(joinPoint.getTarget(), joinPoint.getArgs());
            RedisUtils.del(redisKey);
            return o;
        } catch (Exception e) {
            log.error("redis删除失败", e);
            throw new RuntimeException(e);
        }
    }


}
