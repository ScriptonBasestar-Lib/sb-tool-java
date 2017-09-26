package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBActiveEntityBase is a Querydsl query type for SBActiveEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBActiveEntityBase extends EntityPathBase<SBActiveEntityBase> {

    private static final long serialVersionUID = 1335440841L;

    public static final QSBActiveEntityBase sBActiveEntityBase = new QSBActiveEntityBase("sBActiveEntityBase");

    public final QSBEntityBase _super = new QSBEntityBase(this);

    public final BooleanPath active = createBoolean("active");

    //inherited
    public final DatePath<java.util.Date> createdAt = _super.createdAt;

    public final BooleanPath enabled = createBoolean("enabled");

    //inherited
    public final DatePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSBActiveEntityBase(String variable) {
        super(SBActiveEntityBase.class, forVariable(variable));
    }

    public QSBActiveEntityBase(Path<? extends SBActiveEntityBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBActiveEntityBase(PathMetadata metadata) {
        super(SBActiveEntityBase.class, metadata);
    }

}

