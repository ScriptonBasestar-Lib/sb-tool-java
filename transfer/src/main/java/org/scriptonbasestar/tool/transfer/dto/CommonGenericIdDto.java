package org.scriptonbasestar.tool.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author archmagece
 * @with bs-tools-java
 * @since 2015-06-27-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonGenericIdDto<TypeOfId> implements Serializable {
	@NotNull
	private TypeOfId id;
}
