package com.spring.springSelenium.kelvin.annotation;

import java.lang.annotation.*;

@Page
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Window {
  String value() default "";
}
