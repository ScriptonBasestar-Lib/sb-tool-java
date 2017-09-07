package com.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 * @author archmagece
 * @since 2014. 7. 30.
 */
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
public abstract class BSActiveEntityBase extends BSEntityBase {

	/**
	 * 삭제 플래그
	 */
	@Column(nullable = false, insertable = true, updatable = true)
	@Getter
	@Setter
	protected boolean active = true;

	/**
	 * 관리자가 처리하는 블라인드처리 등의 용도.
	 */
	@Column(nullable = false, insertable = true, updatable = true)
	@Getter
	@Setter
	protected boolean enabled = true;

	@PrePersist
	protected void onCreate() {
		super.onCreate();
	}

	@Override
	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("active", active)
				.add("enabled", enabled);
	}
}
