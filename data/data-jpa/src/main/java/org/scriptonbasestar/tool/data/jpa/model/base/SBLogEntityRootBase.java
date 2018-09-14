package org.scriptonbasestar.tool.data.jpa.model.base;

import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@MappedSuperclass
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SBLogEntityRootBase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Transient
	private Long id;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	/**
	 * 설명
	 */
	@Setter
	@Size(min = 2, max = 2000)
	@Column(length = 2000)
	protected String description;


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return MoreObjects.toStringHelper(this);
	}
}
