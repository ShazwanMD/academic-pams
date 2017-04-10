package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.model.AdProgramType;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class ThenProgramLevelIntroduced extends Stage<ThenProgramLevelIntroduced> {

	  private static final Logger LOG = LoggerFactory.getLogger(ThenProgramInfomationReviewed.class);
		
    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdProgram program;
    
    @ExpectedScenarioState
    private AdProgramLevel programLevel;
    
    @ExpectedScenarioState
    private String PROGRAM_CODE;
    
    @ExpectedScenarioState
    private String FACULTY_CODE;


    public ThenProgramLevelIntroduced program_level_$_introduced(String PROGRAM_CODE) {

    	List< AdProgramLevel> programLevel = plannerService.findProgramLevels();
		Assert.notEmpty(programLevel, "programLevel should not be empty");
		
    	
    	for ( AdProgramLevel progLevel : programLevel) {
            LOG.debug("program level code : {}",progLevel.getCode());
            Assert.notNull(progLevel.getCode(), "programLevel code should not be empty");
        }
    	
    	for ( AdProgramLevel progLevel : programLevel) {
            LOG.debug("program level Description: {}",progLevel.getDescription());
            Assert.notNull(progLevel.getDescription(), "programLevel description should not be empty");
        }
    	
    	for ( AdProgramLevel progLevel : programLevel) {
            LOG.debug("program level Type : {}", progLevel.getType().MASTER);
            Assert.notNull(progLevel.getType().MASTER, "programLevel type should not be empty");
        }


        return self();
    }
}
