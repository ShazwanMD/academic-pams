package my.edu.umk.pams.academic.profile.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdProgramImpl;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

@JGivenStage
public class WhenIWantToUpdateProgramInfo extends Stage<WhenIWantToUpdateProgramInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToUpdateProgramInfo.class);

	 @Autowired
	    private ProfileService profileService;

	    @Autowired
	    private CommonService commonService;
	    
	    @Autowired
	    private StudyplanService studyplanService;

	    @ExpectedScenarioState
	    private AdProgram program;
	    
	    @ExpectedScenarioState
	    private List<AdFaculty> faculty;
	    
	    
	    @ExpectedScenarioState
	    private String code;
	    
	    public WhenIWantToUpdateProgramInfo I_update_program_info(){
	    
	    	AdProgram program = new AdProgramImpl();
	    	program.setFaculty(studyplanService.findFacultyByCode(code));
	    	program.setCode(code);
	    	program.setTitle("1");
	    	program.setTitleEn("2");
	    	program.setTitleMs("3");
	    	
	    	studyplanService.updateProgram(program);
	    	
	    	return self();
	    }
	
}
