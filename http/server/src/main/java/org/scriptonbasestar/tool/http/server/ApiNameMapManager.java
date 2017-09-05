package org.scriptonbasestar.tool.http.server;


import org.scriptonbasestar.tool.http.server.dto.BSKey;
import org.scriptonbasestar.tool.http.server.dto.BSParamMap;
import org.scriptonbasestar.tool.http.server.dto.BSValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiNameMapManager {


	private Map<BSKey, BSValue> map1 = new HashMap<BSKey, BSValue>();
	private Map<BSKey, List<BSParamMap>> map2 = new HashMap<BSKey, List<BSParamMap>>();
	//싱글톤형태.
	private static final ApiNameMapManager eventManager = new ApiNameMapManager();

	private ApiNameMapManager() {
	}

	public static ApiNameMapManager getInstance() {
		return eventManager;
	}

	public ApiNameMapManager add(BSKey key, BSValue val, List<BSParamMap> param) {
		// 추가할 때 id인덱스도 추가
		synchronized (eventManager) {
			map1.put(key, val);
			map2.put(key, param);
		}
		return eventManager;
	}

	//쓸일없음..거의.. 다이네믹처리를 하게되면 필요할수도있다.
	public ApiNameMapManager remove(BSKey key) {
		synchronized (eventManager) {
			map1.remove(key);
			map2.remove(key);
		}
		return eventManager;
	}

//	public BSValue access(BSKey key) throws ParamValidator{
	public BSValue get(BSKey key) {
		return map1.get(key);
	}

	public List<BSParamMap> get2(BSKey key) {
		return map2.get(key);
	}
	
	public Set<BSKey> keySet(){
		return map1.keySet();
	}
}
