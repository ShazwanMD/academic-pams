package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author ZAIDA_AIN
 */
@JGivenStage
public class WhenAdminAddAProgram extends Stage<WhenAdminAddAProgram> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddAProgram.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String PROGRAM_CODE;

    public WhenAdminAddAProgram Admin_add_a_program_for_faculty_$(String facultyCode) {
        faculty = plannerService.findFacultyByCode(facultyCode);
        AdProgramLevel programLevel = plannerService.findProgramLevelByCode("MASTER");
        Assert.notNull(faculty, "faculty CANNOT be null");

        AdProgram program = new AdProgramImpl();
        program.setCode(PROGRAM_CODE);
        program.setFaculty(faculty);
        program.setProgramLevel(programLevel);
        program.setTitle("Master of Enterpreneurship");
        program.setTitleEn("Master of Enterpreneurship");
        program.setTitleMs("Master of Enterpreneurship");
        plannerService.saveProgram(program);

        return self();
    }

}