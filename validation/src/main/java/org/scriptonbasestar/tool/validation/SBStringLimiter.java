package org.scriptonbasestar.tool.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2016-11-12
 */
@Documented
@Constraint(validatedBy = SBStringLimiterImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@NotNull(message = "~ must not null")
@ReportAsSingleViolation
public @interface SBStringLimiter {
	String[] limitationStrings();

	String message() default "~ is not acceptable";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
