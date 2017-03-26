package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIAddProgramLevel extends Stage<WhenIAddProgramLevel> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddProgramLevel.class);
    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private String PROGRAM_CODE;

    public WhenIAddProgramLevel I_add_a_program_level_for_faculty_$(String facultycode) {

        faculty = plannerService.findFacultyByCode(facultycode);
        AdProgramLevel programLevel = new AdProgramLevelImpl();

        programLevel.setType(AdProgramType.MASTER);
        programLevel.setCode(PROGRAM_CODE);
        programLevel.setDescription("CURRENT MASTER PROGRAM");

        plannerService.saveProgramLevel(programLevel);
        return self();

    }


}
