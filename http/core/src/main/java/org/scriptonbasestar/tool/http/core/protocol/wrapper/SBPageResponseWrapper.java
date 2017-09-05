package org.scriptonbasestar.tool.http.core.protocol.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.scriptonbasestar.tool.http.core.protocol.dto.SBPage;

import java.util.Collection;

/**
 * @author chaeeung.e
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
	private SBPage page;
}
