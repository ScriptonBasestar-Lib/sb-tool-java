package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-08-25
 */
@Data
public class SBListResponseWrapper<RESPONSE> {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;

	public SBListResponseWrapper<RESPONSE> leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}

	private boolean success = true;

	public SBListResponseWrapper<RESPONSE> fail() {
		success = false;
		return this;
	}

	private String lang;
	private String message;
	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();

	private Collection<RESPONSE> data;
}
