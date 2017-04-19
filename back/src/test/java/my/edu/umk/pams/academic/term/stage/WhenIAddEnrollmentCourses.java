package my.edu.umk.pams.academic.term.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
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
	private TermService termService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdAdmission admission;

	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private List<AdEnrollmentApplication> applications;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;

	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;

	@ExpectedScenarioState
	private AdProgram program;

	public WhenIAddEnrollmentCourses I_add_enrollment_courses() {

		student = identityService.findStudentByMatricNo("A17P001");
		Assert.notNull(student, "Student data is null");
		Assert.notNull(academicSession, "AcademicSession data is null.Please check data in table ad_acdm_sesn");
		
		LOG.debug("Student id: {}", student.getId());
		LOG.debug("Student Cohort id: {}", student.getCohort().getId());
		LOG.debug("Academic Session id: {}", academicSession.getId());

		AdStaff advisor = identityService.findStaffByStaffNo("01001A");
		Assert.notNull(advisor, "advisor data is null");
		LOG.debug("Advisor id: {}", advisor.getId());

		Assert.notNull(program, "program data is null");
		LOG.debug("Program id: {}", program.getId());
		
		LOG.debug("==============Find data admission process================");

		
		Integer countAdmissionApp= termService.countAdmissionApplication("des", academicSession, student);
		LOG.debug("countAdmissionApplication:{}",countAdmissionApp);
		
		if (countAdmissionApp == 0) {
			LOG.debug("Please do admission application process first.");

			return self();
		} else {
			
			// have to settle add admission by admin
			admission = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, student.getCohort(),
					student);
			
			LOG.debug("========current data admission after approved by admin===========");
			LOG.debug("Admission Id: {}", admission.getId());
			LOG.debug("Admission Student: {}", admission.getStudent().getId());
			LOG.debug("Admission Session: {}", admission.getSession().getId());
			LOG.debug("Admission Standing: {}", admission.getStanding().getDescription());
			LOG.debug("Admission StudyCenter: {}", admission.getStudyCenter().getId());
			LOG.debug("Admission Cohort: {}", admission.getCohort().getId());
			LOG.debug("Admission Status: {}", admission.getStatus().getDescription());

			applications = termService.findEnrollmentApplications("des", academicSession, student, 0, 100);
			// Assert.notEmpty(applications, "applications are empty");

			for (AdEnrollmentApplication application : applications) {
				LOG.debug("Application Id:{}", application.getId());
				LOG.debug("Application Student:{}", application.getStudent().getId());
			}

			// have to setup admission service
			application = new AdEnrollmentApplicationImpl();

			application.setAuditNo("www");
			application.setCancelComment("gggg");
			application.setDescription("New students enrollment ww");
			application.setRemoveComment("wwwww");
			application.setSourceNo("setSourceNo");
			application.setType(AdEnrollmentApplicationType.WAJIB);
			application.setAdmission(admission);
			application.setAdvisor(advisor);
			application.setSession(academicSession);
			application.setStudent(student);
			
			termService.startEnrollmentApplicationTask(application);

			String generatedReferenceNo = termService.startEnrollmentApplicationTask(application);
			application = termService.findEnrollmentApplicationByReferenceNo(generatedReferenceNo);
			Assert.notNull(application, "application data is null");

			section = termService.findSectionByCanonicalCode("FIAT/MASTER/PBH/GST5023/201720181");
			Assert.notNull(section, "section data is null");
			LOG.debug("Section Code: {}", section.getCode());

			item = new AdEnrollmentApplicationItemImpl();
			item.setAction(AdEnrollmentApplicationAction.ADD);
			item.setApplication(application);
			item.setSection(section);
			termService.addEnrollmentApplicationItem(application, item);

			LOG.debug("====new application added in application=================");
			LOG.debug("New application getId: {}", application.getId());
			LOG.debug("New application getAdmission: {}", application.getAdmission().getId());
			LOG.debug("New application getAuditNo: {}", application.getAuditNo());
			LOG.debug("New application getReferenceNo: {}", application.getReferenceNo());
			
			LOG.debug("====new application added in item=================");
			LOG.debug("New application item getId: {}", item.getId());
			LOG.debug("New application item getSection: {}", item.getSection());
			LOG.debug("New application item getAction: {}", item.getAction());
			LOG.debug("New application item getApplication: {}", item.getApplication().getId());

		}

		return self();

	}
}