package com.tina.batch.job;

import com.tina.batch.entity.Person;
import com.tina.batch.entity.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("test")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PersonInsertJobConfigurationTest extends UniqueBatchTestConfig {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Autowired
	private JobLocator jobLocator;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private PersonRepository personRepository;

	private JobExecution executeJob() throws
		NoSuchJobException,
		JobInstanceAlreadyCompleteException,
		JobExecutionAlreadyRunningException,
		JobParametersInvalidException,
		JobRestartException {
		JobParameters jobParameters = getUniqueJobParametersBuilder()
			.addLocalDate("date", LocalDate.now())
			.addLong("chunkSize", 100L)
			.toJobParameters();

		return jobLauncherTestUtils.getJobLauncher()
				.run(jobLocator.getJob("importPersonJob"), jobParameters);
	}


	@Test
	@DisplayName("importPersonJob에서 정상적으로 데이터를 조회하고 COMPLETED 상태로 끝이 난다.")
	void importPersonJobSuccess()
		throws
		JobInstanceAlreadyCompleteException, NoSuchJobException,
		JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
		// when
		JobExecution jobExecution = executeJob();

		// then
		List<Person> peopleWithLastNameJeong =  personRepository.findByLastName("Jeong");
		assertEquals(1, peopleWithLastNameJeong.size());

		assertThat(jobExecution.getStepExecutions().size()).isEqualTo(2);
		assertThat(jobExecution.getStepExecutions().stream().findFirst().isPresent()).isEqualTo(true);
		assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo(ExitStatus.COMPLETED.getExitCode());
	}


}