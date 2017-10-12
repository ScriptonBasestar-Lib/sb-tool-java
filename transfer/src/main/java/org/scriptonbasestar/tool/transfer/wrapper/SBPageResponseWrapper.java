package org.scriptonbasestar.tool.transfer.wrapper;

import lombok.*;
import org.scriptonbasestar.tool.transfer.dto.SBPageDto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-08-28
 */
@Getter
@ToString
@EqualsAndHashCode
public class SBPageResponseWrapper<RESPONSE> {

	public static SBPageResponseWrapper create(){
		return new SBPageResponseWrapper<>();
	}

//	@Setter(AccessLevel.PROTECTED)
	private long leadTime;
	public SBPageResponseWrapper<RESPONSE> leadTime(long leadTime) {
		this.leadTime = leadTime;
		return this;
	}
	public SBPageResponseWrapper leadTimeCalc(long start, long end) {
		this.leadTime = end - start;
		return this;
	}
	public SBPageResponseWrapper leadTimeCalc(long start) {
		this.leadTime = System.currentTimeMillis() - start;
		return this;
	}

	private boolean success = true;
	public SBPageResponseWrapper<RESPONSE> fail() {
		success = false;
		return this;
	}

	private String lang;
	public SBPageResponseWrapper<RESPONSE> lang(String lang){
		this.lang = lang;
		return this;
	}

	private String code;
	public SBPageResponseWrapper<RESPONSE> code(String code){
		this.code = code;
		return this;
	}

	private String message;
	public SBPageResponseWrapper<RESPONSE> message(String message){
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
	public SBPageResponseWrapper<RESPONSE> data(SBPageDto data){
		this.page = page;
		return this;
	}

}
