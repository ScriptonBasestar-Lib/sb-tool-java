package org.scriptonbasestar.tool.collection.builder;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author archmagece
 * @since 2017-09-06
 */
public class BuilderTest {

	@Test
	public void test_ListBuilder_create() {
		List<Integer> ints1 = ListBuilder.<Integer>create().add(1).add(2).build();
		List<Integer> ints2 = ListBuilder.create(Integer.class).add(1).add(2).build();
		List<Integer> ints3 = ListBuilder.create(1).add(2).add(3).build();
		List<Integer> ints4 = ListBuilder.create(1, 2, 3).build();
	}

	@Test
	public void test_MapBuilder_create() {
		Map<Integer, String> map1 = MapBuilder.<Integer, String>create().add(0, "kim").add(1, "chi").build();
		Map<Integer, String> map2 = MapBuilder.create(Integer.class, String.class).add(0, "kim").add(1, "chi").build();
		Map<Integer, String> map3_0 = new HashMap<>();
		map3_0.put(0, "kim");
		map3_0.put(1, "chi");
		Map<Integer, String> map3 = MapBuilder.create(map3_0).build();
	}

	@Test
	public void test_SetBuilder_create() {
		Set<Integer> ints1 = SetBuilder.<Integer>create().add(1).add(2).build();
		Set<Integer> ints2 = SetBuilder.create(Integer.class).add(1).add(2).build();
		Set<Integer> ints3 = SetBuilder.create(1).add(2).add(3).build();
		Set<Integer> ints4 = SetBuilder.create(1, 2, 3).build();
	}
}
