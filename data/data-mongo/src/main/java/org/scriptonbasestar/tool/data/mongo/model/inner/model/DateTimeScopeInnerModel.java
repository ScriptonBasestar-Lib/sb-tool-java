package org.scriptonbasestar.tool.data.mongo.model.inner.model;

import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author archmagece
 * @since 2015-06-02-16
 */
//@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DateTimeScopeInnerModel implements Serializable {
	@PersistenceConstructor
	public DateTimeScopeInnerModel(Date fromDate, Date toDate) {
		//TODO from < to
		//TODO not null
		this.fromDate = fromDate;
		//TODO not null
		this.toDate = toDate;
	}

	private Date fromDate;
	private Date toDate;
}
