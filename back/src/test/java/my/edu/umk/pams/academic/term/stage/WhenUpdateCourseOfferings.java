package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author asyikin.mr and ziana
 */

@JGivenStage
public class WhenUpdateCourseOfferings extends Stage<WhenUpdateCourseOfferings> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenUpdateCourseOfferings.class);

	@Autowired
	private TermService termService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdOffering offering;

	public WhenUpdateCourseOfferings I_update_course_offerings_for_the_program() {

		// find faculty of the program
		LOG.debug("Pick faculty: {}", faculty.getCode());
		LOG.debug("Pick program: {}", program.getCode());

		// list of programs under selected faculty
		List<AdProgram> programs = plannerService.findPrograms(faculty);

		for (AdProgram program : programs) {
			LOG.debug("Listed program Code: {}", program.getCode());
			LOG.debug("Listed program Title: {}", program.getTitleMs());
			LOG.debug("Listed program Title: {}", program.getTitleEn());

		}

		// list all of offering course under selected faculty and program
		List<AdOffering> offerings = termService.findOfferings(program);

		for (AdOffering offering : offerings) {
			LOG.debug("=======view current offering data=============");
			LOG.debug("Listed offering CanonicalCode: {}", offering.getCanonicalCode());
			LOG.debug("Listed offering Title: {}", offering.getTitleMs());
			LOG.debug("Listed offering Capacity: {}", offering.getCapacity());

			// update offer courses info into offering table
			offering.setCapacity(200);
			termService.updateOffering(offering);

			Assert.notNull(offering, "The updated offering data must not be null");
			LOG.debug("=======view updated offering data=============");
			LOG.debug("Updated success for offering code : {}", offering.getCanonicalCode());
			LOG.debug("Listed offering Title: {}", offering.getTitleMs());
			LOG.debug("Updated success for new capacity : {}", offering.getCapacity());

		}

		return self();
	}

}
