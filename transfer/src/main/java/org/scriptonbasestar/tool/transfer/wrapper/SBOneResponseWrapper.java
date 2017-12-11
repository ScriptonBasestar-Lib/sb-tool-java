package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-08-25
 */
@Getter
@ToString
@EqualsAndHashCode
public class SBOneResponseWrapper<RESPONSE> {

	public static SBOneResponseWrapper create(){
		return new SBOneResponseWrapper<>();
	}

//	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBOneResponseWrapper<RESPONSE> leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}
	public SBOneResponseWrapper<RESPONSE> leadTimeCalc(long start, long end) {
		this.leadTime = end - start;
		return this;
	}
	public SBOneResponseWrapper<RESPONSE> leadTimeCalc(long start) {
		this.leadTime = System.currentTimeMillis() - start;
		return this;
	}

	private boolean success = true;
	public SBOneResponseWrapper<RESPONSE> success(RESPONSE data) {
		this.data = data;
		this.success = true;
		return this;
	}
	public SBOneResponseWrapper<RESPONSE> fail() {
		success = false;
		return this;
	}

	private String lang;
	public SBOneResponseWrapper<RESPONSE> lang(String lang){
		this.lang = lang;
		return this;
	}

	private String code;
	public SBOneResponseWrapper<RESPONSE> code(String code){
		this.code = code;
		return this;
	}

	private String message;
	public SBOneResponseWrapper<RESPONSE> message(String message){
		this.message = message;
		return this;
	}

	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();

	private RESPONSE data;
	public SBOneResponseWrapper<RESPONSE> data(RESPONSE data){
		this.data = data;
		return this;
	}

}
