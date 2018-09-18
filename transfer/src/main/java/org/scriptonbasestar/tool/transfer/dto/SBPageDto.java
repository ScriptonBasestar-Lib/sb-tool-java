package org.scriptonbasestar.tool.transfer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author archmagece
 * @since 2017-08-30
 */
@NoArgsConstructor
@Data
public class SBPageDto {

	public SBPageDto(int pageNo, int pageSize, long totalElements) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = (int) (totalElements / pageSize) + 1;
	}

	private int pageNo = 0;
	private int pageSize = 10;

	private long totalElements;
	private int totalPages;
}
