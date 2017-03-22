package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIWantToViewProgramByFaculty extends Stage<WhenIWantToViewProgramByFaculty> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewProgramByFaculty.class);

    @Autowired
    private StudyplanService studyplanService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private String code;

    @ExpectedScenarioState
    private List<AdProgram> programs;

    public WhenIWantToViewProgramByFaculty() {
        AdProgram program = new AdProgramImpl();

    }

    public WhenIWantToViewProgramByFaculty I_want_to_view_program_by_faculty_$(String code) {

        faculty = studyplanService.findFacultyByCode(code);
        List<AdProgram> program = studyplanService.findPrograms(faculty);

        for (AdProgram programs : program) {
            LOG.debug(programs.getCode());
        }

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

