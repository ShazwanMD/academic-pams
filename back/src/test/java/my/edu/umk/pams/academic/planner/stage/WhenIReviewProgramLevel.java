package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import groovy.util.logging.Log;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramImpl;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class WhenIReviewProgramLevel extends Stage<WhenIReviewProgramLevel> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewProgramLevel.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;
    
    @ExpectedScenarioState
    private AdProgramLevel programLevel;
   
    private String Code;

    public WhenIReviewProgramLevel I_review_program_level_$(String Code) {
        //faculty = plannerService.findFacultyByCode(Code);
        
         programLevel = plannerService.findProgramLevelByCode(Code);
       
     //   for (AdProgramLevel programLevels : programLevel) {
        	 LOG.debug(programLevel.getCode());
        

       /* AdProgram program = new AdProgramImpl();
        program.setCode("code");
        program.setFaculty(faculty);
        program.setProgramLevel(programLevel);
        program.setTitle("Master Business Administration ");
        program.setTitleEn("Master of Enterpreneurship (Management)");
        program.setTitleMs("Master of Enterpreneurship(Finance)");
        plannerService.saveProgram(program);*/

        return self();
    }

}
