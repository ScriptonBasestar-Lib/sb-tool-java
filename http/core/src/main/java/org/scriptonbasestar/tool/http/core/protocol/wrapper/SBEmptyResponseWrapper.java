package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author chaeeung.e
 * @since 2017-08-25
 */
@Data
public class SBEmptyResponseWrapper {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBEmptyResponseWrapper leadTime(long leadTime){
		this.leadTime = leadTime;
		return this;
	}
	private boolean success = true;
	public SBEmptyResponseWrapper fail(){
		success = false;
		return this;
	}
}
