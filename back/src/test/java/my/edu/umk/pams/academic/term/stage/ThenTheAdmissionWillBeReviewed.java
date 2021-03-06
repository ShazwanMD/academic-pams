package my.edu.umk.pams.academic.term.stage;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;


@JGivenStage
public class ThenTheAdmissionWillBeReviewed extends Stage<ThenTheAdmissionWillBeReviewed> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionWillBeReviewed.class);

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdStaff advisor;

	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdStudyCenter studyCenter;
	
	@ExpectedScenarioState
	private AdAdmissionApplication application;

	public ThenTheAdmissionWillBeReviewed The_admission_will_be_reviewed() {
		
		LOG.debug("student {}", student.getId());
		LOG.debug("program {}", program.getId());
		LOG.debug("=================view new added data=====================");
		LOG.debug("Admission id for new student: {}", application.getId());
		LOG.debug("Admission desc for new student: {}", application.getDescription());
		LOG.debug("Admission audit no for new student: {}", application.getAuditNo());
		
		LOG.debug("advisor {}", advisor.getName());
		LOG.debug("program {}", program.getTitleMs());
		LOG.debug("program {}", program.getTitleEn());
		LOG.debug("studyCenter {}", studyCenter.getDescription());

		return self();

	}

}
