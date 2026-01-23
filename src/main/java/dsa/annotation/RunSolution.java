package dsa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark solution classes that should be run.
 * By default, solutions without this annotation won't be executed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RunSolution {
    /**
     * Specifies if this solution should be run by default
     * @return true if this solution should run by default, false otherwise
     */
    boolean runByDefault() default true;
}