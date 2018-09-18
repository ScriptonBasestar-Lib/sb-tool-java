package org.scriptonbasestar.tool.transfer.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author archmagece
 * @since 2017-09-05
 */
@Data
public class ValidationErrorDto {
	private final List<FieldErrorDto> fieldErrors = new ArrayList<>();

	public void addFieldError(String path, String message) {
		fieldErrors.add(new FieldErrorDto(path, message));
	}
}
