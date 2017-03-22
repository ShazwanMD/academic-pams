package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgramLevel;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIAddAProgram extends Stage<WhenIAddAProgram> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddAProgram.class);

    @Autowired
    private StudyplanService studyplanService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private String PROGRAM_CODE;

    public WhenIAddAProgram I_add_a_program_for_faculty_$(String facultyCode) {
        faculty = studyplanService.findFacultyByCode(facultyCode);
        AdProgramLevel programLevel = studyplanService.findProgramLevelByCode("MASTER");
        Assert.notNull(faculty, "faculty CANNOT be null");

        AdProgram program = new AdProgramImpl();
        program.setCode(PROGRAM_CODE);
        program.setFaculty(faculty);
        program.setProgramLevel(programLevel);
        program.setTitle("Master of Enterpreneurship");
        program.setTitleEn("Master of Enterpreneurship");
        program.setTitleMs("Master of Enterpreneurship");
        studyplanService.saveProgram(program);

        return self();
    }

}