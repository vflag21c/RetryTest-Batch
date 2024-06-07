package com.tina.batch.job;

import com.tina.batch.common.incrementer.UniqueRunIdIncrementer;
import com.tina.batch.entity.Person;
import com.tina.batch.processor.PersonItemProcessor;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class PersonInsertJobConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private static final String JOB_NAME = "PERSON_JOB";

    @Bean(JOB_NAME)
    public Job importPersonJob(JobRepository jobRepository) {
        return new JobBuilder(JOB_NAME, jobRepository)
                .incrementer(new UniqueRunIdIncrementer())
                .start(importPersonStep(null, null))
                .build();
    }

    @Bean
    @JobScope
    public Step importPersonStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("importPersonStep", jobRepository)
                .<Person, Person>chunk(100, transactionManager)
                .faultTolerant()
                .retry(RuntimeException.class)
                .retryLimit(5)
                .reader(reader())
                .processor(processor())
                .writer(exceptionWriter())
                .build();
    }

    @Bean
    @StepScope
    public JpaPagingItemReader<Person> reader() {
        JpaPagingItemReader<Person> reader = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(entityManagerFactory);
        reader.setQueryString("SELECT p FROM Person p");
        reader.setPageSize(100);
        return reader;
    }

    @Bean
    @StepScope
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    @StepScope
    public ItemWriter<Person> exceptionWriter() {
        return chunk -> {
            System.out.println("chunk.getItems() = " + chunk.getItems());
            throw new RuntimeException("강제 Exception 발생");
        };
    }

//    @Bean
//    @StepScope
//    public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
//        return new JdbcBatchItemWriterBuilder<Person>()
//                .sql("INSERT INTO Person (first_name, last_name) VALUES (:firstName, :lastName)") //Exception 발생
//                .dataSource(dataSource)
//                .beanMapped()
//                .build();
//    }


}