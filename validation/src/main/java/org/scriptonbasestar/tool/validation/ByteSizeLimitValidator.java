package org.scriptonbasestar.tool.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.nio.charset.Charset;

public class ByteSizeLimitValidator implements ConstraintValidator<ByteSizeLimit,String> {

	private int min;
	private int max;

	@Override
	public void initialize(ByteSizeLimit constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || (this.min <= value.getBytes(Charset.forName("UTF-8")).length && value.getBytes(Charset.forName("UTF-8")).length <= this.max);
	}
}
