package org.scriptonbasestar.tool.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author archmagece
 * @with bs-tools-java
 * @since 2015-08-17-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonLongIdDto implements Serializable {
	@NotNull
	@Min(0)
	private Long id;
}
