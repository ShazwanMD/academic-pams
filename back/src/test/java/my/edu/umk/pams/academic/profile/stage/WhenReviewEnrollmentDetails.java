package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
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
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenReviewEnrollmentDetails extends Stage<WhenReviewEnrollmentDetails> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewEnrollmentDetails.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private List<AdCourse> courses;

	@ExpectedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdProgramLevel level;

	@ProvidedScenarioState
	private AdFaculty faculty;

	public WhenReviewEnrollmentDetails lecturer_review_enrollment_details(String identityNo) {

		student = identityService.findStudentByMatricNo(identityNo);
		LOG.debug("Student's Matric No: {}", student.getName());
		
		studentStatus = student.getStudentStatus();
		LOG.debug("Student's Status:{}", studentStatus.name());
		
		cohort = student.getCohort();
		LOG.debug("Student's Cohort:{}", cohort.getCode());
		
		program = cohort.getProgram();
		LOG.debug("Program Registered:{}", program.getCode());
		
		faculty = program.getFaculty();
		LOG.debug("Faculty:{}", faculty.getName());
		
		level = program.getProgramLevel();
		LOG.debug("Level of Study:{}", level.getDescription());
		
		courses = faculty.getCourses();
		for (AdCourse course : courses)
			LOG.debug("Course(s):{}", course.getCode());
			
		offering = termService.findOfferingByCanonicalCode("A01/PHD/0001/DDA2113");
		LOG.debug("Student's Offering Code: {}", offering.getCanonicalCode());

		section = termService.findSectionByCanonicalCode("A01/PHD/0001/DDA2113/201720181");
		LOG.debug("Student's Section Code: {}", section.getCanonicalCode());

		return self();
	}

}
