package com.tina.batch.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransaction is a Querydsl query type for Transaction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransaction extends EntityPathBase<Transaction> {

    private static final long serialVersionUID = 1758387456L;

    public static final QTransaction transaction = new QTransaction("transaction");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> approvalDate = createDateTime("approvalDate", java.time.LocalDateTime.class);

    public final StringPath approvalNumber = createString("approvalNumber");

    public final StringPath currencyCode = createString("currencyCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderNumber = createString("orderNumber");

    public final StringPath paymentType = createString("paymentType");

    public final DateTimePath<java.time.LocalDateTime> processDate = createDateTime("processDate", java.time.LocalDateTime.class);

    public final StringPath productName = createString("productName");

    public final NumberPath<Integer> sequence = createNumber("sequence", Integer.class);

    public final StringPath status = createString("status");

    public final StringPath usageType = createString("usageType");

    public QTransaction(String variable) {
        super(Transaction.class, forVariable(variable));
    }

    public QTransaction(Path<? extends Transaction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransaction(PathMetadata metadata) {
        super(Transaction.class, metadata);
    }

}

