package org.scriptonbasestar.tool.data.mongo.model.base;

/**
 * Created by archmagece on 2015-10-01.
 */

import com.google.common.base.MoreObjects;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public abstract class MongoNameValueBaseModel extends MongoDateModel {

	@Id
	private String id;
//	private ObjectId id;

	@Indexed
	private String name;
	@TextIndexed
	private String value;

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("id", id)
				.add("name", name)
				.add("value", value);
	}
}
