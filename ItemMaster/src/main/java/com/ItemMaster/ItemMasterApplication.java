package com.ItemMaster;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableBatchProcessing
@SpringBootApplication()
public class ItemMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemMasterApplication.class, args);
	}

}

