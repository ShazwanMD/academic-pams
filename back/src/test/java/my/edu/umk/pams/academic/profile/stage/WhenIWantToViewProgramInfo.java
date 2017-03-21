package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdFacultyImpl;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIWantToViewProgramInfo extends Stage<WhenIWantToViewProgramInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewProgramInfo.class);

	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ExpectedScenarioState
	private String code;

	@ExpectedScenarioState
	private AdFaculty faculty;

	public WhenIWantToViewProgramInfo() {
		AdProgram program = new AdProgramImpl();
	}

	public  WhenIWantToViewProgramInfo I_view_program_info_for_faculty_$(String code ) {
	
		faculty = studyplanService.findFacultyByCode(code);
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
