package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCourseImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@JGivenStage
public class WhenIWantUpdateCourse extends Stage<WhenIWantUpdateCourse> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantUpdateCourse.class);

    @Autowired
    private PlannerService plannerService;

    @ProvidedScenarioState
    private AdCourse course;

    @ProvidedScenarioState
    private AdFaculty faculty;

    @ExpectedScenarioState
    private AdStudent students;
    
    @ExpectedScenarioState
    private String FACULTY_CODE;

    public WhenIWantUpdateCourse I_update_course_to_faculty_code_$a(String FACULTY_CODE) {

        faculty = plannerService.findFacultyByCode(FACULTY_CODE);

        AdCourse courses = new AdCourseImpl();

        courses.setCode("DDA1155");
        courses.setFaculty(faculty);
        courses.setClassification(AdAcademicClassification.LEVEL_000);
        courses.setTitle("LUKISAN SAM");
        courses.setTitleEn("ENGINEERING SAM");
        courses.setTitleMs("LUKISAN SAM");

        plannerService.addCourse(faculty, courses);
        
  
        return self();
    }

}
