package org.scriptonbasestar.tool.data.mongo.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author archmagece
 * @since 2014. 7. 30.
 */
@Getter
@MappedSuperclass
public abstract class MongoBaseModel implements Serializable {

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return MoreObjects.toStringHelper(this);
	}
}
