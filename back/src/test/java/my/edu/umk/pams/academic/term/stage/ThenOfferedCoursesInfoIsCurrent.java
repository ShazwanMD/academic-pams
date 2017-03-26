package my.edu.umk.pams.academic.term.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;

import my.edu.umk.pams.academic.studyplan.model.AdProgram;


@JGivenStage
public class ThenOfferedCoursesInfoIsCurrent extends Stage<ThenOfferedCoursesInfoIsCurrent> {
	
	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private List<AdOffering> offering;
	
	@ExpectedScenarioState
	private AdProgram program;
	
public ThenOfferedCoursesInfoIsCurrent the_offered_courses_info_is_current() {
		
			
		List<AdOffering> offering = termService.findOfferings(program);
		
		Assert.notNull(offering, "Not Null");
		 
		return self();
	}
}