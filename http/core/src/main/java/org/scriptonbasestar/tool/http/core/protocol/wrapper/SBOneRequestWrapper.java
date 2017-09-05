package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.Data;

/**
 * @author chaeeung.e
 * @since 2017-09-05
 */
@Data
public class SBOneRequestWrapper <REQUEST>{
	private String lang;
	private Long requestAt = System.currentTimeMillis();

	private REQUEST request;
}
