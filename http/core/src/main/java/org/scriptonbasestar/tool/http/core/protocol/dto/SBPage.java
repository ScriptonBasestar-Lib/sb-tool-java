package org.scriptonbasestar.tool.http.core.protocol.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chaeeung.e
 * @since 2017-08-30
 */
@Data
@NoArgsConstructor
public class SBPage {

	public SBPage(int pageNo, int pageSize, long totalElements){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = (int)(totalElements / pageSize) + 1;
	}

	private int pageNo;
	private int pageSize;

	private long totalElements;
	private int totalPages;
}
