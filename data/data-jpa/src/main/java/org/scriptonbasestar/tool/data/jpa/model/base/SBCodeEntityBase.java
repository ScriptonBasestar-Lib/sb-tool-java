package org.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author archmagece
 * @since 2015-05-07-13
 */
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SBCodeEntityBase extends SBDataEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public SBCodeEntityBase(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	@NotNull
	@Size(min = 1, max = 30)
	@Column(length = 30, unique = true, nullable = false)
	protected String code;

	@Size(min = 1, max = 50)
	@Column(length = 50)
	protected String name;

	@Size(min = 2, max = 140)
	@Column(length = 140)
	protected String description;

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	@Override
	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
			.add("id", id)
			.add("code", code)
			.add("name", name)
			.add("description", description);
	}
}
