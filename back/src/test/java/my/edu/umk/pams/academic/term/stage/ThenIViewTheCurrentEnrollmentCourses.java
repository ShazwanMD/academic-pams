package my.edu.umk.pams.academic.term.stage;
//@author:asyikin
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenIViewTheCurrentEnrollmentCourses extends Stage<ThenIViewTheCurrentEnrollmentCourses> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenIViewTheCurrentEnrollmentCourses.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdEnrollmentApplication application;

	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;
	
	@Pending
	public ThenIViewTheCurrentEnrollmentCourses I_view_the_current_enrollment_courses() {
		//No data in table enrollment application
		//application = termService.findEnrollmentApplicationByReferenceNo(application.getReferenceNo());
		//LOG.debug("application:{}", application.getDescription());
		
		return self();

	}

}
