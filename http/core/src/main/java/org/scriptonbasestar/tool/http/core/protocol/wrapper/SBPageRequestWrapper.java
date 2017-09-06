package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import org.scriptonbasestar.tool.http.core.protocol.dto.SBPageable;

/**
 * @author archmagece
 * @since 2017-09-05
 */
public class SBPageRequestWrapper {
	private String lang;
	private Long requestAt = System.currentTimeMillis();

	private SBPageable pageable;
}
