package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.Data;

import java.util.List;

/**
 * @author archmagece
 * @since 2017-09-05
 */
@Data
public class SBListRequestWrapper <REQUEST> {
	private String lang;
	private Long requestAt = System.currentTimeMillis();

	private List<REQUEST> request;
}
