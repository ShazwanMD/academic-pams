package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIViewTheDetailsOfOfferedCourses extends Stage<WhenIViewTheDetailsOfOfferedCourses> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewTheDetailsOfOfferedCourses.class);

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private List<AdOffering> offerings;

	@ProvidedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private String code;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private AdFaculty faculty;

	public WhenIViewTheDetailsOfOfferedCourses I_view_the_details_offered_courses_for_program_$(String code) {

		program = plannerService.findProgramByCode(code);

		offerings = termService.findOfferings(program);
		Assert.notEmpty(offerings, "offerings are empty");

		for (AdOffering offering : offerings) {

			LOG.debug("==================view details offered course===================");
			LOG.debug("courses for this program : {}", offering.getCourse().getTitleEn());
			LOG.debug("courses for this program : {}", offering.getCourse().getTitleMs());
			LOG.debug("credit for this course : {}", offering.getCourse().getCredit());
			LOG.debug("");

		}

		return self();
	}
}
