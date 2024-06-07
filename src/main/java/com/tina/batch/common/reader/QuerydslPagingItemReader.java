package com.tina.batch.common.reader;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


@Slf4j
public class QuerydslPagingItemReader<T> implements ItemReader<T> {

    private final JPAQueryFactory queryFactory;
    private final Function<JPAQueryFactory, JPAQuery<T>> queryFunction;
    private Iterator<T> iterator;

    public QuerydslPagingItemReader(EntityManager entityManager, Function<JPAQueryFactory, JPAQuery<T>> queryFunction) {
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.queryFunction = queryFunction;
        initIterator();
    }

    private void initIterator() {
        JPAQuery<T> query = queryFunction.apply(queryFactory);
        List<T> results = query.fetch();
        log.info("Fetched {} records.", results.size());
        this.iterator = results.iterator();
    }

    @Override
    public T read() {
        if (iterator != null && iterator.hasNext()) {
            T nextItem = iterator.next();
            log.debug("Reading next item: {}", nextItem);
            return nextItem;
        } else {
            log.info("No more items to read.");
            return null;
        }
    }
}