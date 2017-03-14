package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.*;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIAdACohort extends Stage<WhenIAdACohort> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAdACohort.class);

    @Autowired
    private StudyplanService studyplanService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdProgram program;

    public WhenIAdACohort I_want_to_set_up_cohort_for_$_faculty(String code) {
        program = studyplanService.findProgramByCode("MEM");

        // setup curriculum
        AdCurriculum curriculum = new AdCurriculumImpl();
        curriculum.setCode("CRLM-" + System.currentTimeMillis());
        curriculum.setTitleMs("englishTitle");
        curriculum.setTitleEn("malayTitle");
        curriculum.setShortTitle("bagus");
        curriculum.setCoreCredit(10);
        curriculum.setCurriculumCredit(10);
        curriculum.setElectiveCredit(0);
        curriculum.setGeneralCredit(0);
        curriculum.setLanguageCredit(0);
        curriculum.setRequiredCredit(0);
        curriculum.setTotalCredit(10);
        curriculum.setMaxPeriod(0);
        curriculum.setOrdinal(0);
        curriculum.setOthersCredit(0);
        curriculum.setPeriod(0);
        studyplanService.saveCurriculum(curriculum);

        // setup cohort
        AdCohort cohort = new AdCohortImpl();
        cohort.setCode("PRGM-1234");
        cohort.setDescription("bahasa melayu");
        cohort.setClassification(AdAcademicClassification.LEVEL_000);
        cohort.setCurriculum(curriculum);
        cohort.setProgram(program);
        studyplanService.saveCohort(cohort);

        return self();
    }
}
