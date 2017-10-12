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

	public static <RESPONSE_NEW>SBPageResponseWrapper create(){
		return new SBPageResponseWrapper<RESPONSE_NEW>();
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
	public SBPageResponseWrapper data(Collection<RESPONSE> data){
		this.data = data;
		return this;
	}

	private SBPageDto page;
	public SBPageResponseWrapper data(SBPageDto data){
		this.page = page;
		return this;
	}

}
