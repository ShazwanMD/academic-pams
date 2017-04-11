package my.edu.umk.pams.academic.term.stage;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIApproveNewAdmissionForStudent  extends Stage<WhenIApproveNewAdmissionForStudent> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIApproveNewAdmissionForStudent.class);

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private CommonService commonService;
	
	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	@ExpectedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdAcademicSession academicSession;
	

	public WhenIApproveNewAdmissionForStudent I_approve_new_admission_for_student() {

		//admin add new admission to approve admission application from student
		AdStudent student = identityService.findStudentByMatricNo("A17P002");
		AdProgram program = plannerService.findProgramByCode("A01/MASTER/0002");
		AdAcademicSession academicSession = plannerService.findAcademicSessionByCode("201720181");
		AdStudyCenter studyCenter = commonService.findStudyCenterByCode("A");
		
		AdAdmission admission = new AdAdmissionImpl();
		admission.setCgpa(new BigDecimal("3.50"));
		admission.setCreditEarned(140);
		admission.setCreditTaken(140);
		admission.setGpa(new BigDecimal("3.50"));
		admission.setProgram(program);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KB);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		admission.setStudent(student);
		admission.setStudyCenter(studyCenter);
		
		termService.saveAdmission(admission);
		
		LOG.debug("New admission id inserted:{}", admission.getId());
		Assert.notNull(admission, "Item data should be not null");
		
		
		
		return self();
	}

}