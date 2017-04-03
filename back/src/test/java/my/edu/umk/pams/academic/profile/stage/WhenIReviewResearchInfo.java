package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenIReviewResearchInfo extends Stage<WhenIReviewResearchInfo>	{
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIReviewResearchInfo.class);
	
	@Autowired
	private PlannerService plannerService;
	
	@Autowired
	private IdentityService identityService;
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdCourse course;
	

	public WhenIReviewResearchInfo I_review_research_info_for_$(String courseCode){
		student = identityService.findStudentByStudentNo("A17P001");
		student.getStudentStatus();
		LOG.debug("Student's Name : {}", student.getName());
		LOG.debug("Student's Status :{}", student.getStudentStatus());
		
		course = plannerService.findCourseByCode(courseCode);
		LOG.debug("Research Title : {}", course.getTitle());
		LOG.debug("Research Title English : {}", course.getTitleEn());
		LOG.debug("Research Title B.Malaysia : {}", course.getTitleMs());
		
		return self();
	}

}
