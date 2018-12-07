package org.scriptonbasestar.tool.data.jpa.model.base;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.EntityPathBase;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QSBDataEntityBase is a Querydsl query type for SBDataEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBDataEntityBase
	extends EntityPathBase<SBDataEntityBase> {

	private static final long serialVersionUID = 2084835629L;

	public static final QSBDataEntityBase sBDataEntityBase = new QSBDataEntityBase("sBDataEntityBase");

	public final DatePath<java.util.Date> createdAt = createDate("createdAt", java.util.Date.class);

	public final BooleanPath enabled = createBoolean("enabled");

	public final DatePath<java.util.Date> updatedAt = createDate("updatedAt", java.util.Date.class);

	public QSBDataEntityBase(String variable) {
		super(SBDataEntityBase.class, forVariable(variable));
	}

	public QSBDataEntityBase(Path<? extends SBDataEntityBase> path) {
		super(path.getType(), path.getMetadata());
	}

	public QSBDataEntityBase(PathMetadata metadata) {
		super(SBDataEntityBase.class, metadata);
	}

}

