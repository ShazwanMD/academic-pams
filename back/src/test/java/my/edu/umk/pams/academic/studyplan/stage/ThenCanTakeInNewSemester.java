package my.edu.umk.pams.academic.studyplan.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class ThenCanTakeInNewSemester  extends Stage<ThenCanTakeInNewSemester>{

	private static final Logger LOG = LoggerFactory.getLogger(ThenProgramIsIntroduced.class);

    @Autowired
    private StudyplanService studyplanService;

    @ExpectedScenarioState
    AdFaculty faculty;
    
	public ThenCanTakeInNewSemester Can_take_in_new_semester(String programCode, String expectedFacultyCode) {
		
		AdProgram program = studyplanService.findProgramByCode(programCode);
        String message1 = "program code must be " + programCode;
        Assert.isTrue(programCode.equalsIgnoreCase(program.getCode()), message1);
        String actualFacultyCode = program.getFaculty().getCode();
        String message2 = "program facultyCode must be " + expectedFacultyCode;
        Assert.isTrue( expectedFacultyCode.equals(actualFacultyCode), message2);
		
		return self();
		
		
		
		
		
	}

}
