package dsa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to mark a solution class for temporary/single execution.
 * When this annotation is present, only solutions marked with this will run,
 * ignoring the RunSolution annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RunOnce {
}