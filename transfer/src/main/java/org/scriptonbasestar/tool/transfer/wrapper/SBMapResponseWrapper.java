package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-08-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> {

	public static <RESPONSE_ID, RESPONSE_DATA> SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> create() {
		return new SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA>();
	}

	//	@Setter(AccessLevel.PROTECTED)
	private long leadTime;

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> leadTimeCalc(long start, long end) {
		this.leadTime = end - start;
		return this;
	}

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> leadTimeCalc(long start) {
		this.leadTime = System.currentTimeMillis() - start;
		return this;
	}

	private boolean success = true;

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> success() {
		this.success = true;
		return this;
	}

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> success(Map<RESPONSE_ID, RESPONSE_DATA> data) {
		this.data = data;
		this.success = true;
		return this;
	}

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> fail() {
		success = false;
		return this;
	}

	private String lang;

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> lang(String lang) {
		this.lang = lang;
		return this;
	}

	private String code;

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> code(String code) {
		this.code = code;
		return this;
	}

	private String message;

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> message(String message) {
		this.message = message;
		return this;
	}

	protected Set<Map<String, String>> validationErrorSet = new HashSet<>();

	private Map<RESPONSE_ID, RESPONSE_DATA> data;

	public SBMapResponseWrapper<RESPONSE_ID, RESPONSE_DATA> data(Map<RESPONSE_ID, RESPONSE_DATA> data) {
		this.data = data;
		return this;
	}

}
