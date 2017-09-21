package org.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

/**
 * @author archmagece
 * @since 2015-05-07-13
 */
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public abstract class SBCodeNameEntityBase extends SBCodeEntityBase {

	@Size(min = 1, max = 50)
	@Column(length = 50)
	protected String name;


	@Override
	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("name", name);
	}
}
