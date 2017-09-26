package org.scriptonbasestar.tool.data.jpa.model.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSBCategoryEntityBase is a Querydsl query type for SBCategoryEntityBase
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QSBCategoryEntityBase extends EntityPathBase<SBCategoryEntityBase> {

    private static final long serialVersionUID = 934766081L;

    public static final QSBCategoryEntityBase sBCategoryEntityBase = new QSBCategoryEntityBase("sBCategoryEntityBase");

    public final QSBEntityBase _super = new QSBEntityBase(this);

    //inherited
    public final DatePath<java.util.Date> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final DatePath<java.util.Date> updatedAt = _super.updatedAt;

    public QSBCategoryEntityBase(String variable) {
        super(SBCategoryEntityBase.class, forVariable(variable));
    }

    public QSBCategoryEntityBase(Path<? extends SBCategoryEntityBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSBCategoryEntityBase(PathMetadata metadata) {
        super(SBCategoryEntityBase.class, metadata);
    }

}

