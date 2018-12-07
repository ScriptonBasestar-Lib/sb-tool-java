package org.scriptonbasestar.tool.core.reflection

import org.junit.Test

/**
 * @author chaeeung.e* @since 2017-11-02
 */
class DtoToHashTest {

	class Animal {
		String name
		double height
		long weight
	}

	@Test
	void test_by_field() {
		Animal animal = new Animal();
		animal.name = "고양이"
		animal.height = 150
		animal.weight = 30
		println(ReflectionUtil.extractFieldNames(animal))
		println(ReflectionUtil.mappingDtoField2Map(animal))
	}

	@Test
	void test_by_getter() {
		Animal animal = new Animal()
		animal.name = "고양이"
		animal.height = 150
		animal.weight = 30
		println(ReflectionUtil.extractGetterNames(animal))
		println(ReflectionUtil.mappingGetterDto2Map(animal))
	}
}
