package my.edu.umk.pams.academic.studyplan.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;


@JGivenStage
public class ThenIKnowProgramDetails {

	@Autowired
	private StudyplanService studyplanService;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ExpectedScenarioState
	private AdProgram program;
	
	public ThenIKnowProgramDetails I_know_program_details() {
		
	//	List<AdFaculty> faculties= studyplanService.findProgramByCode(code);
		//Assert.notEmpty(faculties);
		
		return null;
		

	}



}
