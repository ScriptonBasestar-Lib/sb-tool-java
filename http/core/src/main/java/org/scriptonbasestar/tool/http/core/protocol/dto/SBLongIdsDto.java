package org.scriptonbasestar.tool.http.core.protocol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chaeeung.e
 * @since 2017-08-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SBLongIdsDto {
	private Long[] ids;
}
