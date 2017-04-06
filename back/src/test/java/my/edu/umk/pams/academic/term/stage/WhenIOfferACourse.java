package my.edu.umk.pams.academic.term.stage;

/**
 * @author asyikin.mr and ziana
 */
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@JGivenStage
public class WhenIOfferACourse extends Stage<WhenIOfferACourse> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIOfferACourse.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	public WhenIOfferACourse I_offer_all_courses_under_program_faculty() {

		// find faculty of the program
		LOG.debug("Pick faculty: {}", faculty.getCode());
		AdProgram program = plannerService.findProgramByCode("A01/MASTER/0001");

		// find ALL courses under this faculty to be offered by this program
		List<AdCourse> courses = plannerService.findCourses(faculty);
		for (AdCourse course : courses) {

			LOG.debug("Listed Courses ID: {}", course.getId());
			LOG.debug("Listed Courses Code: {}", course.getCode());
			LOG.debug("Listed Courses Title: {}", course.getTitle());
			LOG.debug("Listed Program ID: {}", program.getId());

			String canonicalCode = program.getCode() + "/" + course.getCode();

			LOG.debug("Listed canonicalCode offering : {}", canonicalCode);

			AdCourse course1 = plannerService.findCourseById(course.getId());
			AdProgram program1 = plannerService.findProgramById(program.getId());

			// Add offer courses into offering table
			AdOffering offering = new AdOfferingImpl();
			offering.setCode(course.getCode());
			offering.setCanonicalCode(canonicalCode);
			offering.setTitle(course.getTitle());
			offering.setCapacity(30);
			offering.setCourse(course1);
			offering.setProgram(program1);

			termService.saveOffering(offering);

		}

		return self();
	}

}
