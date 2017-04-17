package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;

@JGivenStage
public class ThenTheDetailsOfferedCoursesInfoIsCurrent extends Stage<ThenTheDetailsOfferedCoursesInfoIsCurrent> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheDetailsOfferedCoursesInfoIsCurrent.class);
	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private List<AdOffering> offering;
	
	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private List<AdOffering> offerings;
	
    @ExpectedScenarioState
    private AdAcademicSession academicSession;
	
	public ThenTheDetailsOfferedCoursesInfoIsCurrent the_details_offered_courses_info_is_current() {
	
		
		Assert.notEmpty(offerings, "the offerings for this program is not empty");
		
		
		return self();
	}
}
