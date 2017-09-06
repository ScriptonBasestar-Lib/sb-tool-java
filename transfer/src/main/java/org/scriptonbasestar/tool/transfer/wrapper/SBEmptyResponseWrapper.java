package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-08-25
 */
@Data
public class SBEmptyResponseWrapper {
	@Setter(AccessLevel.PROTECTED)
	private long leadTime;

	public SBEmptyResponseWrapper leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}

	private boolean success = true;

	public SBEmptyResponseWrapper fail() {
		success = false;
		return this;
	}

	private String lang;
	private String message;
	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();
}
