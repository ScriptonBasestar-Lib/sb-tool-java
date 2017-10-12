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

	public static <RESPONSE_NEW>SBListResponseWrapper create(){
		return new SBListResponseWrapper<RESPONSE_NEW>();
	}
	public static <RESPONSE_NEW>SBListResponseWrapper create(Class<RESPONSE_NEW> clazz){
		return new SBListResponseWrapper<RESPONSE_NEW>();
	}

//	@Setter(AccessLevel.PROTECTED)
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
