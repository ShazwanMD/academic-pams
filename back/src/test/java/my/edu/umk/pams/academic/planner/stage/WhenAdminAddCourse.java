package my.edu.umk.pams.academic.planner.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.planner.model.AdAcademicClassification;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdCourseImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zaida_nawi
 **/
@JGivenStage
public class WhenAdminAddCourse extends Stage<WhenAdminAddCourse> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenAdminAddCourse.class);

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    public WhenAdminAddCourse Admin_add_a_course_to_faculty_code_$(String code) {
        faculty = plannerService.findFacultyByCode(code);
        AdCourse course = new AdCourseImpl();
        course.setCode("PRGM-1234");
        course.setFaculty(faculty);
        course.setClassification(AdAcademicClassification.LEVEL_000);
        course.setTitle("Master of Enterpreneurship");
        course.setTitleEn("Master of Enterpreneurship");
        course.setTitleMs("Master of Enterpreneurship");
        course.setCredit(3);
        plannerService.addCourse(faculty, course);
        return self();
        
    }

}
