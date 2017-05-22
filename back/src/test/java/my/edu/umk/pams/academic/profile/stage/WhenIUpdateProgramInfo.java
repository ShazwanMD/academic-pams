package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIUpdateProgramInfo extends Stage<WhenIUpdateProgramInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateProgramInfo.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private List<AdFaculty> faculty;


    @ExpectedScenarioState
    private String code;

    public WhenIUpdateProgramInfo I_update_program_info() {

        AdProgram program = new AdProgramImpl();
        program.setFaculty(plannerService.findFacultyByCode(code));
        program.setCode(code);
        program.setTitleEn("2");
        program.setTitleMs("3");

        plannerService.updateProgram(program);

        return self();
    }

}
