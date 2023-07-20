package com.zoowayss.app.common.common.aspect;

import cn.hutool.core.util.StrUtil;
import com.zoowayss.app.common.common.annotation.RedisCache;
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
        RedisCache redissonLock = method.getAnnotation(RedisCache.class);
        String prefix = StrUtil.isBlank(redissonLock.prefixKey()) ? SpElUtils.getMethodKey(method) : redissonLock.prefixKey();//默认方法限定名+注解排名（可能多个）
        String key = SpElUtils.parseSpEl(method, joinPoint.getArgs(), redissonLock.key());
        try {
            Object o = RedisUtils.get(prefix + StrUtil.C_COLON + key, method.getReturnType());
            if (Objects.nonNull(o)) {
                return o;
            }
            Object invoke = method.invoke(joinPoint.getTarget(), joinPoint.getArgs());
            RedisUtils.set(prefix + StrUtil.C_COLON + key, invoke, redissonLock.expireTime(), redissonLock.unit());
            return invoke;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
