package com.scriptonbasestar.tool.data.jpa.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SBLogEntityBase
		extends SBEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Transient
	private Long id;

	/**
	 * 설명
	 */
	@Size(min = 2, max = 2000)
	@Column(length = 2000)
	protected String description;
}
