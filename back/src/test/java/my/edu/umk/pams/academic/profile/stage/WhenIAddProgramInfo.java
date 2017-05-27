package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIAddProgramInfo extends Stage<WhenIAddProgramInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddProgramInfo.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String facultyCode;
    
    public WhenIAddProgramInfo I_add_program_info_$(String facultyCode) {

        faculty = plannerService.findFacultyByCode(facultyCode);

        AdProgramLevel programLevel = plannerService.findProgramLevelByCode("MASTER");


        AdProgram program = new AdProgramImpl();
        
        program.setCode(facultyCode);
        program.setFaculty(faculty);
        program.setLevel(programLevel);
        program.setTitleEn("Master of SAM");
        program.setTitleMs("Master of SAM");
   
        plannerService.saveProgram(program,faculty);

        return self();
    }

    public WhenIAddProgramInfo I_view_program_info_$(String facultyCode) {

        faculty = plannerService.findFacultyByCode(facultyCode);
        List<AdProgram> program = plannerService.findPrograms(faculty);

        for (AdProgram programs : program) {
            LOG.debug(programs.getTitleMs());
            LOG.debug(programs.getTitleEn());
        }
        return self();

    }


}
