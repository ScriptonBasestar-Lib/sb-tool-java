package org.scriptonbasestar.tool.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author archmagece
 * @date 2015-12-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonStringCodeDto implements Serializable {
	@NotNull
	@Size(min = 1)
	private String code;
}
