package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBWorkLogBase is a Querydsl query type for SBWorkLogBase
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSBWorkLogBase extends EntityPathBase<SBWorkLogBase> {

    private static final long serialVersionUID = -1424421451L;

    public static final QSBWorkLogBase sBWorkLogBase = new QSBWorkLogBase("sBWorkLogBase");

    public final QSBLogEntityRootBase _super = new QSBLogEntityRootBase(this);

    //inherited
    public final DatePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath description = _super.description;

    public final DatePath<java.util.Date> endTime = createDate("endTime", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final NumberPath<Long> itemCount = createNumber("itemCount", Long.class);

    public final StringPath stackTrace = createString("stackTrace");

    public final DatePath<java.util.Date> startTime = createDate("startTime", java.util.Date.class);

    public QSBWorkLogBase(String variable) {
        super(SBWorkLogBase.class, forVariable(variable));
    }

    public QSBWorkLogBase(Path<? extends SBWorkLogBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBWorkLogBase(PathMetadata metadata) {
        super(SBWorkLogBase.class, metadata);
    }

}

