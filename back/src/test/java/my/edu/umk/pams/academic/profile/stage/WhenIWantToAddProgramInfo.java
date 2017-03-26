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
public class WhenIWantToAddProgramInfo extends Stage<WhenIWantToAddProgramInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToAddProgramInfo.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String facultyCode;
    



    public WhenIWantToAddProgramInfo I_add_program_info_$(String facultyCode) {

        faculty = plannerService.findFacultyByCode(facultyCode);

        AdProgramLevel programLevel = plannerService.findProgramLevelByCode("MASTER");


        AdProgram program = new AdProgramImpl();
        
        program.setCode(facultyCode);
        program.setFaculty(faculty);
        program.setProgramLevel(programLevel);
        program.setTitle("Master of SAM");
        program.setTitleEn("Master of SAM");
        program.setTitleMs("Master of SAM");
   
        plannerService.saveProgram(program);

        return self();
    }

    public WhenIWantToAddProgramInfo I_view_program_info_$(String facultyCode) {

        faculty = plannerService.findFacultyByCode(facultyCode);
        List<AdProgram> program = plannerService.findPrograms(faculty);

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
