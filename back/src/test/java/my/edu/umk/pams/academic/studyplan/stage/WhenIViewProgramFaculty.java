package my.edu.umk.pams.academic.studyplan.stage;

import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;

public class WhenIViewProgramFaculty extends Stage<WhenIViewProgramFaculty> {

	@Autowired
	private ProfileService profileService;
	
	@ExpectedScenarioState
	AdFaculty faculty;
	
	
	public WhenIViewProgramFaculty I_view_program_faculty() {
		
		//AdFaculty faculty = new AdFacultyImpl();
		//faculty.setProgramCode ("A123") ;
		
		return self();
				
	}

}
