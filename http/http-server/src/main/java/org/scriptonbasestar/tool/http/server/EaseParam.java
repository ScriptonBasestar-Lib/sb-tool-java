package org.scriptonbasestar.tool.http.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class EaseParam {

	public Map<String, Object> map;

	public EaseParam() {
		map = new HashMap<String, Object>();
	}

	public EaseParam(Map<String, Object> map) {
		this.map = map;
	}

	public static EaseParam create() {
		return new EaseParam();
	}

	public static EaseParam create(Map<String, Object> map) {
		return new EaseParam(map);
	}

	private void init() {
//		for(SBParam bsParam : bsParamMap.params){
//			
//		}
	}

	public EaseParam addAll(Map<String, Object> map) {
		this.map.putAll(map);
		return this;
	}

	public EaseParam time(String stime, String etime) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		this.map.put("stime", format.parseObject(stime));
		this.map.put("etime", format.parseObject(etime));
		return this;
	}

	public EaseParam timeStr(String stime, String etime) {
		this.map.put("stime", stime);
		this.map.put("etime", etime);
		return this;
	}

	public EaseParam param(String key, Object value) throws EaseParamValidationException {
		this.map.put(key, value);
		return this;
	}

}
