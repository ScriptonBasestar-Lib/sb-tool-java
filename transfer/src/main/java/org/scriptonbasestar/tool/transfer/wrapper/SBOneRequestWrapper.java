package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.Data;

/**
 * @author archmagece
 * @since 2017-09-06
 */
@Data
public class SBOneRequestWrapper {
	private String lang;
	private String nonce;
	private Long requestAt;
}
