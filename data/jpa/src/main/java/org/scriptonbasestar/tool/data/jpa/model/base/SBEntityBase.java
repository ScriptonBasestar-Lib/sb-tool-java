package org.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author archmagece
 * @since 2014. 7. 30.
 */
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SBEntityBase implements Serializable {

	//	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, insertable = true, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	//	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.DATE)
	private Date updatedAt;


	@PrePersist
	protected void onCreate() {
		this.createdAt = this.updatedAt = new Date();
//		this.active = true;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return MoreObjects.toStringHelper(this);
	}
}
