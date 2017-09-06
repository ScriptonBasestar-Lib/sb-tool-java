package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2017-08-28
 */
@Data
public class SBPageResponseWrapper<RESPONSE> {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBPageResponseWrapper leadTime(long leadTime){
		this.leadTime = leadTime;
		return this;
	}
	private boolean success = true;
	public SBPageResponseWrapper<RESPONSE> fail(){
		success = false;
		return this;
	}

	private Collection<RESPONSE> data;
	private SCPage page;
}
