package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.scriptonbasestar.tool.transfer.dto.SBPageDto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-08-28
 */
@Data
public class SBPageResponseWrapper<RESPONSE> {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;

	public SBPageResponseWrapper leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}

	private boolean success = true;

	public SBPageResponseWrapper<RESPONSE> fail() {
		success = false;
		return this;
	}

	private String lang;
	private String message;
	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();

	private Collection<RESPONSE> data;
	private SBPageDto page;
}
