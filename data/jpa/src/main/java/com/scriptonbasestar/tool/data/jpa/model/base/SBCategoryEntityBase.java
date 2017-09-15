package com.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author archmagece
 * @since 2014. 7. 30.
 */
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public abstract class SBCategoryEntityBase extends SBEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true)
	protected String name;
	protected String description;

	@PrePersist
	protected void onCreate() {
		super.onCreate();
	}

	@Override
	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("name", name)
				.add("description", description);
	}
}
