package com.tina.batch.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBasicAuditColumns is a Querydsl query type for BasicAuditColumns
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBasicAuditColumns extends EntityPathBase<BasicAuditColumns> {

    private static final long serialVersionUID = 1448170354L;

    public static final QBasicAuditColumns basicAuditColumns = new QBasicAuditColumns("basicAuditColumns");

    public final StringPath lastUpdateDt = createString("lastUpdateDt");

    public QBasicAuditColumns(String variable) {
        super(BasicAuditColumns.class, forVariable(variable));
    }

    public QBasicAuditColumns(Path<? extends BasicAuditColumns> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBasicAuditColumns(PathMetadata metadata) {
        super(BasicAuditColumns.class, metadata);
    }

}

