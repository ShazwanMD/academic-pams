package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	public WhenIRegisterAdmissionInNewSemester I_register_admission_in_new_semester() {
		// process flow of admission

		String code = "A";
		student = identityService.findStudentByStudentNo("A17P001");
		advisor = identityService.findStaffByStaffNo("01001A");
		program = plannerService.findProgramByCode("A01/MASTER/0001");
		studyCenterCode = commonService.findStudyCenterCodeByCode(code);
		String referenceNo = "referenceNo";
		String sourceNo = "sourceNo";
		String auditNo = "auditNo";
		String description = "description";
		String removeComment = "";
		String cancelComment = "";

		LOG.debug("student {}", student.getName());
		LOG.debug("advisor {}", advisor.getName());
		LOG.debug("program {}", program.getTitle());
		LOG.debug("studyCenter {}", studyCenterCode.getDescription());

		AdAdmissionApplication admissionApplication = new AdAdmissionApplicationImpl();
		admissionApplication.setReferenceNo(referenceNo);
		admissionApplication.setSourceNo(sourceNo);
		admissionApplication.setAuditNo(auditNo);
		admissionApplication.setDescription(description);
		admissionApplication.setRemoveComment(removeComment);
		admissionApplication.setCancelComment(cancelComment);
		admissionApplication.setStudent(student);
		admissionApplication.setAdvisor(advisor);
		admissionApplication.setProgram(program);
		admissionApplication.setSession(academicSession);
		admissionApplication.setStudyCenter(studyCenter);

		termService.saveAdmission(admissionApplication);

		return self();
	}

}
