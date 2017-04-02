package my.edu.umk.pams.academic.planner.stage;

/**
 * @author zaida_ain
 */
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

    @ProvidedScenarioState
    private AdFaculty faculty;
  
    @ExpectedScenarioState
    private List<AdProgramLevel> programLevels;

    
    public WhenIReviewProgramLevel() {
    }

    public WhenIReviewProgramLevel I_review_program_level_$(String code) {
        
         programLevels = plannerService.findProgramLevels();
       
      for (AdProgramLevel programLevel : programLevels) {
        	 LOG.debug(programLevel.getCode());
      }
        return self();
    }}




