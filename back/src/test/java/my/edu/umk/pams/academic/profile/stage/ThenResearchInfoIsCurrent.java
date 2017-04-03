package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class ThenResearchInfoIsCurrent extends Stage<ThenResearchInfoIsCurrent> {
	
private static final Logger LOG = LoggerFactory.getLogger(ThenResearchInfoIsCurrent.class);
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private IdentityService identityService;
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdCourse course;
	
	public ThenResearchInfoIsCurrent Research_info_for_$_is_current(String courseCode){
		boolean exists = plannerService.findCourseByCode(courseCode) != null;
	        Assert.isTrue(exists, "research exists");
		
		return self();
	}

}
