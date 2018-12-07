package org.scriptonbasestar.tool.http.server;


import org.scriptonbasestar.tool.http.server.dto.SBKey;
import org.scriptonbasestar.tool.http.server.dto.SBParamMap;
import org.scriptonbasestar.tool.http.server.dto.SBValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiNameMapManager {


	private Map<SBKey, SBValue> map1 = new HashMap<SBKey, SBValue>();
	private Map<SBKey, List<SBParamMap>> map2 = new HashMap<SBKey, List<SBParamMap>>();
	//싱글톤형태.
	private static final ApiNameMapManager eventManager = new ApiNameMapManager();

	private ApiNameMapManager() {
	}

	public static ApiNameMapManager getInstance() {
		return eventManager;
	}

	public ApiNameMapManager add(SBKey key, SBValue val, List<SBParamMap> param) {
		// 추가할 때 id인덱스도 추가
		synchronized (eventManager) {
			map1.put(key, val);
			map2.put(key, param);
		}
		return eventManager;
	}

	//쓸일없음..거의.. 다이네믹처리를 하게되면 필요할수도있다.
	public ApiNameMapManager remove(SBKey key) {
		synchronized (eventManager) {
			map1.remove(key);
			map2.remove(key);
		}
		return eventManager;
	}

	//	public SBValue access(SBKey key) throws ParamValidator{
	public SBValue get(SBKey key) {
		return map1.get(key);
	}

	public List<SBParamMap> get2(SBKey key) {
		return map2.get(key);
	}

	public Set<SBKey> keySet() {
		return map1.keySet();
	}
}
