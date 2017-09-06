package org.scriptonbasestar.tool.collection.creator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.scriptonbasestar.tool.collection.extractor.Extractor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author archmagece
 * @since 2017-09-06
 */
public class ExtractorTest {

	@Data
	@AllArgsConstructor
	public static class TestUser{
		private Long id;
		private String name;
		private String mobile;
	}

	@Test
	public void test_run() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
		List<TestUser> list = new ArrayList<>();
		list.add(new TestUser(1L, "김a", "01011112222"));
		list.add(new TestUser(2L, "김b", "01011113333"));
		list.add(new TestUser(3L, "김c", "01011114444"));

		List<String> resultList = Extractor.extract(list, "name");
		System.out.println(resultList);
	}
}
