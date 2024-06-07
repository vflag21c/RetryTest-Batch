package com.tina.batch.job;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;

public class UniqueBatchTestConfig {


	protected JobParametersBuilder getUniqueJobParametersBuilder() {
		return new JobParametersBuilder(new JobLauncherTestUtils().getUniqueJobParameters());
	}
}
