package com.uj.batch.tasklets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.uj.batch.utils.ExcelUtil;

public class WriteExcelFileTasklet implements Tasklet {

	ExcelUtil excelUtil = new ExcelUtil();

	private Logger logger = LoggerFactory.getLogger(WriteExcelFileTasklet.class);

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

		logger.info("Starting tasklet execution....." + excelUtil);
		excelUtil.createCountryReport();
		logger.info("Tasklet execution done");

		return RepeatStatus.FINISHED;
	}

}
