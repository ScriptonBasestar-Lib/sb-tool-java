package org.scriptonbasestar.tool.data.jpa.model.base;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSBCodeEntityBase is a Querydsl query type for SBCodeEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBCodeEntityBase
	extends EntityPathBase<SBCodeEntityBase> {

	private static final long serialVersionUID = 2114525104L;

	public static final QSBCodeEntityBase sBCodeEntityBase = new QSBCodeEntityBase("sBCodeEntityBase");

	public final QSBDataEntityBase _super = new QSBDataEntityBase(this);

	public final StringPath code = createString("code");

	//inherited
	public final DatePath<java.util.Date> createdAt = _super.createdAt;

	public final StringPath description = createString("description");

	//inherited
	public final BooleanPath enabled = _super.enabled;

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final StringPath name = createString("name");

	//inherited
	public final DatePath<java.util.Date> updatedAt = _super.updatedAt;

	public QSBCodeEntityBase(String variable) {
		super(SBCodeEntityBase.class, forVariable(variable));
	}

	public QSBCodeEntityBase(Path<? extends SBCodeEntityBase> path) {
		super(path.getType(), path.getMetadata());
	}

	public QSBCodeEntityBase(PathMetadata metadata) {
		super(SBCodeEntityBase.class, metadata);
	}

}

