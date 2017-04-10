package my.edu.umk.pams.academic.term.stage;

//@author:asyikin
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationAction;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItemImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationType;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIAddEnrollmentCourses extends Stage<WhenIAddEnrollmentCourses> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAddEnrollmentCourses.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdAdmission admission;

	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;

	@ProvidedScenarioState
	private AdProgram program;

	public WhenIAddEnrollmentCourses I_add_enrollment_courses() {
		student = identityService.findStudentByMatricNo("A17P001");
		LOG.debug("student Code: {}", student.getId());

		academicSession = plannerService.findAcademicSessionByCode("201720181");
		LOG.debug("academicSession Code: {}", academicSession.getId());

		AdStaff advisor = identityService.findStaffByStaffNo("01001A");
		LOG.debug("Advisor Code: {}", advisor.getId());

		program = plannerService.findProgramByCode("A01/MASTER/0001");
		LOG.debug("program Code: {}", program.getId());

		// have to settle add admission by admin
		admission = termService.findAdmissionBySessionProgramAndStudent(academicSession, program, student);
		LOG.debug("Admission Code: {}", admission.getId());

		// have to setup admission service
		application = new AdEnrollmentApplicationImpl();

		application.setAuditNo("10");
		application.setDescription("New students enrollment 10");
		application.setType(AdEnrollmentApplicationType.PRA);
		application.setRemoveComment("10");
		application.setCancelComment("10");
		application.setStudent(student);
		application.setAdmission(admission);
		application.setAdvisor(advisor);
		application.setSession(academicSession);
		String generatedReferenceNo = termService.startEnrollmentApplicationTask(application);

		application = termService.findEnrollmentApplicationByReferenceNo(generatedReferenceNo);
		LOG.debug("New application added: {}", application.getId());

		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		LOG.debug("Section Code: {}", section.getCode());

		item = new AdEnrollmentApplicationItemImpl();
		item.setAction(AdEnrollmentApplicationAction.ADD);
		item.setApplication(application);
		item.setSection(section);
		termService.addEnrollmentApplicationItem(application, item);

		LOG.debug("New application item added: {}", item.getId());

		return self();
	}
}
