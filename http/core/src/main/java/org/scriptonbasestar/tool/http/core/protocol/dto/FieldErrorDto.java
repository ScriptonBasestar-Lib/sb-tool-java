package org.scriptonbasestar.tool.http.core.protocol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author archmagece
 * @since 2017-09-05
 */
@Data
@AllArgsConstructor
public class FieldErrorDto {
	private String field;
	private String message;
}
