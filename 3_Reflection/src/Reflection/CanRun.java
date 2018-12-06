package Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Quinten Mortier
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface CanRun {
    String value() default "Dummy";
}
