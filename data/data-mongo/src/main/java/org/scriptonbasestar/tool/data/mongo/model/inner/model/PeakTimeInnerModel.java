package org.scriptonbasestar.tool.data.mongo.model.inner.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scriptonbasestar.tool.core.type.WeekdayType;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author archmagece
 * @since 2015-06-01-18
 */
//@Document
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class PeakTimeInnerModel
	implements Serializable {
	@PersistenceConstructor
	public PeakTimeInnerModel(WeekdayType weekday, int from, int to) {
		this.weekday = weekday;
		this.from = from;
		this.to = to;
	}

	private WeekdayType weekday;
	@Min(0)
	@Max(24)
	private int from;
	@Min(0)
	@Max(24)
	private int to;
}
