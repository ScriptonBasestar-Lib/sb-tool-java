package org.scriptonbasestar.tool.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2016-11-12
 */
public class SBStringLimiterImpl
	implements ConstraintValidator<SBStringLimiter, String> {

	private Set<String> valueSet;

	@Override
	public void initialize(SBStringLimiter constraintAnnotation) {
		valueSet = new HashSet<>();
		for (String value : constraintAnnotation.limitationStrings()) {
			valueSet.add(value);
		}
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (valueSet.contains(value)) {
			return true;
		}
		return false;
	}

}
