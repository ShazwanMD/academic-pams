package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIAddACohort extends Stage<WhenIAddACohort> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddACohort.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdProgram program;

    @ProvidedScenarioState
    private AdCurriculum curriculum;

    public WhenIAddACohort I_want_to_set_up_cohort_for_$_program(String code) {
        program = plannerService.findProgramByCode(code);

        // find existing curriculum
        curriculum = plannerService.findCurriculumByCode(code + "/CRLM/0001");

        // setup cohort
        AdCohort cohort = new AdCohortImpl();
        cohort.setCode(code + "/CHRT/0002"); // second cohort
        cohort.setDescription("SECOND COHORT FOR PROGRAM " + code);
        cohort.setClassification(AdAcademicClassification.LEVEL_000);
        cohort.setCurriculum(curriculum);
        cohort.setProgram(program);
        plannerService.saveCohort(cohort);

        return self();
    }
}
