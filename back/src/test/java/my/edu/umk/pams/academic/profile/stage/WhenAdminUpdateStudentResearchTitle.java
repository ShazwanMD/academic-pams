package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCourseImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;

@JGivenStage
public class WhenAdminUpdateStudentResearchTitle extends Stage<WhenAdminUpdateStudentResearchTitle> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenAdminUpdateStudentResearchTitle.class);
	
	@Autowired
	private PlannerService plannerService;
	
	
	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	private AdFaculty faculty;
	

	@ProvidedScenarioState
	private AdProgramLevel level;
	
	public WhenAdminUpdateStudentResearchTitle Admin_update_student_research_title() {
		
		AdFaculty faculty = plannerService.findFacultyByCode("CPS");
		Assert.notNull(faculty, "Faculty Must Not NULL");
		course = plannerService.findCourseByCodeAndFaculty("MAP", faculty);
		Assert.notNull(course, "Course Must Not NULL");
		
				
		course.setFaculty(faculty);
		course.setCode("FKP/MASTER/MAP1.1");
		course.setClassification(AdAcademicClassification.LEVEL_MASTER);
		course.setCredit(45);
		course.setTitleEn("Master of Entrepreneurship Mathematical Science");
		course.setTitleMs("Master of Entrepreneurship Mathematical Science");
		
		plannerService.updateCourse(faculty, course);
		
		LOG.debug("course Detail :{}", course.getCode());
		LOG.debug("course Detail :{}", course.getFaculty());
		LOG.debug("course Detail :{}", course.getClassification());
		LOG.debug("course Detail :{}", course.getCredit());
		LOG.debug("course Detail :{}", course.getTitleEn());
		LOG.debug("course Detail :{}", course.getTitleMs());
		LOG.debug("");
	
		
		return self();
		
	}

	public WhenAdminUpdateStudentResearchTitle Admin_update_student_research_titles() {
		
	     faculty = plannerService.findFacultyByCode("A10");
	     Assert.notNull(faculty, "Faculty Must Not NULL");
		 course = plannerService.findCourseByCode("Module14");
		 Assert.notNull(course, "Course Must Not NULL");
		
		course.setFaculty(faculty);
		course.setCode("DBA/YEAR3/SEMESTER6/Module 14");
		course.setCredit(5);
		course.setClassification(AdAcademicClassification.LEVEL_DOCTORATE);
		course.setTitleEn("Dissertation ( Part 3.1)");
		course.setTitleMs("Dissertation ( Part 3.1)");
		
		plannerService.updateCourse(faculty, course);
		
		LOG.debug("Course Detail :{}", course.getCode());
		LOG.debug("Course Detail :{}", course.getTitleEn());
		LOG.debug("Course Detail :{}", course.getTitleMs());
		LOG.debug("Course Detail :{}", course.getCredit());
		LOG.debug("Course Detail :{}", course.getClassification());
		LOG.debug("");
		
		return self();
		
	}
}
