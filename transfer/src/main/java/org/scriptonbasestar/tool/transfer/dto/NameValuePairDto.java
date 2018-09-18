package org.scriptonbasestar.tool.transfer.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author archmagece
 * @with multilang-parent
 * @since 2015-09-16-18
 * <p>
 * for message find One
 */
@Data
public class NameValuePairDto implements Serializable {

	/**
	 * @param name  name
	 * @param value value
	 */
	public NameValuePairDto(String name, String value) {
		this.name = name;
		this.value = value;
	}

	private String name;
	@NotNull
	private String value;

}
