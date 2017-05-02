package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenReviewEnrollmentDetails extends Stage<WhenReviewEnrollmentDetails> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewEnrollmentDetails.class);

	@Autowired
	private IdentityService identityService;

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdStudentStatus studentStatus;

	@ProvidedScenarioState
	private List<AdCourse> courses;

	@ProvidedScenarioState
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
			
		offering = termService.findOfferingByCanonicalCode("MGSEB/MBA/GST5023");
		LOG.debug("Student's Offering Code: {}", offering.getCanonicalCode());

		section = termService.findSectionByCanonicalCode("MGSEB/MBA/GST5023/201720181");
		LOG.debug("Student's Section Code: {}", section.getCanonicalCode());

		return self();
	}

}
