package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenTheNewAdmissionIsAdded extends Stage<ThenTheNewAdmissionIsAdded> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheNewAdmissionIsAdded.class);

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private TermService termService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdAdmission admission;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	public ThenTheNewAdmissionIsAdded the_new_admission_is_added() {
		
		Assert.notNull(admission, "Admission data should be not null");
		
		LOG.debug("=============review new admission======================");
		LOG.debug("New admission id:{} ", admission.getId());
		LOG.debug("New admission Student:{} ", admission.getStudent().getName());
		LOG.debug("New admission Cohort :{}", admission.getCohort().getId());
		LOG.debug("New admission Session :{}", admission.getSession().getId());
		LOG.debug("New admission Gpa :{}", admission.getGpa());
		LOG.debug("New admission Cgpa :{}", admission.getCgpa());
		LOG.debug("New admission Standing :{}", admission.getStanding());
		LOG.debug("New admission Status :{}", admission.getStatus());
		LOG.debug("New admission StudyCenter :{}", admission.getStudyCenter().getId());
		
		return self();

	}

}