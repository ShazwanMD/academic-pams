package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;

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
	private AdAdmission admission;
	
	@ProvidedScenarioState
	private AdStudyCenter studyCenter;
	
	@ExpectedScenarioState
    private AdProgram program;
    
	@ProvidedScenarioState
    private AdCohort cohort;

    @ExpectedScenarioState
    private AdStudent student;
	
    @ExpectedScenarioState
    private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private	AdAdmissionApplication application;
	

	public WhenIApproveNewAdmissionForStudent I_approve_new_admission_for_student() {

		//admin add new admission to approve admission application from student
		
		Assert.notNull(program, "program code is not null");
		Assert.notNull(student, "student id is not null");
		LOG.debug("Program Id:{}", program.getId());
		LOG.debug("student Id:{}", student.getId());
		LOG.debug("student Cohort:{}", student.getCohort().getCode());
		
		application = termService.findAdmissionApplicationByProgramAndStudent(program, student);
		Assert.notNull(application, "application data is not null");

		LOG.debug("application ID:{}", application.getId());
		LOG.debug("application studyCenter:{}", application.getStudyCenter().getId());
		
		studyCenter =  application.getStudyCenter();
		cohort = student.getCohort();
		
		admission = new AdAdmissionImpl();
		admission.setCgpa(new BigDecimal("2.90"));
		admission.setCreditEarned(100);
		admission.setCreditTaken(100);
		admission.setGpa(new BigDecimal("2.90"));
		admission.setCohort(cohort);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KB);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		admission.setStudent(student);
		admission.setStudyCenter(studyCenter);
		
		termService.saveAdmission(admission);
		
		//new data added in ad_admn from ad_admn_apln
		Assert.notNull(admission, "Item data should be not null");
		
		LOG.debug("===============new data admission inserted=============");
		LOG.debug("New admission id inserted:{}", admission.getId());
		LOG.debug("New admission student inserted:{}", admission.getStudent().getName());
		LOG.debug("New admission Cohort inserted:{}", admission.getCohort().getId());
		LOG.debug("New admission Session inserted:{}", admission.getSession().getId());
		LOG.debug("New admission Gpa inserted:{}", admission.getGpa());
		LOG.debug("New admission Cgpa inserted:{}", admission.getCgpa());
		LOG.debug("New admission Standing inserted:{}", admission.getStanding());
		LOG.debug("New admission Status inserted:{}", admission.getStatus());
		LOG.debug("New admission StudyCenter inserted:{}", admission.getStudyCenter().getId());
		
		return self();
	}

}