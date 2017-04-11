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
		
		AdStudent student = identityService.findStudentByMatricNo("A17P002");
		AdProgram program = plannerService.findProgramByCode("A01/MASTER/0002");
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode("201720181");
		
		AdAdmission admission = termService.findAdmissionBySessionProgramAndStudent(academicSession, program, student);
		
		Assert.notNull(admission, "Admission data should be not null");
		
		// view new admission data from AD_ADMN
		LOG.debug("Cgpa is {} ", admission.getCgpa());
		LOG.debug("Gpa is {} ", admission.getGpa());
		LOG.debug("CreditEarned is {} ", admission.getCreditEarned());
		LOG.debug("CreditEarned is {} ", admission.getCreditTaken());
		LOG.debug("Admission for repeated course is {} ", admission.getStanding());
		LOG.debug("Admission for repeated course is {} ", admission.getStatus());
		

		

		return self();

	}

}