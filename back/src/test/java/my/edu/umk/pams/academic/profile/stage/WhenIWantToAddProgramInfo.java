package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgramLevel;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIWantToAddProgramInfo extends Stage<WhenIWantToAddProgramInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToAddProgramInfo.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String PROGRAM_CODE;


    public WhenIWantToAddProgramInfo I_add_program_info_$(String facultyCode) {

        faculty = studyplanService.findFacultyByCode(facultyCode);

        AdProgramLevel programLevel = studyplanService.findProgramLevelByCode("MASTER");


        AdProgram program = new AdProgramImpl();
        program.setCode(PROGRAM_CODE);
        program.setFaculty(faculty);
        program.setProgramLevel(programLevel);
        program.setTitle("Master of SAM");
        program.setTitleEn("Master of SAM");
        program.setTitleMs("Master of SAM");
        studyplanService.saveProgram(program);

        return self();
    }

    public WhenIWantToAddProgramInfo I_view_program_info_$(String facultyCode) {

        faculty = studyplanService.findFacultyByCode(facultyCode);
        List<AdProgram> program = studyplanService.findPrograms(faculty);

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
