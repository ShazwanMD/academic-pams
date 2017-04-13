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
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdSection;


@JGivenStage
public class ThenTheDateEnrollmentIsReview extends Stage<ThenTheDateEnrollmentIsReview> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheDateEnrollmentIsReview.class);

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdSection section;
	
	@ExpectedScenarioState
	private AdConfiguration configuration;

	public ThenTheDateEnrollmentIsReview Know_the_enrollment_interval_period() {

		
		//TODO COUNT 
		Assert.notNull(configuration, "section should be not null");
		
		
		return self();

	}

}
