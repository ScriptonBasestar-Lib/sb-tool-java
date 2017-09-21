package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBEntityBase is a Querydsl query type for SBEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBEntityBase extends EntityPathBase<SBEntityBase> {

    private static final long serialVersionUID = 1989849638L;

    public static final QSBEntityBase sBEntityBase = new QSBEntityBase("sBEntityBase");

    public final DatePath<java.util.Date> createdAt = createDate("createdAt", java.util.Date.class);

    public final DatePath<java.util.Date> updatedAt = createDate("updatedAt", java.util.Date.class);

    public QSBEntityBase(String variable) {
        super(SBEntityBase.class, forVariable(variable));
    }

    public QSBEntityBase(Path<? extends SBEntityBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBEntityBase(PathMetadata metadata) {
        super(SBEntityBase.class, metadata);
    }

}

