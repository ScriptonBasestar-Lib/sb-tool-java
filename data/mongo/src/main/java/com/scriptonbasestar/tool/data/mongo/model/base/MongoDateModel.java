package com.scriptonbasestar.tool.data.mongo.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by archmagece on 2015-10-01.
 */
@Getter
@MappedSuperclass
public abstract class MongoDateModel extends MongoBaseModel {

	@Indexed(direction = IndexDirection.DESCENDING)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@CreatedDate
	protected Date createdAt;

	@Indexed(direction = IndexDirection.DESCENDING)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@LastModifiedDate
	protected Date updatedAt;

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("createdAt", createdAt)
				.add("updatedAt", updatedAt);
	}
}
