package my.edu.umk.pams.academic.studyplan.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenProgramIsIntroduced extends Stage<ThenProgramIsIntroduced> {

    private static final Logger LOG = LoggerFactory.getLogger(ThenProgramIsIntroduced.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    AdFaculty faculty;

    public ThenProgramIsIntroduced the_program_$_is_introduced_for_faculty_$(String programCode, String expectedFacultyCode) {
        AdProgram program = studyplanService.findProgramByCode(programCode);

        String message1 = "program code must be " + programCode;
        Assert.isTrue(programCode.equalsIgnoreCase(program.getCode()), message1);

        String actualFacultyCode = program.getFaculty().getCode();
        String message2 = "program facultyCode must be " + expectedFacultyCode;
        Assert.isTrue(expectedFacultyCode.equals(actualFacultyCode), message2);

        return self();
    }
}
