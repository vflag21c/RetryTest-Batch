package com.tina.batch.common.listener;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.ExitStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StepPerformanceListener implements StepExecutionListener {

	private long startTime;

	@Override
	public void beforeStep(StepExecution stepExecution) {
		startTime = System.nanoTime();
		log.info("Step {} started.", stepExecution.getStepName());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		long endTime = System.nanoTime();
		long elapsedTime = (endTime- startTime) / 1000000;

		log.info("Step {} finished.", stepExecution.getStepName());
		log.info("Step execution time: {} ms", elapsedTime);
		return ExitStatus.COMPLETED;
	}
}