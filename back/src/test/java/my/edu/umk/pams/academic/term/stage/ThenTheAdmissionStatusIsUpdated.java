package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAdmission;

@JGivenStage
public class ThenTheAdmissionStatusIsUpdated extends Stage<ThenTheAdmissionStatusIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionStatusIsUpdated.class);

	@ExpectedScenarioState
	private AdAdmission admission;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdStudyCenter studyCenter;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public ThenTheAdmissionStatusIsUpdated the_admission_status_is_updated() {

		Assert.notNull(student, "student data value passed");
		Assert.notNull(program, "program data value passed ");
		Assert.notNull(admission, "admission data value passed");

		LOG.debug("student: {}", student.getId());
		LOG.debug("program: {}", program.getId());
		LOG.debug("admission: {}", admission.getId());
		LOG.debug("Admission status info is updated: {} ", admission.getStatus());
		LOG.debug("Admission academic standing info is updated: {} ", admission.getStanding());

		return self();
	}
}