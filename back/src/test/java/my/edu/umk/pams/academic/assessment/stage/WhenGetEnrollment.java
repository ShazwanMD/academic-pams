package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenGetEnrollment extends Stage<WhenGetEnrollment> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenGetEnrollment.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAssessment assessment;

	@ProvidedScenarioState
	private AdAcademicSession session;

	@ProvidedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ProvidedScenarioState
	private AdAdmission admission;

	@ProvidedScenarioState
	private AdStudyCenter studyCenter;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ExpectedScenarioState
	private AdGradeCode grade;

	@ExpectedScenarioState
	private AdGradebook gradeBook;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdOffering offer;

	@ExpectedScenarioState
	private static String staffNo;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdFaculty faculty;

	public WhenGetEnrollment get_enrollment() {

		staff = identityService.findStaffByStaffNo(staffNo);
		LOG.debug("Staff Name :{}", staff.getName());
		LOG.debug("Staff Type :{}", staff.getStaffType().name());

		student = profileService.findStudentByMatricNo("A17M0009F");

		cohort = student.getCohort();

		program = cohort.getProgram();

		faculty = program.getFaculty();

		session = plannerService.findCurrentAcademicSession();

		course = plannerService.findCourseByCodeAndFaculty("GST5013", faculty);

		studyCenter = commonService.findStudyCenterByCode("A");

		offer = new AdOfferingImpl();
		offer.setCanonicalCode("MASTER/MBA/GST5013/201720181");
		offer.setCode("MASTER/MBA/GST5013");
		offer.setTitle("Economics & Business Environment");
		offer.setCapacity(100);
		offer.setProgram(program);
		offer.setCourse(course);
		offer.getSections();
		termService.saveOffering(offer);

		section = new AdSectionImpl();
		section.setCode("Section A");
		section.setCanonicalCode("MASTER/MBA/GST5013/201720181/Section A");
		section.setOrdinal(1);
		section.setCapacity(20);
		section.setSession(session);
		section.setOffering(offer);
		termService.saveSection(section);

		admission = new AdAdmissionImpl();

		admission.setGpa(BigDecimal.ZERO);
		admission.setCgpa(BigDecimal.ZERO);
		admission.setCreditTaken(20);
		admission.setCreditEarned(20);
		admission.setStudent(student);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		admission.setStanding(AdAcademicStanding.TBD);
		admission.setStudyCenter(studyCenter);
		admission.setSession(session);
		admission.setCohort(cohort);
		termService.saveAdmission(admission);
		LOG.debug("Admission Student Name :{}", admission.getStudent().getName());
		LOG.debug("Admission study center :{}", admission.getStudyCenter().getDescription());
		LOG.debug("Admission academic session :{}", admission.getSession().getCode());
		LOG.debug("Admission cohort :{}", admission.getCohort().getCode());
		LOG.debug("GPA :{}", admission.getGpa());
		LOG.debug("CGPA :{}", admission.getCgpa());

		enrollment = new AdEnrollmentImpl();
		enrollment.setAdmission(admission);
		enrollment.setSection(section);
		enrollment.setGradeCode(commonService.findGradeCodeByCode("A+"));
		enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
		LOG.debug("Enrollment Status :{}", enrollment.getAdmission().getStanding().getDescription());
		LOG.debug("Grade Code :{}", enrollment.getGradeCode().getCode());
		termService.saveEnrollment(enrollment);

		return self();
	}
}
