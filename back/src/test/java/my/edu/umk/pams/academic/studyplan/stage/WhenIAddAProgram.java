package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgramType;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    public WhenIAddAProgram I_add_a_program_for_$_faculty(String code) {
        faculty = studyplanService.findFacultyByCode(code);
        AdProgram program = new AdProgramImpl();
        program.setCode("PRGM-1234");
        program.setFaculty(faculty);
        program.setProgramType(AdProgramType.MASTER);
        program.setTitle("Master of Enterpreneurship");
        program.setTitleEn("Master of Enterpreneurship");
        program.setTitleMs("Master of Enterpreneurship");
        studyplanService.saveProgram(program);
        return self();
    }

}