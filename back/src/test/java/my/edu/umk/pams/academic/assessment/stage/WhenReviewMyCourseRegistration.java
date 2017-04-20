package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenReviewMyCourseRegistration extends Stage<WhenReviewMyCourseRegistration> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewMyCourseRegistration.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

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

	public WhenReviewMyCourseRegistration i_want_to_view_course_registration(String identityNo) {

		student = identityService.findStudentByMatricNo(identityNo);
		student.setName("SAM");
		identityService.updateStudent(student);
		studentStatus = student.getStudentStatus();
		cohort = student.getCohort();

		program = cohort.getProgram();
		faculty = program.getFaculty();
		level = program.getProgramLevel();
		courses = faculty.getCourses();

		if (studentStatus == AdStudentStatus.ACTIVE) {
			// student details
			LOG.debug("==========================");
			LOG.debug("MAKLUMAT BIODATA PELAJAR");
			LOG.debug("==========================");
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			// student status
			LOG.debug("Student's status: {}", studentStatus.name());
			// student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			// program
			LOG.debug("Program :{}", program.getCode());
			// program level
			LOG.debug("Program Level :{}", level.getCode());
			// faculty
			LOG.debug("Faculty:{}", faculty.getName());
			LOG.debug("=========================");
			LOG.debug("MAKLUMAT COURSE & FAKULTI");
			LOG.debug("=========================");
			// courses
			for (AdCourse course : courses)
				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitle());

		} else if (studentStatus == AdStudentStatus.MATRICULATED) {
			// student details
			LOG.debug("========================");
			LOG.debug("MAKLUMAT BIODATA PELAJAR");
			LOG.debug("========================");
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			// student status
			LOG.debug("Student's status: {}", studentStatus.name());
			// student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			// program
			LOG.debug("Program :{}", program.getCode());
			// program level
			LOG.debug("Program Level :{}", level.getCode());
			// faculty
			LOG.debug("Faculty:{}", faculty.getName());
			LOG.debug("=========================");
			LOG.debug("MAKLUMAT COURSE & FAKULTI");
			LOG.debug("=========================");
			// courses
			for (AdCourse course : courses)
				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitle());

		} else if (studentStatus == AdStudentStatus.INACTIVE) {
			// student details
			LOG.debug("========================");
			LOG.debug("MAKLUMAT BIODATA PELAJAR");
			LOG.debug("========================");
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			// student status
			LOG.debug("Student's status: {}", studentStatus.name());
			// student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			// program
			LOG.debug("Program :{}", program.getCode());
			// program level
			LOG.debug("Program Level :{}", level.getCode());
			// faculty
			LOG.debug("Faculty:{}", faculty.getName());
			LOG.debug("=========================");
			LOG.debug("MAKLUMAT COURSE & FAKULTI");
			LOG.debug("=========================");
			// courses
			for (AdCourse course : courses)
				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitle());

		} else if (studentStatus == AdStudentStatus.BARRED) {
			// student details
			LOG.debug("========================");
			LOG.debug("MAKLUMAT BIODATA PELAJAR");
			LOG.debug("========================");
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			// student status
			LOG.debug("Student's status: {}", studentStatus.name());
			// student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			// program
			LOG.debug("Program :{}", program.getCode());
			// program level
			LOG.debug("Program Level :{}", level.getCode());
			// faculty
			LOG.debug("Faculty:{}", faculty.getName());
			LOG.debug("=========================");
			LOG.debug("MAKLUMAT COURSE & FAKULTI");
			LOG.debug("=========================");
			// courses
			for (AdCourse course : courses)
				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitle());

		} else if (studentStatus == AdStudentStatus.GRADUATED) {

			// student details
			LOG.debug("========================");
			LOG.debug("MAKLUMAT BIODATA PELAJAR");
			LOG.debug("========================");
			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());
			// student status
			LOG.debug("Student's status: {}", studentStatus.name());
			// student cohort
			LOG.debug("Student's Cohort: {}", cohort.getCode());
			// program
			LOG.debug("Program :{}", program.getCode());
			// program level
			LOG.debug("Program Level :{}", level.getCode());
			// faculty
			LOG.debug("Faculty:{}", faculty.getName());
			LOG.debug("=========================");
			LOG.debug("MAKLUMAT COURSE & FAKULTI");
			LOG.debug("=========================");
			// courses
			for (AdCourse course : courses)
				LOG.debug("Course / Desc:{}", course.getCode() + "/" + course.getTitle());
		} else {

			LOG.debug("You Are Not Registered Student");
		}
		;

		return self();

	}

}
