package com.tina.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class BatchTestConfig {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobRepository jobRepository;

	@Bean
	public JobLauncherTestUtils jobLauncherTestUtils() {
		return new JobLauncherTestUtils() {
			@Override
			@Autowired
			public void setJob(Job job) {
				super.setJob(job);
			}

			@Override
			public JobLauncher getJobLauncher() {
				return jobLauncher;
			}

			@Override
			public JobRepository getJobRepository() {
				return jobRepository;
			}
		};
	}
}
