package com.ItemMaster.config;

import com.ItemMaster.Model.Item;
import com.ItemMaster.CustomItemProcessor;
import com.ItemMaster.JobCompletionNotificationImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    public Job jobBean(JobRepository jobRepository,
                       JobCompletionNotificationImpl listener, Step step){
        return new JobBuilder("job",jobRepository).listener(listener).start(step).build();
    }

    @Bean
    public Step steps(JobRepository jobRepository,
                      DataSourceTransactionManager transactionManager,
                      ItemReader<Item> reader,
                      ItemProcessor<Item,Item> itemProcessor,
                      ItemWriter<Item> writer){
        return new StepBuilder("jobSteps",jobRepository).
                <Item,Item>chunk(5,transactionManager).
                reader(reader).
                processor(itemProcessor).
                writer(writer).
                allowStartIfComplete(true).
                build();
    }

    @Bean
    public FlatFileItemReader<Item> reader(){
        return new FlatFileItemReaderBuilder<Item>()
                .name("itemReader")
                .resource(new ClassPathResource("input.csv"))
                .delimited()
                .names("storeId","sku","productName","price","lastUpdatedOn")
                .targetType(Item.class)
                .build();
    }

    @Bean
    public ItemProcessor<Item,Item> itemProcessor(){
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<Item> itemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Item>()
                .sql("insert into Item(store_id ,sku,product_name,price,last_updated_on) values(:storeId,:sku,:productName,:price,:lastUpdatedOn)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }
}
