package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.term.model.AdChargeScheduleImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@JGivenStage
public class WhenISetupChargeSchedule extends Stage<WhenISetupChargeSchedule> {
    private static final Logger LOG = LoggerFactory.getLogger(WhenISetupChargeSchedule.class);


    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ExpectedScenarioState
    private AdProgram program;

    @ProvidedScenarioState
    private AdCohort cohort;

    @ProvidedScenarioState
    private AdStudyCenter center;

    private AdCurriculum getCurriculum() {
        Assert.notNull(program, "program cannot be null");

        List<AdCurriculum> curriculums = plannerService.findCurriculums(program);
        Assert.notEmpty(curriculums, "curriculums cannot be empty");
        return curriculums.get(0); // TODO: Flakey get first, should get object explicitly
    }

    private AdCohort prepareCohort(String cohortCode) {
        cohort = new AdCohortImpl();
        cohort.setCode(cohortCode);
        cohort.setCurriculum(getCurriculum());
        cohort.setClassification(AdAcademicClassification.LEVEL_MASTER);
        cohort.setProgram(program);
        plannerService.saveCohort(cohort);
        return cohort;
    }

    private void prepareStudyCenter() {
        center = new AdStudyCenterImpl();
        center.setCode("SET_MY_KODE_B");
        center.setDescription("Please describe me");
//        commonService.saveStudyCenter(center); // todo(syikin): impl missing service method
    }

    private void prepareDependencies(String cohortCode) {
        Assert.notNull(cohortCode, "cohortCode cannot be null");

        prepareCohort(cohortCode);
        Assert.notNull(cohort, "cohort cannot be null");

        prepareStudyCenter();
        Assert.notNull(center, "center cannot be null");

        Assert.notNull(program, "program cannot be null");
    }

    @Pending
    public WhenISetupChargeSchedule I_setup_charge_schedule_for_cohort_$(String cohortCode) {
        prepareDependencies(cohortCode);

        AdChargeSchedule schedule = new AdChargeScheduleImpl();
        schedule.setAmount(new BigDecimal("150.00"));
        schedule.setCode("SET_MY_KODE_A");
        schedule.setPeriod(AdAcademicPeriod.I);
        schedule.setProgram(program);
        schedule.setStudyCenter(center);
        schedule.setCohort(cohort);

        return self();
    }
}