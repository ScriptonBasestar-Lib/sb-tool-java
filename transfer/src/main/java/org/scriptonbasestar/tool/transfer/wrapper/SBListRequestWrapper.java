package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author archmagece
 * @since 2017-09-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SBListRequestWrapper {
	private String lang;
	private String nonce;
	private Long requestAt;
}
