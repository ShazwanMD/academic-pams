package my.edu.umk.pams.academic.planner.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.model.AdProgramType;
import my.edu.umk.pams.academic.planner.service.PlannerService;


@JGivenStage
public class WhenAdminUpdateProgram extends Stage<WhenAdminUpdateProgram> {
	
	
	  private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateCourses.class);


	    @Autowired
	    private PlannerService plannerService;

	    @Autowired
	    private CommonService commonService;

	    @ProvidedScenarioState
	    private AdFaculty faculty;
	    
	    @ExpectedScenarioState
	    private AdProgram program;
	    
	    @ExpectedScenarioState
	    private AdProgramLevel programLevel;
	   
	    public WhenAdminUpdateProgram Admin_update_program_for_faculty_$(String facultyCode) {
	 	
	    	  
	         program.setCode("A01/MASTER/00111");
	         program.setFaculty(plannerService.findFacultyByCode(facultyCode));
	         program.setTitle("Master of management(it)");
	         program.setTitleEn("Master of management(it)");
	         program.setTitleMs("Master of management(it)");
	         
	         plannerService.updateProgram(program);
	    	
	    	return self();

	
	}

}
