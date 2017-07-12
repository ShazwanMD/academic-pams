package my.edu.umk.pams.academic.assessment.stage;

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
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

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
	private AdOffering offering;

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
		LOG.debug("Cohort:{}",cohort.getCode());
		
		program = cohort.getProgram();
		LOG.debug("Program:{}",program.getCode());
		
		faculty = program.getFaculty();

		session = plannerService.findCurrentAcademicSession();

	
		AdCourse course = 	plannerService.findCourseByCode("GST5013");
		LOG.debug("Offering Course:{}",course.getCode());
	
		studyCenter = commonService.findStudyCenterByCode("A");

		offering = new AdOfferingImpl();
		offering.setCanonicalCode("MASTER-MBA-GST5013-201720181");
		offering.setCode("MASTER-MBA-GST5013");
		offering.setTitleMs("s");
		offering.setTitleEn("s");
		offering.setCapacity(100);
		offering.setProgram(program);
		offering.setCourse(course);
		offering.setSession(session);
		termService.saveOffering(offering);
		LOG.debug("Offering Course:{}",offering.getCourse().getCode());
		LOG.debug("Offering Session:{}",offering.getSession().getCode());
		

		section = new AdSectionImpl();
		section.setCode("Section A");
		section.setCanonicalCode("MASTER-MBA-GST5013-201720181-Section A");
		section.setOrdinal(1);
		section.setCapacity(20);
		section.setOffering(offering);
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

	/*	AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
		AdStudent student = identityService.findStudentByMatricNo("A17M0009F");
		AdAdmission currentAdmission = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, cohort, student);
		
		List<AdAdmission> admissions = termService.findAdmissionsStudent(program, student)
		BigDecimal totalCreditTaken = BigDecimal.ZERO; // dapat
		BigDecimal totalCreditEarned = BigDecimal.ZERO; // kira
		for (AdAdmission adAdmission : admissions) {
		  totalCreditTaken = totalCreditTaken.add(adAdmission.getCreditTaken());
		  totalCreditEarned = totalCreditEarned.add(adAdmission.getCreditEarned());
	    		
		}
		
		BigDecimal cgpa = totalCreditTaken.divide(totalCreditEarned);
		currentAdmission.setCgpa(cgpa);*/
		
	
		return self();
	}
}
