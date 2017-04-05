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
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCourseImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateStudentResearchTitle extends Stage<WhenAdminUpdateStudentResearchTitle> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateStudentResearchTitle.class);
	
	@Autowired
	private PlannerService plannerService;
	
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ExpectedScenarioState
	private AdCourse course;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	public WhenAdminUpdateStudentResearchTitle Admin_update_student_research_title() {
		
		AdFaculty faculty = plannerService.findFacultyByCode("CPS");
		AdCourse course = plannerService.findCourseByCode("MAP");
		
		course.setFaculty(faculty);
		course.setCode("MAP1");
		course.setCredit(5);
		course.setClassification(AdAcademicClassification.LEVEL_DOCTORATE);
		course.setTitle("SAM");
		course.setTitleEn("SAM");
		course.setTitleMs("SAMS");
		
		plannerService.updateCourse(faculty, course);
		
		LOG.debug("Course Detail :{}", course.getCode());
		LOG.debug("Course Detail :{}", course.getTitle());
		LOG.debug("Course Detail :{}", course.getTitleEn());
		LOG.debug("Course Detail :{}", course.getTitleMs());
		LOG.debug("Course Detail :{}", course.getCredit());
		LOG.debug("Course Detail :{}", course.getClassification());
		
		return self();
		
	}

	public WhenAdminUpdateStudentResearchTitle Admin_update_student_research_titles() {
		
		AdFaculty faculty = plannerService.findFacultyByCode("A10");
		AdCourse course = plannerService.findCourseByCode("DBA/YEAR3/SEMESTER6/Module 14");
		
		course.setFaculty(faculty);
		course.setCode("DBA/YEAR3/SEMESTER6/Module 145");
		course.setCredit(5);
		course.setClassification(AdAcademicClassification.LEVEL_DOCTORATE);
		course.setTitle("SAM RESEARCH");
		course.setTitleEn("SAM RESEARCH");
		course.setTitleMs("KAJIAN SAM");
		
		plannerService.updateCourse(faculty, course);
		
		LOG.debug("Course Detail :{}", course.getCode());
		LOG.debug("Course Detail :{}", course.getTitle());
		LOG.debug("Course Detail :{}", course.getTitleEn());
		LOG.debug("Course Detail :{}", course.getTitleMs());
		LOG.debug("Course Detail :{}", course.getCredit());
		LOG.debug("Course Detail :{}", course.getClassification());
		
		return self();
		
	}
}
