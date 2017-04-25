package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.model.AdProgramLevelImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramType;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenAdminAddProgramLevel extends Stage<WhenAdminAddProgramLevel> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddProgramLevel.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String FACULTY_CODE;

    @ProvidedScenarioState
    private String PROGRAM_LEVEL_CODE = "POSTGRAD";

    @ExpectedScenarioState
    private AdProgramType programType;


    public WhenAdminAddProgramLevel i_add_a_program_level_post_graduate_for_faculty() {
        Assert.notNull(FACULTY_CODE, "FACULTY_CODE cannot be null");
        Assert.notNull(programType, "programType cannot be null");

        faculty = plannerService.findFacultyByCode(FACULTY_CODE); //todo: faculty is unused

        AdProgramLevel programLevel = new AdProgramLevelImpl();
        programLevel.setType(programType);
        programLevel.setCode(PROGRAM_LEVEL_CODE);
        programLevel.setDescription("bru");
        programLevel.setPrefix("PG");

        plannerService.saveProgramLevel(programLevel);
        return self();

    }


}
