package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@JGivenStage
public class WhenAdminReviewProgram extends Stage<WhenAdminReviewProgram> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminReviewProgram.class);

    @Autowired
    private PlannerService plannerService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private List<AdProgram> programs;
    
    @ExpectedScenarioState
    private String code;


    public WhenAdminReviewProgram Admin_review_program_for_that_faculty_$(String code) {
    	
    	faculty = plannerService.findFacultyByCode(code);
    	LOG.debug("Faculty name : {} ", faculty.getName());
    	LOG.debug("Faculty code : {} ", faculty.getCode());
    	
         List<AdProgram> program = plannerService.findPrograms(faculty);

         for (AdProgram programs : program) {
             LOG.debug(programs.getCode());
         }

         for (AdProgram programs : program) {
             LOG.debug(programs.getTitleMs());
             LOG.debug(programs.getTitleEn());
         }
        return self();
    }
}
