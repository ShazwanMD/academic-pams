package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIViewStudentCourseInfo extends Stage<WhenIViewStudentCourseInfo> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIViewStudentCourseInfo.class);

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdStudent student;

    @ExpectedScenarioState
    private List<AdCourse> course;

    @ExpectedScenarioState
    private AdFaculty faculty;
   

    public WhenIViewStudentCourseInfo CPS_view_course_info_for_faculty_$(String facultyCode) {
        faculty = plannerService.findFacultyByCode(facultyCode);
        course = plannerService.findCourses(faculty);
        
        LOG.debug("Course For Faculty FKP: CPS");
        for (AdCourse course : course) {
        	LOG.debug("Course:{}",course.getCode());
        }
        return self();
  
    }
    

    public WhenIViewStudentCourseInfo MGSEB_view_course_info_for_faculty_$(String facultyCode2) {
        faculty = plannerService.findFacultyByCode(facultyCode2);
        course = plannerService.findCourses(faculty);
        
        LOG.debug("Course For Faculty MGSEB: MGSEB");
        for (AdCourse course : course) {
             LOG.debug("Course :{}",course.getCode());
        }
        return self();
  
    }
}
