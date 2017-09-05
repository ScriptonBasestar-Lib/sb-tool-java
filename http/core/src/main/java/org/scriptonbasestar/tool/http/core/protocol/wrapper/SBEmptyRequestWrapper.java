package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.Data;

/**
 * @author chaeeung.e
 * @since 2017-09-05
 */
@Data
public class SBEmptyRequestWrapper {
	private String lang;
	private Long requestAt = System.currentTimeMillis();
}
