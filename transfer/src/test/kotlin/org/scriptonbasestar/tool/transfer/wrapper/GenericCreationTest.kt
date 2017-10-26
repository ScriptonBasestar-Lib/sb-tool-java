package org.scriptonbasestar.tool.transfer.wrapper

import org.junit.Ignore
import org.junit.Test
import org.scriptonbasestar.tool.transfer.dto.CommonLongIdDto

/**
 * @author archmagece
 * @since 2017-10-12
 */
class GenericCreationTest {

	fun upload1(): SBListResponseWrapper<CommonLongIdDto> {
		var wr : SBListResponseWrapper<CommonLongIdDto> = SBListResponseWrapper<CommonLongIdDto>().code("cococode").fail()
		return wr
	}
//	fun upload2(): SBListResponseWrapper<CommonLongIdDto> {
//		var wr : SBListResponseWrapper<CommonLongIdDto> = SBListResponseWrapper.create(CommonLongIdDto::class.java)
//		return wr
//	}

	@Test
	@Ignore
	fun test(){
		upload1()
//		upload2()
	}
}