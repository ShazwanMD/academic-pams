package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.service.TermService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@JGivenStage
public class WhenReviewMyCourseRegistration extends Stage<WhenReviewMyCourseRegistration> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewMyCourseRegistration.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private TermService termService;
	
	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdProgramLevel level;

	@ProvidedScenarioState
	private List<AdCourse> courses;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdCohort cohort;

	@ExpectedScenarioState
	private AdStudentStatus studentStatus;
	
	@ExpectedScenarioState
	public static String matricNo;

	public WhenReviewMyCourseRegistration i_want_to_view_course_registration() {

		student = profileService.findStudentByMatricNo(matricNo);
		student.getName();
		LOG.debug("student name :{}", student.getName());
		
		//student status
		studentStatus = student.getStudentStatus();
		LOG.debug("Student Status:{}",student.getStudentStatus().name());
		
		//cohort
		cohort = student.getCohort();
		LOG.debug("Student Cohort:{}",student.getCohort().getCode());
		//program
		program = cohort.getProgram();
		LOG.debug("Student Program:{}",student.getCohort().getProgram().getCode());
		//faculty
		faculty = program.getFaculty();
		LOG.debug("Student Faculty:{}",student.getCohort().getProgram().getFaculty().getName());
		//level of study
		level = program.getLevel();
		LOG.debug("Student Level:{}",student.getCohort().getProgram().getLevel().getCode());
		//Courses
		AdAcademicSession session = plannerService.findAcademicSessionByCode("201720181");
		AdAdmission admission = new AdAdmissionImpl();
		admission.setCohort(cohort);
		admission.setCgpa(BigDecimal.ZERO);
		admission.setGpa(BigDecimal.ZERO);
		admission.setCreditTaken(10);
		admission.setCreditEarned(10);
		admission.setOrdinal(1);
		admission.setStudent(student);
		admission.setStatus(AdAdmissionStatus.REGULAR);
		admission.setStanding(AdAcademicStanding.KB);
		admission.setStudyCenter(commonService.findStudyCenterByCode("A"));
		admission.setSession(session);
		//admission.setEnrollments(enrollments);
		termService.saveAdmission(admission);
		LOG.debug("admision:{}",admission);
		LOG.debug("admision student name:{}",admission.getStudent().getName());
		AdAdmission admissionByStudent =termService.findAdmissionByAcademicSessionCohortAndStudent(session, cohort, student);
		LOG.debug("AdmissionByStudent:{}",admissionByStudent.getCgpa());
		LOG.debug("AdmissionByStudent:{}",admissionByStudent.getGpa());
		LOG.debug("AdmissionByStudent:{}",admissionByStudent.getCohort().getCode());
		LOG.debug("AdmissionByStudent:{}",admissionByStudent.getStudent().getName());
		LOG.debug("AdmissionByStudent:{}",admissionByStudent.getSession().getCode());
		
//		if (studentStatus == AdStudentStatus.ACTIVE) {
//			// student details
//			LOG.debug("==========================");
//			LOG.debug("MAKLUMAT BIODATA PELAJAR");
//			LOG.debug("==========================");
//			LOG.debug("Student's Name:{}", student.getName());
//			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
//			// student status
//			LOG.debug("Student's status: {}", studentStatus.name());
//			// student cohort
//			LOG.debug("Student's Cohort: {}", cohort.getCode());
//			// program
//			LOG.debug("Program :{}", program.getCode());
//			// program level
//			LOG.debug("Program Level :{}", level.getCode());
//			// faculty
//			LOG.debug("Faculty:{}", faculty.getName());
//			LOG.debug("=========================");
//			LOG.debug("MAKLUMAT COURSE & FAKULTI");
//			LOG.debug("=========================");
//			// courses
//			for (AdCourse course : courses)
//				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitleMs());
//
//		} else if (studentStatus == AdStudentStatus.MATRICULATED) {
//			// student details
//			LOG.debug("========================");
//			LOG.debug("MAKLUMAT BIODATA PELAJAR");
//			LOG.debug("========================");
//			LOG.debug("Student's Name:{}", student.getName());
//			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
//			// student status
//			LOG.debug("Student's status: {}", studentStatus.name());
//			// student cohort
//			LOG.debug("Student's Cohort: {}", cohort.getCode());
//			// program
//			LOG.debug("Program :{}", program.getCode());
//			// program level
//			LOG.debug("Program Level :{}", level.getCode());
//			// faculty
//			LOG.debug("Faculty:{}", faculty.getName());
//			LOG.debug("=========================");
//			LOG.debug("MAKLUMAT COURSE & FAKULTI");
//			LOG.debug("=========================");
//			// courses
//			for (AdCourse course : courses)
//				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitleMs());
//
//		} else if (studentStatus == AdStudentStatus.INACTIVE) {
//			// student details
//			LOG.debug("========================");
//			LOG.debug("MAKLUMAT BIODATA PELAJAR");
//			LOG.debug("========================");
//			LOG.debug("Student's Name:{}", student.getName());
//			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
//			// student status
//			LOG.debug("Student's status: {}", studentStatus.name());
//			// student cohort
//			LOG.debug("Student's Cohort: {}", cohort.getCode());
//			// program
//			LOG.debug("Program :{}", program.getCode());
//			// program level
//			LOG.debug("Program Level :{}", level.getCode());
//			// faculty
//			LOG.debug("Faculty:{}", faculty.getName());
//			LOG.debug("=========================");
//			LOG.debug("MAKLUMAT COURSE & FAKULTI");
//			LOG.debug("=========================");
//			
//
//		} else if (studentStatus == AdStudentStatus.BARRED) {
//			// student details
//			LOG.debug("========================");
//			LOG.debug("MAKLUMAT BIODATA PELAJAR");
//			LOG.debug("========================");
//			LOG.debug("Student's Name:{}", student.getName());
//			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
//			// student status
//			LOG.debug("Student's status: {}", studentStatus.name());
//			// student cohort
//			LOG.debug("Student's Cohort: {}", cohort.getCode());
//			// program
//			LOG.debug("Program :{}", program.getCode());
//			// program level
//			LOG.debug("Program Level :{}", level.getCode());
//			// faculty
//			LOG.debug("Faculty:{}", faculty.getName());
//			LOG.debug("=========================");
//			LOG.debug("MAKLUMAT COURSE & FAKULTI");
//			LOG.debug("=========================");
//			// courses
//			for (AdCourse course : courses)
//				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitleMs());
//
//		} else if (studentStatus == AdStudentStatus.GRADUATED) {
//
//			// student details
//			LOG.debug("========================");
//			LOG.debug("MAKLUMAT BIODATA PELAJAR");
//			LOG.debug("========================");
//			LOG.debug("Student's Name:{}", student.getName());
//			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
//			// student status
//			LOG.debug("Student's status: {}", studentStatus.name());
//			// student cohort
//			LOG.debug("Student's Cohort: {}", cohort.getCode());
//			// program
//			LOG.debug("Program :{}", program.getCode());
//			// program level
//			LOG.debug("Program Level :{}", level.getCode());
//			// faculty
//			LOG.debug("Faculty:{}", faculty.getName());
//			LOG.debug("=========================");
//			LOG.debug("MAKLUMAT COURSE & FAKULTI");
//			LOG.debug("=========================");
//			// courses
//			for (AdCourse course : courses)
//				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitleMs());
//		} else {
//
//			LOG.debug("You Are Not Registered Student");
//		}
//		;

		return self();

	}

}
