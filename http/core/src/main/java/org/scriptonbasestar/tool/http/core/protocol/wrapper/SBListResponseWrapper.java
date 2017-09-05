package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-08-25
 */
@Data
public class SBListResponseWrapper<RESPONSE> {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBListResponseWrapper<RESPONSE> leadTime(long leadTime){
		this.leadTime = leadTime;
		return this;
	}
	private boolean success = true;
	public SBListResponseWrapper<RESPONSE> fail(){
		success = false;
		return this;
	}

	private Collection<RESPONSE> data;
}
