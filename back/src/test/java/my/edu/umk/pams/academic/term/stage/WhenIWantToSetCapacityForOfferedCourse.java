package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author asyikin.mr@umk and ziana
 */

@JGivenStage
public class WhenIWantToSetCapacityForOfferedCourse extends Stage<WhenIWantToSetCapacityForOfferedCourse> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetCapacityForOfferedCourse.class);

    public static final String COURSE_CODE = "DDA2113";

    @Autowired
    private TermService termService;

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @ProvidedScenarioState
    private AdOffering offering;

    @ProvidedScenarioState
    private AdCourse course;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private String code;

    @ProvidedScenarioState
    private String canonicalCode;

    public WhenIWantToSetCapacityForOfferedCourse I_create_and_set_offering_capacity() {
        // offer a course
        course = plannerService.findCourseByCode(COURSE_CODE);

        // set term properties
        code = course.getCode() + "/" + academicSession.getCode();  // course/session
        canonicalCode = faculty.getCode() + "/" + course.getCode() + "/" + academicSession.getCode(); // fac/course/session
        offering = new AdOfferingImpl();
        offering.setCode(code);
        offering.setCanonicalCode(canonicalCode);
        offering.setCapacity(10);
        offering.setTitle("Kursus Asasi");
        offering.setCourse(course);

        // save term
        termService.saveOffering(offering);
        return self();
    }
}
