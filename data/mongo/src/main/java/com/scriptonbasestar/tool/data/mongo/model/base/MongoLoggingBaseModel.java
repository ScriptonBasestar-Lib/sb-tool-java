package com.scriptonbasestar.tool.data.mongo.model.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import org.scriptonbasestar.tool.core.type.LoggingLevel;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.TextIndexed;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by archmagece on 2015-10-01.
 */
@Getter
@CompoundIndexes({
		@CompoundIndex(name = "log_idx", def = "{'timestamp': -1, 'level': 1, 'logger': 1, 'thread': 1}")
})
@MappedSuperclass
public abstract class MongoLoggingBaseModel extends MongoDateModel {

	@Id
	private String id;
//	private ObjectId id;

	//이벤트 발생시각
	//@Indexed(direction = IndexDirection.DESCENDING)
	private Date timestamp;
	//로깅레벨
	private LoggingLevel level;
	//클래스명. 로거
	private String logger;
	//스레드명
	private String thread;

	//로그 메세지
	@TextIndexed
	private String message;

	@Override
	public String toString() {
		return this.buildStringHelper().toString();
	}

	protected MoreObjects.ToStringHelper buildStringHelper() {
		return super.buildStringHelper()
				.add("id", id)
				.add("timestamp", timestamp)
				.add("level", level)
				.add("logger", logger)
				.add("thread", thread)
				.add("message", message);
	}
}
