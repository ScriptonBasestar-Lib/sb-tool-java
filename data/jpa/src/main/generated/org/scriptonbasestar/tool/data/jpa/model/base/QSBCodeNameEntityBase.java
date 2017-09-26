package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBCodeNameEntityBase is a Querydsl query type for SBCodeNameEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBCodeNameEntityBase extends EntityPathBase<SBCodeNameEntityBase> {

    private static final long serialVersionUID = -1514508645L;

    public static final QSBCodeNameEntityBase sBCodeNameEntityBase = new QSBCodeNameEntityBase("sBCodeNameEntityBase");

    public final QSBCodeEntityBase _super = new QSBCodeEntityBase(this);

    //inherited
    public final StringPath code = _super.code;

    //inherited
    public final DatePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath description = _super.description;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DatePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSBCodeNameEntityBase(String variable) {
        super(SBCodeNameEntityBase.class, forVariable(variable));
    }

    public QSBCodeNameEntityBase(Path<? extends SBCodeNameEntityBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBCodeNameEntityBase(PathMetadata metadata) {
        super(SBCodeNameEntityBase.class, metadata);
    }

}

