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

	public static SBPageResponseWrapper create(){
		return new SBPageResponseWrapper();
	}

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
	public SBPageResponseWrapper lang(String lang){
		this.lang = lang;
		return this;
	}

	private String code;
	public SBPageResponseWrapper code(String code){
		this.code = code;
		return this;
	}

	private String message;
	public SBPageResponseWrapper message(String message){
		this.message = message;
		return this;
	}

	protected Set<Map<String,String>> validationErrorSet = new HashSet<>();

	private Collection<RESPONSE> data;
	private SBPageDto page;

}
