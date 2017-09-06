package org.scriptonbasestar.tool.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author archmagece
 * @since 2015-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonLongIdNameDto implements Serializable {
	@NotNull
	private Long id;
	@NotNull
	@Size(min = 1)
	private String name;
}
