package com.tina.batch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransactionRecord is a Querydsl query type for TransactionRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransactionRecord extends EntityPathBase<TransactionRecord> {

    private static final long serialVersionUID = -627421166L;

    public static final QTransactionRecord transactionRecord = new QTransactionRecord("transactionRecord");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final DateTimePath<java.time.LocalDateTime> approvalDate = createDateTime("approvalDate", java.time.LocalDateTime.class);

    public final StringPath approvalNumber = createString("approvalNumber");

    public final StringPath currencyCode = createString("currencyCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderNumber = createString("orderNumber");

    public final StringPath paymentType = createString("paymentType");

    public final DateTimePath<java.time.LocalDateTime> processingDate = createDateTime("processingDate", java.time.LocalDateTime.class);

    public final StringPath productName = createString("productName");

    public final StringPath status = createString("status");

    public final StringPath usageType = createString("usageType");

    public QTransactionRecord(String variable) {
        super(TransactionRecord.class, forVariable(variable));
    }

    public QTransactionRecord(Path<? extends TransactionRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransactionRecord(PathMetadata metadata) {
        super(TransactionRecord.class, metadata);
    }

}

