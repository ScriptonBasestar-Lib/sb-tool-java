package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.Data;
import org.scriptonbasestar.tool.transfer.dto.OrderDto;

import java.util.List;

/**
 * @author archmagece@gmail.com
 * @since 2017-12-26 오후 2:13
 */
@Data
public class SBPageRequestWrapper<REQUEST> {
	//unique request id. cache 10min?
	private String nonce;
	//current page
	private int page = 0;
	//page size
	private int size = 10;

	//sort
	private List<OrderDto> sort;

	private REQUEST request;
}
