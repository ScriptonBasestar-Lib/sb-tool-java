package org.scriptonbasestar.tool.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * @author archmagece
 * @with sb-tool-jvm
 * @since 2015-06-27-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonGenericIdsDto<TypeOfId> implements Serializable {
	@NotNull
	@Size(min = 1)
	private Set<TypeOfId> ids;
}
