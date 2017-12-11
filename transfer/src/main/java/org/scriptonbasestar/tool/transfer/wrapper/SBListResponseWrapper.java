package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.*;

import java.util.Collection;
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
public class SBListResponseWrapper<RESPONSE> {

	public static SBListResponseWrapper create(){
		return new SBListResponseWrapper<>();
	}

//	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBListResponseWrapper<RESPONSE> leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}
	public SBListResponseWrapper<RESPONSE> leadTimeCalc(long start, long end) {
		this.leadTime = end - start;
		return this;
	}
	public SBListResponseWrapper<RESPONSE> leadTimeCalc(long start) {
		this.leadTime = System.currentTimeMillis() - start;
		return this;
	}

	private boolean success = true;
	public SBListResponseWrapper<RESPONSE> success(Collection<RESPONSE> data) {
		this.data = data;
		this.success = true;
		return this;
	}
	public SBListResponseWrapper<RESPONSE> fail() {
		success = false;
		return this;
	}

	private String lang;
	public SBListResponseWrapper<RESPONSE> lang(String lang){
		this.lang = lang;
		return this;
	}

	private String code;
	public SBListResponseWrapper<RESPONSE> code(String code){
		this.code = code;
		return this;
	}

	private String message;
	public SBListResponseWrapper<RESPONSE> message(String message){
		this.message = message;
		return this;
	}

	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();

	private Collection<RESPONSE> data;
	public SBListResponseWrapper<RESPONSE> data(Collection<RESPONSE> data){
		this.data = data;
		return this;
	}

}
