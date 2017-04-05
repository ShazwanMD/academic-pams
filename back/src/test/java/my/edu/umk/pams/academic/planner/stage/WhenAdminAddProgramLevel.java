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
public class WhenAdminAddProgramLevel extends Stage<WhenAdminAddProgramLevel> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddProgramLevel.class);
    
    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private String PROGRAM_CODE;

    public WhenAdminAddProgramLevel Admin_add_a_program_level_for_faculty_$(String facultycode) {

        faculty = plannerService.findFacultyByCode(facultycode);
        
        AdProgramLevel programLevel = new AdProgramLevelImpl();
        programLevel.setType(AdProgramType.MASTER);
        programLevel.setCode(PROGRAM_CODE);
        programLevel.setDescription("bru");

        plannerService.saveProgramLevel(programLevel);
        return self();

    }


}
