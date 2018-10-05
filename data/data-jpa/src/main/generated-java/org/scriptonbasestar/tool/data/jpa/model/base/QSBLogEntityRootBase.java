package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBLogEntityRootBase is a Querydsl query type for SBLogEntityRootBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBLogEntityRootBase extends EntityPathBase<SBLogEntityRootBase> {

    private static final long serialVersionUID = 2093727051L;

    public static final QSBLogEntityRootBase sBLogEntityRootBase = new QSBLogEntityRootBase("sBLogEntityRootBase");

    public final DatePath<java.util.Date> createdAt = createDate("createdAt", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QSBLogEntityRootBase(String variable) {
        super(SBLogEntityRootBase.class, forVariable(variable));
    }

    public QSBLogEntityRootBase(Path<? extends SBLogEntityRootBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBLogEntityRootBase(PathMetadata metadata) {
        super(SBLogEntityRootBase.class, metadata);
    }

}

