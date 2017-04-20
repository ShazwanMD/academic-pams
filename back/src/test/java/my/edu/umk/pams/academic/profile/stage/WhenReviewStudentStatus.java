package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.profile.service.ProfileService;

@JGivenStage
public class WhenReviewStudentStatus extends Stage<WhenReviewStudentStatus> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentStatus.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ProfileService profileService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private List<AdCourse> courses;

	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdCohort cohort;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	public WhenReviewStudentStatus I_view_student_current_status_for_$(String identityNo) {

		student = identityService.findStudentByMatricNo(identityNo);
		Assert.notNull(student, "Student Must Not NULL");
		studentStatus = student.getStudentStatus();
		
		cohort = student.getCohort();
		
		program = cohort.getProgram();
		Assert.isTrue(true, "Program Must Exists");
		
		faculty = program.getFaculty();
		Assert.notNull(faculty, "Faculty Must Not NULL");
		courses = faculty.getCourses();

		if (studentStatus == AdStudentStatus.ACTIVE) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

			LOG.debug("Faculty Name :{}", faculty.getName());

			LOG.debug("Program CODE:{}", program.getCode());
			LOG.debug("Program Details:{}", program.getTitle());
			LOG.debug("Program Details:{}", program.getTitleEn());
			LOG.debug("Program Details:{}", program.getTitleMs());

			for (AdCourse course : courses)
				LOG.debug("Course's Registered:{}", course.getCode());

		} else if (studentStatus == AdStudentStatus.MATRICULATED) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

		} else if (studentStatus == AdStudentStatus.INACTIVE) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

		} else if (studentStatus == AdStudentStatus.BARRED) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

		} else if (studentStatus == AdStudentStatus.GRADUATED) {

			LOG.debug("Student's Name:{}", student.getName());
			LOG.debug("Student's MatricNo:{}", student.getMatricNo());

			LOG.debug("Student's status: {}", studentStatus.name());
			LOG.debug("Student's status: {}", studentStatus.ordinal());

			LOG.debug("Faculty Name :{}", faculty.getName());

			LOG.debug("Program CODE:{}", program.getCode());
			LOG.debug("Program Taken:{}", program.getTitle());
			LOG.debug("Program Taken:{}", program.getTitleEn());
			LOG.debug("Program Taken:{}", program.getTitleMs());

			for (AdCourse course : courses)
				LOG.debug("Course's Taken:{}", course.getCode());
			
			
		} else {

			LOG.debug("You Are Not Registered Student");
		}
		;

		//Activate student status from old status
        student.setStudentStatus(AdStudentStatus.ACTIVE);
        profileService.activateStudent(student);
        LOG.debug("StudentNewStatus:{}",student.getStudentStatus());
    	
		return self();

	}

}
