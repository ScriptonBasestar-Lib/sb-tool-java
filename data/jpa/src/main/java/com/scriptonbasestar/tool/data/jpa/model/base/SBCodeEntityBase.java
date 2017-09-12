package com.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
public abstract class SBCodeEntityBase extends SBEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 1, max = 30)
	@Column(length = 30, unique = true, nullable = false)
	protected String code;

	@Size(min = 2, max = 140)
	@Column(length = 140)
	protected String description;


	@Override
	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("id", id)
				.add("code", code)
				.add("description", description);
	}
}
