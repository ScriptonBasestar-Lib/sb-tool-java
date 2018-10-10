package org.scriptonbasestar.tools.collection.extractor;

import lombok.experimental.UtilityClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2014-12-10-11
 */
@UtilityClass
public class Extractor {

	/**
	 * Collection &gt; ITEM &lt; 에서 ITEM.field를 List로 가져옴.
	 *
	 * @param collection
	 * @param fieldName
	 * @param <ITEM>
	 * @param <RESULT>
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	public static <ITEM, RESULT> List<RESULT> extract(Collection<ITEM> collection, String fieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
		Iterator<ITEM> itr = collection.iterator();
		Class<?> clazz = null;
		Method method = null;
		//1번 엔티티 먼저 빼서 method reflection
		ITEM entity1 = itr.next();
		clazz = entity1.getClass();
		method = clazz.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
		List<RESULT> resultList = new ArrayList<>();
		//1번 Entity 먼저 뺀거 넣고
		resultList.add((RESULT) method.invoke(entity1));
		while (itr.hasNext()) {
			resultList.add((RESULT) method.invoke(itr.next()));
		}
		return resultList;
	}

}
