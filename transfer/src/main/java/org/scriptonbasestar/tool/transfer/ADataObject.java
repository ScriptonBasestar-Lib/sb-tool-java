package org.scriptonbasestar.tool.transfer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2015-09-14-20
 * <p>
 * results는 무조건 목록으로 보낸다. Collection을 쓸 수도 있지만 List가 가장 일반적으로 많이 사용된다.
 * Set을 사용하는 경우 중복데이터가 필요한 경우를 포괄할 수 없다.
 * Generic으로 데이터 입력에 자유도를 추가할 수도 있지만 일부 라이브러리에서 json serialization할 때 오류가 발생하는 경우가 있었다.
 * <p>
 * pagingValue는 페이징에 필요한 데이터들.
 */
@Data
public abstract class ADataObject<DATA extends Serializable> {
	//nullable
	protected List<DATA> results;
	//nullable
	protected PagingValue pagingValue;
}
