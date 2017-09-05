package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author chaeeung.e
 * @since 2017-08-25
 */
@Data
public class SBOneResponseWrapper<RESPONSE> {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBOneResponseWrapper leadTime(long leadTime){
		this.leadTime = leadTime;
		return this;
	}
	private boolean success = true;
	public SBOneResponseWrapper<RESPONSE> fail(){
		success = false;
		return this;
	}

	private RESPONSE data;
}
