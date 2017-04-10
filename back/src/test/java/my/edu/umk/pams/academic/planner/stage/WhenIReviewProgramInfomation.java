package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

@JGivenStage
public class WhenIReviewProgramInfomation extends Stage<WhenIReviewProgramInfomation> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewProgramInfomation.class);

    @Autowired
    private PlannerService plannerService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private String code;

    @ExpectedScenarioState
    private List<AdProgram> programs;

    public WhenIReviewProgramInfomation() {
        AdProgram program = new AdProgramImpl();

    }

    public WhenIReviewProgramInfomation I_Review_program_by_faculty_$(String code) {

        faculty = plannerService.findFacultyByCode(code);
        List<AdProgram> program = plannerService.findPrograms(faculty);

        for (AdProgram programs : program) {
            LOG.debug(programs.getCode());
            
        }

        for (AdProgram programs : program) {
            LOG.debug(programs.getTitle());
        }

        for (AdProgram programs : program) {
            LOG.debug(programs.getTitleEn());
        }
        for (AdProgram programs : program) {
            LOG.debug(programs.getTitleMs());
        }

        return self();
    }

}

