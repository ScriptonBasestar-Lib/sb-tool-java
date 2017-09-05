package org.scriptonbasestar.tool.core.result;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-09-14-20
 * <p>
 * paging에 필요한 최소한의 값들.
 * <p>
 * row 최소단위, 글1줄 또는 데이터1개 (article, post ...)
 * pageSize 한번에 로딩할 row의 크기
 * filteredRowCount totalRowCount가 아니고 filteredRowCount를 사용하는 이유는
 * 디비나 데이터셋에 있는 모든 데이터의 개수가 아닌, 검색되어 나온 데이터의 총 크기가 중요하기 때문.
 * 요즘은 데이터의 총량 자체를 계산하는것도 힘들어지고 또한 무의미한 경우가 많다. totalDatacount는 요청시마다 계산하기보다는 필요한 저장된 값을 사용하는것으로
 * <p>
 * 검색 기능이 추가되게 되면 다른 데이터가 추가로 필요할 수도 있지만.. PagingValue에 포함될 필요는 없어보인다.
 * <p>
 * rowCount대신에 pageCount로 대체하는 경우도 생각할 수 있는데 그 경우 나머지가 버림될 수 있으므로 rowCount를 사용하는게 나아보인다.
 */
@Data
public class PagingValue {

	public PagingValue(long pageNo, long pageSize, long filteredRowCount, boolean finish) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.filteredRowCount = filteredRowCount;
		this.finish = finish;
	}

	/**
	 * 페이지 번호
	 * Request/Response
	 */
	@Min(0)
	protected long pageNo;

	/**
	 * 한 페이지에 들어갈 로우 수
	 * Request/Response
	 */
	@Min(1)
	protected long pageSize;

	/**
	 * 검색된 로우수
	 * Request/Response
	 */
	@Min(0)
	protected long filteredRowCount;

	/**
	 * Response
	 */
	private boolean finish = false;

}
