package org.scriptonbasestar.tool.data.jpa.hibernate;

import org.hibernate.mapping.PersistentClass;
import org.hibernate.tuple.Instantiator;
import org.hibernate.tuple.entity.EntityMetamodel;
import org.hibernate.tuple.entity.PojoEntityTuplizer;

import java.io.Serializable;

/**
 * @author : archmagece@gmail.com
 * @since: 2013-07-21 15:15
 */
public class EnumTuplizer extends PojoEntityTuplizer {
	public EnumTuplizer(EntityMetamodel entityMetamodel, PersistentClass mappedEntity) {
		super(entityMetamodel, mappedEntity);
	}

	@Override
	protected Instantiator buildInstantiator(EntityMetamodel entityMetamodel, PersistentClass persistentClass) {
		return new Instantiator() {
			@Override
			public Object instantiate(Serializable id) {
				try {
					return Enum.valueOf(
							(Class) persistentClass.getClass().getClassLoader().loadClass(persistentClass.getClassName()),
							(String) id
					);
				} catch (ClassNotFoundException e) {
					throw new AssertionError(e);
				}
			}

			@Override
			public Object instantiate() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isInstance(Object object) {
				throw new UnsupportedOperationException();
			}
		};
	}
}
