package org.scriptonbasestar.tool.data.jpa.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_WORK_LOG",
		indexes = {@Index(name = "ix_worklog_time",
				columnList = "LogKind,StartTime,EndTime")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "LogKind")
@DiscriminatorValue("WorkLog")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SBWorkLogBase extends SBLogEntityRootBase {

	protected SBWorkLogBase(Date startTime, Date endTime, Long itemCount, boolean isSuccess) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.itemCount = itemCount;
		this.isSuccess = isSuccess;
	}

	/**
	 * 작업 시작 시각
	 */
	//	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Temporal(TemporalType.DATE)
	private Date startTime;

	/**
	 * 작업 완료 시각
	 */
	//	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Temporal(TemporalType.DATE)
	private Date endTime;

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
	@Column(length = 4000)
	private String stackTrace;

	/**
	 * 작업 예외 시에 StackTrace 정보를 저장하도록 합니다.
	 *
	 * @param exception 작업 예외
	 */
	@Transient
	public void setException(Throwable exception) {
		stackTrace = ExceptionUtils.getStackTrace(exception);
	}

	/**
	 * 작업 시간
	 */
	@Transient
	public long getWorkTime() {
		return endTime.getTime() - startTime.getTime();
	}
}
