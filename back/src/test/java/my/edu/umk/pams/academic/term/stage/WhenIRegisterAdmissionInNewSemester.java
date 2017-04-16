package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplicationImpl;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIRegisterAdmissionInNewSemester extends Stage<WhenIRegisterAdmissionInNewSemester> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIRegisterAdmissionInNewSemester.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdStaff advisor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStudyCenter studyCenter;

	@ProvidedScenarioState
	private AdStudyCenterCode studyCenterCode;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdAdmissionApplication application;
	
	private String code;

	public WhenIRegisterAdmissionInNewSemester I_register_admission_in_new_semester() {
		
		// process flow of admission
		student = identityService.findStudentByMatricNo("A17P002");
		advisor = identityService.findStaffByStaffNo("01001A");
		program = plannerService.findProgramByCode("A01/MASTER/0002");
		studyCenter = commonService.findStudyCenterByCode("B");

		LOG.debug("student {}", student.getName());
		LOG.debug("advisor {}", advisor.getName());
		LOG.debug("program {}", program.getTitle());
		LOG.debug("studyCenter {}", studyCenter.getDescription());

		application = new AdAdmissionApplicationImpl();
		application.setReferenceNo("referenceNo02");
		application.setSourceNo("sourceNo02");
		application.setAuditNo("auditNo02");
		application.setDescription("description02");
		application.setRemoveComment("removeComment02");
		application.setCancelComment("cancelComment02");
		application.setStudent(student);
		application.setAdvisor(advisor);
		application.setProgram(program);
		application.setSession(academicSession);
		application.setStudyCenter(studyCenter);
		termService.saveAdmissionApplication(application);
		
		Assert.notNull(application, "Application data should be not null");
		LOG.debug("=================new data added=====================");
		LOG.debug("application {}", application.getId());
		LOG.debug("application {}", application.getStudent().getName());
		LOG.debug("application {}", application.getAdvisor().getName());
		LOG.debug("application {}", application.getReferenceNo());
		LOG.debug("application {}", application.getSourceNo());

		return self();
	}

}
