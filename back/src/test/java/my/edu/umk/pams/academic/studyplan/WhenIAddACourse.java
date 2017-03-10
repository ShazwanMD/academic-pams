package my.edu.umk.pams.academic.studyplan;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicClassification;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdCourseImpl;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIAddACourse extends Stage<WhenIAddACourse> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIAddACourse.class);

    @Autowired
    private StudyplanService studyplanService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdFaculty faculty;

    public WhenIAddACourse I_add_a_course_to_faculty_code_$a(String code) {
        faculty = studyplanService.findFacultyByCode(code);
        AdCourse course = new AdCourseImpl();
        course.setCode("PRGM-1234");
        course.setFaculty(faculty);
        course.setClassification(AdAcademicClassification.LEVEL_000);
        course.setTitle("Master of Enterpreneurship");
        course.setTitleEn("Master of Enterpreneurship");
        course.setTitleMs("Master of Enterpreneurship");
        studyplanService.addCourse(faculty, course);
        return self();
    }

}
