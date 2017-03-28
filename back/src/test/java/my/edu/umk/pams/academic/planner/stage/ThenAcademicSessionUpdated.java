package my.edu.umk.pams.academic.planner.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenAcademicSessionUpdated extends Stage<ThenAcademicSessionUpdated>{
	
	 @ExpectedScenarioState
	    private AdAcademicSession academicSession;

	    @Autowired
	    private PlannerService plannerService;
	    
	    private static final Logger LOG = LoggerFactory.getLogger(ThenAcademicSessionUpdated.class);


	public void the_academic_session_is_updated() {
		
		 LOG.debug("academicSession {} ", academicSession);
	        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
	        Assert.notNull(academicSession, "The data must not be null");
		
	}

}
