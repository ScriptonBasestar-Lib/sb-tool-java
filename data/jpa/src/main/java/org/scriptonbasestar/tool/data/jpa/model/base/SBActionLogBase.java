package org.scriptonbasestar.tool.data.jpa.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SBActionLogBase extends SBLogEntityBase {

	protected SBActionLogBase(Date actionTime, Long itemCount, boolean isSuccess) {
		this.actionTime = actionTime;
		this.itemCount = itemCount;
		this.isSuccess = isSuccess;
	}


	/**
	 * 작업 발생 시각
	 */
	//	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Temporal(TemporalType.DATE)
	@Column(name = "ActionTime")
	private Date actionTime;

	/**
	 * 작업 처리한 항목 수
	 */
	@Basic
	private Long itemCount;

	/**
	 * 작업 결과
	 */
	@Basic
	private boolean isSuccess;

	/**
	 * 작업 시 예외가 있는 경우 stackTrace 정보를 저장한다.
	 */
	@Column(name = "StackTrace", length = 4000)
	private String stackTrace;
}
