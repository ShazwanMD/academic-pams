package my.edu.umk.pams.academic.term.stage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheAdmissionStatusIsUpdated extends Stage<ThenTheAdmissionStatusIsUpdated> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheAdmissionStatusIsUpdated.class);

	@ExpectedScenarioState
	private AdAdmission admission;
	
	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdStudyCenter studyCenter;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ExpectedScenarioState
	private AdCohort cohort;
	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date());

	public ThenTheAdmissionStatusIsUpdated the_admission_status_is_updated() {

		AdAdmission admission = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, cohort, student);
		Assert.notNull(admission, "admission data should be not null");
		
		LOG.debug("=======Process running at " + timeStamp + "===========");
		LOG.debug("academicSession:{}", academicSession.getDescription());
		LOG.debug("cohort:{}", cohort.getDescription());
		LOG.debug("student:{}", student.getIdentityNo());
		LOG.debug("admission status:{}", admission.getStatus().getDescription());
		
		
		if(admission.getStatus() == admission.getStatus()){
			LOG.debug("Data NOT UPDATED. Old previous data");
			LOG.debug("Admission id: {}", admission.getId());
			LOG.debug("Student: {}", admission.getStudent().getName());
			LOG.debug("Cohort: {}", admission.getCohort().getDescription());
			LOG.debug("Standing: {}", admission.getStanding().getDescription());
			LOG.debug("Status: {}", admission.getStatus().getDescription());
			LOG.debug("StudyCenter: {}", admission.getStudyCenter().getDescription());
			
		}else {
			LOG.debug("Data is currently updated at " + timeStamp );
			LOG.debug("Admission id: {}", admission.getId());
			LOG.debug("Student: {}", admission.getStudent().getName());
			LOG.debug("Cohort: {}", admission.getCohort().getDescription());
			LOG.debug("Standing: {}", admission.getStanding().getDescription());
			LOG.debug("Status: {}", admission.getStatus().getDescription());
			LOG.debug("StudyCenter: {}", admission.getStudyCenter().getDescription());
			
			
		}
		
		return self();
	}
}