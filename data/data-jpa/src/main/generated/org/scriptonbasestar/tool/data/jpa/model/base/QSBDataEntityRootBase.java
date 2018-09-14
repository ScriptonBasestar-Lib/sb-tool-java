package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBDataEntityRootBase is a Querydsl query type for SBDataEntityRootBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBDataEntityRootBase extends EntityPathBase<SBDataEntityRootBase> {

    private static final long serialVersionUID = 152516399L;

    public static final QSBDataEntityRootBase sBDataEntityRootBase = new QSBDataEntityRootBase("sBDataEntityRootBase");

    public final DatePath<java.util.Date> createdAt = createDate("createdAt", java.util.Date.class);

    public final BooleanPath enabled = createBoolean("enabled");

    public final DatePath<java.util.Date> updatedAt = createDate("updatedAt", java.util.Date.class);

    public QSBDataEntityRootBase(String variable) {
        super(SBDataEntityRootBase.class, forVariable(variable));
    }

    public QSBDataEntityRootBase(Path<? extends SBDataEntityRootBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBDataEntityRootBase(PathMetadata metadata) {
        super(SBDataEntityRootBase.class, metadata);
    }

}

