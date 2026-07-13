package br.com.gymflow.shared.logging.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Loggable {
  String value() default "";
  boolean logInput() default true;
  boolean logOutput() default true;
  boolean logDuration() default true;
  boolean logException() default true;

}
