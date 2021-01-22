package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBLogEntityBase is a Querydsl query type for SBLogEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBLogEntityBase extends EntityPathBase<SBLogEntityBase> {

    private static final long serialVersionUID = -645397175L;

    public static final QSBLogEntityBase sBLogEntityBase = new QSBLogEntityBase("sBLogEntityBase");

    public final DatePath<java.util.Date> createdAt = createDate("createdAt", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QSBLogEntityBase(String variable) {
        super(SBLogEntityBase.class, forVariable(variable));
    }

    public QSBLogEntityBase(Path<? extends SBLogEntityBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBLogEntityBase(PathMetadata metadata) {
        super(SBLogEntityBase.class, metadata);
    }

}

