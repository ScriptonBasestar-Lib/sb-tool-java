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

	public static SBEmptyResponseWrapper create(){
		return new SBEmptyResponseWrapper();
	}

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
	public SBEmptyResponseWrapper lang(String lang){
		this.lang = lang;
		return this;
	}

	private String code;
	public SBEmptyResponseWrapper code(String code){
		this.code = code;
		return this;
	}

	private String message;
	public SBEmptyResponseWrapper message(String message){
		this.message = message;
		return this;
	}

	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();

}
