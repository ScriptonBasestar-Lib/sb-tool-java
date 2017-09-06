package org.scriptonbasestar.tool.http.core.protocol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author archmagece
 * @since 2017-08-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SBPageable {
	private int pageNo = 0;
	private int pageSize = 10;
}
