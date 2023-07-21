package com.zoowayss.app.common.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface RmRedisCache {

    String prefixKey() ;

    String key() ;
}
