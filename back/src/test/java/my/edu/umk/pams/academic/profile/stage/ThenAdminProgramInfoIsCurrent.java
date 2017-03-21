package my.edu.umk.pams.academic.profile.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class ThenAdminProgramInfoIsCurrent extends Stage<ThenAdminProgramInfoIsCurrent> {

	
	   @Autowired
	    private StudyplanService studyplanService;
	    @ExpectedScenarioState
	    AdFaculty faculty;
	    public ThenAdminProgramInfoIsCurrent the_program_is_current_for_$(String facultyCode) {
	 
	    	boolean exists = studyplanService.isProgramExists("PRGM-101", faculty);
	    	Assert.isTrue(exists, "cool");
	         
	        return self();
	    }
}
