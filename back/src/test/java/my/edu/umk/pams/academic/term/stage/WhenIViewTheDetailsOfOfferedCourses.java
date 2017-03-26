package my.edu.umk.pams.academic.term.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
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
	private List<AdOffering> offering;
	
	@ProvidedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	private String code;
	
	@ProvidedScenarioState
	private AdFaculty faculty;

	public WhenIViewTheDetailsOfOfferedCourses() {
		AdOffering offering = new AdOfferingImpl();
	}
	
	public WhenIViewTheDetailsOfOfferedCourses I_view_the_details_offered_courses_for_program_$(String code) {
	
		program = plannerService.findProgramByCode(code);
        offering = termService.findOfferings(program);
        String code1 = "FKP"; 
        AdFaculty faculty = plannerService.findFacultyByCode(code1);
        List<AdCourse> courses = plannerService.findCourses(faculty);
              
        for (AdOffering offering : offering) {
            LOG.debug(offering.getTitle());
        }
        
        for (AdOffering offering : offering) {
            LOG.debug(offering.getCode());
        }
        
        for (AdCourse course : courses) {
            LOG.debug(course.getTitleEn());
        }
        
        for (AdCourse course : courses) {
           LOG.debug("  credit:  "+ course.getCredit());
        }
        
        return self();
	}
}
