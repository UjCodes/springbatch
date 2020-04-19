package com.uj.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.uj.batch.tasklets.WriteExcelFileTasklet;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	public Step stepWriteToExcel() {
		return steps.get("stepWriteToExcel").tasklet(new WriteExcelFileTasklet()).build();
	}

	
	@Bean
	public Job createEmployeeReportJob() {
		return jobs.get("createEmployeeReportJob").incrementer(new RunIdIncrementer()).start(stepWriteToExcel()).build();
	}
}