package my.edu.umk.pams.academic.studyplan.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdFacultyImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;


@JGivenStage
public class WhenIViewProgramFaculty extends Stage<WhenIViewProgramFaculty> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewProgramFaculty.class);
	
	@Autowired
	private StudyplanService studyplanService;
	
	@ExpectedScenarioState
	private AdFaculty faculty;

	@ExpectedScenarioState
	private List<AdProgram> program;

	
	public WhenIViewProgramFaculty(){
		AdFaculty faculty = new AdFacultyImpl();
	}
	
	public WhenIViewProgramFaculty I_want_to_view_program_for_$_faculty(String code) {
		
		faculty = studyplanService.findFacultyByCode(code);
		
		program = studyplanService.findPrograms(faculty);
		
		for (AdProgram program : program) {
			LOG.debug(program.getTitle());
		}
		return self();
				
	}

}
