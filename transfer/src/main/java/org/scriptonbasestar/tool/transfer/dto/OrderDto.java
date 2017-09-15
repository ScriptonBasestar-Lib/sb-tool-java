package org.scriptonbasestar.tool.transfer.dto;

import lombok.Data;
import org.scriptonbasestar.tool.core.type.Direction;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author archmagece
 * @with sb-tool-jvm
 * @since 2015-09-09-16
 */
@Data
public class OrderDto {
	@NotNull
	@Size(min = 1)
	private String column;
	@NotNull
	private Direction direction;
}
