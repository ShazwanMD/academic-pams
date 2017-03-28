package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCourseImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS - Rodziah Mohamad Nor
 */
@JGivenStage
public class WhenIUpdateCourses extends Stage<WhenIUpdateCourses> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateCourses.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;
   
    @ExpectedScenarioState
    private AdCourse course;
    
    private String facultyCode;

 
    public WhenIUpdateCourses I_update_courses_to_faculty_code_$a(String facultyCode) {
    	
    	faculty = plannerService.findFacultyByCode(facultyCode);
        
    	
        course.setTitle("Sustainability & Environmental Economics");
        course.setTitleEn("Sustainability & Environmental Economics");
        course.setTitleMs("Sustainability & Environmental Economics");
        
        plannerService.updateCourse(faculty, course);
        return self();
    }
}