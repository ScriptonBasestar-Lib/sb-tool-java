package org.scriptonbasestar.tool.transfer.wrapper;

import org.junit.Ignore;
import org.junit.Test;
import org.scriptonbasestar.tool.transfer.dto.CommonLongIdDto;

/**
 * @author archmagece
 * @since 2017-10-12
 */
public class GenericCreationJavaTest {

	SBListResponseWrapper<CommonLongIdDto> upload1() {
		SBListResponseWrapper<CommonLongIdDto> wr = new SBListResponseWrapper<CommonLongIdDto>().code("cococode").fail();
		return wr;
	}

	SBListResponseWrapper<CommonLongIdDto> upload3() {
		SBListResponseWrapper<CommonLongIdDto> wr = SBListResponseWrapper.<CommonLongIdDto>create();
		return wr;
	}

	@Test
	@Ignore
	public void test() {
		upload1();
		upload3();
	}

}
