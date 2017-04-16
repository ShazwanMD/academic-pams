package my.edu.umk.pams.academic.term.stage;

/**
 * @author zaida_nawi
 **/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;


@JGivenStage
public class ThenTheDateEnrollmentIsReview extends Stage<ThenTheDateEnrollmentIsReview> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheDateEnrollmentIsReview.class);

	@Autowired
	private TermService termService;
	
	@Autowired
	private PlannerService plannerService;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdSection section;
	
	@ExpectedScenarioState
	private AdConfiguration configuration;

	public ThenTheDateEnrollmentIsReview Know_the_enrollment_interval_period() {
		
		
		AdOffering offering = termService.findOfferingByCanonicalCode("A01/PHD/0001/DDA2113");
	    termService.countEnrollment(academicSession, offering);
	    LOG.debug("number of available course :{}", termService.countEnrollment(academicSession, offering));
		
	   // plannerService.countAvailableCourse(academicSession);
	   // LOG.debug("number of available course {} :", plannerService.countAvailableCourse(academicSession) );
	    //contoh count jum. course dlm academic session
	    
	    
	    
	    
//	    Integer countCourse(String filter);
//	    Integer countCourse(AdFaculty faculty);
//	    Integer countCourse(String filter, AdFaculty faculty);
//	    Integer countCourse(boolean authorized, String filter);
//	    Integer countAvailableCourse(AdAcademicSession academicSession);
		
	//	Assert.notNull(configuration, "section should be not null");
		
		
		return self();

	}

}
