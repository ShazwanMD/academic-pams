package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;

public class WhenWantToViewOpenDateOfEnrollment extends Stage<WhenWantToViewOpenDateOfEnrollment>{

	
	  private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewTheOfferedCoursesByAcademicSession.class);

	    @Autowired
	    private TermService termService;
	    
	    @Autowired
	    private PlannerService plannerService;

	    @ExpectedScenarioState
	    private AdProgram program;

	    @ExpectedScenarioState
	    private AdStudent student;

	    @ExpectedScenarioState
	    private AdOffering offering;

	    @ProvidedScenarioState
	    private List<AdOffering> offerings;

	    public WhenWantToViewOpenDateOfEnrollment Want_to_view_open_date_of_enrollment() {
	
	
	    	
        return self();
}
}
