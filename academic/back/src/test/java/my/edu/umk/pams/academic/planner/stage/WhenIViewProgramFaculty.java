package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@JGivenStage
public class WhenIViewProgramFaculty extends Stage<WhenIViewProgramFaculty> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIViewProgramFaculty.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private List<AdProgram> program;


    public WhenIViewProgramFaculty() {
        AdFaculty faculty = new AdFacultyImpl();
    }

    public WhenIViewProgramFaculty I_want_to_view_program_for_faculty_$(String code) {

        faculty = plannerService.findFacultyByCode(code);

        program = plannerService.findPrograms(faculty);

        for (AdProgram program : program) {
            LOG.debug(program.getTitle());
        }
        return self();

    }

}
