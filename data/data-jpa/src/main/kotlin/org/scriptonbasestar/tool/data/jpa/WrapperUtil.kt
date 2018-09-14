package org.scriptonbasestar.tool.data.jpa

import org.scriptonbasestar.tool.transfer.dto.OrderDto
import org.scriptonbasestar.tool.transfer.wrapper.SBPageRequestWrapper
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

/**
 * @author archmagece@gmail.com
 * @since 2017-12-26 오후 4:21
 */
class WrapperUtil {
	companion object {
		@JvmStatic
		fun translatePageRequest(requestWrapper: SBPageRequestWrapper<*>): PageRequest {
			return PageRequest(requestWrapper.page, requestWrapper.size, translateSort(requestWrapper.sort))
		}

		@JvmStatic
		fun translateSort(sort: List<OrderDto>?): Sort? {
			if (sort == null || sort.isEmpty()) {
				return null
			}
			val orderList = sort.mapTo(ArrayList<Sort.Order>()) {
				Sort.Order(
						Sort.Direction.fromString(it.direction.name), it.column
				)
			}
			return Sort(orderList)
		}
	}
}