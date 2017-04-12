package my.edu.umk.pams.academic.term.stage;
/**
 * @author zaida_nawi
 **/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdSection;

@JGivenStage
public class ThenKnowTheEnrollmentIntervalPeriod extends Stage<ThenKnowTheEnrollmentIntervalPeriod> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenKnowTheEnrollmentIntervalPeriod.class);

	@Autowired
	private SystemService systemService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ExpectedScenarioState
	private AdSection section;

	public ThenKnowTheEnrollmentIntervalPeriod Know_the_enrollment_interval_period() {
		
		Assert.notNull(section, "section should be not null");
		
		
		
		
		return self();

	}

}
