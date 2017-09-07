package com.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;

/**
 * @author archmagece
 * @since 2014. 7. 30.
 */
@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BSEntityBase implements Serializable {

	//	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, insertable = true, updatable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime createdAt;

	//	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, insertable = true, updatable = true)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedAt;


	@PrePersist
	protected void onCreate() {
		this.createdAt = this.updatedAt = DateTime.now();
//		this.active = true;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = DateTime.now();
	}

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return MoreObjects.toStringHelper(this);
	}
}
