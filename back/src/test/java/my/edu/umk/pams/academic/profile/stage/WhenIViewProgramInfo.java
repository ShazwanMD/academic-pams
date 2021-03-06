package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIViewProgramInfo extends Stage<WhenIViewProgramInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIViewProgramInfo.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private String code;

    @ExpectedScenarioState
    private AdFaculty faculty;

    public WhenIViewProgramInfo() {
        AdProgram program = new AdProgramImpl();
    }

    public WhenIViewProgramInfo I_view_program_info_for_faculty_$(String code) {

        faculty = plannerService.findFacultyByCode(code);
        List<AdProgram> program = plannerService.findPrograms(faculty);

        for (AdProgram programs : program) {
            LOG.debug(programs.getTitleMs());
            LOG.debug(programs.getTitleEn());
        }
        return self();
    }


}
