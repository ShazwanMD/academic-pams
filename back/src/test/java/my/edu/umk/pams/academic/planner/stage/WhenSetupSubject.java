package my.edu.umk.pams.academic.planner.stage;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenSetupSubject extends Stage<WhenSetupSubject> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenSetupSubject.class);

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	AdCohort cohort;

	@ProvidedScenarioState
	private AdCurriculum curriculum;

//	private String curriculumCode = "MGSEB/MBA";
//	private String courseCode = "GST5013";

	public WhenSetupSubject I_setup_subject_$(String code) {

		LOG.debug("faculty {}" , faculty);
		
	
		curriculum= cohort.getCurriculum();
		
		LOG.debug("curriculum {}" , curriculum);
		
		course = plannerService.findCourseByCode("GST5013");
//		Subject = plannerService.findSubjectByCurriculumAndCourse(curriculum, course);
		
		AdSingleSubject subject = new AdSingleSubjectImpl();


		subject.setSubjectType(AdSubjectType.ELECTIVE);
		subject.setPeriod(AdAcademicPeriod.II);
		subject.setCurriculum(curriculum);
		subject.setCourse(course);
	
		plannerService.addSubject(curriculum, subject);

		return self();
	}
}
