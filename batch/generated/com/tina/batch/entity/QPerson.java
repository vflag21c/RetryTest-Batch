package com.tina.batch.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = -696499213L;

    public static final QPerson person = new QPerson("person");

    public final QBasicAuditColumns _super = new QBasicAuditColumns(this);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    //inherited
    public final StringPath lastUpdateDt = _super.lastUpdateDt;

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

