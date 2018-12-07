package org.scriptonbasestar.tool.transfer.wrapper

import org.junit.Test
import org.scriptonbasestar.tool.collection.builder.SetBuilder
import org.scriptonbasestar.tool.transfer.wrapper.SBListResponseWrapper

/**
 * @author chaeeung.e
 * @since 2017-10-23
 */
class WrapperTest {
	@Test
	fun wrapperCreationTest() {
		var wrapper1_1 = SBListResponseWrapper<Long>().data(SetBuilder.create<Long>().add(3).build()).success()
		var wrapper1_2 = SBListResponseWrapper<String>().data(SetBuilder.create<String>().add("ddd").build()).success()
		println(wrapper1_1)
		println(wrapper1_2)

		var wrapper2_1 = SBListResponseWrapper.create<Long>().data(SetBuilder.create<Long>().add(3).build()).success()
//		var wrapper2_2 :SBListResponseWrapper<String> = SBListResponseWrapper.create().data(SetBuilder.create<String>().add("ddd").build()).success(true)
		println(wrapper2_1)
//		println(wrapper2_2)
	}
}
