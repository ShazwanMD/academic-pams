package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
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
    private OfferingService offeringService;

    @Autowired
    private StudyplanService studyplanService;

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

    public WhenIWantToSetCapacityForOfferedCourse I_set_offering_capacity() {
        // offer a course
        course = studyplanService.findCourseByCode(COURSE_CODE);

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
        offeringService.saveOffering(offering);
        return self();
    }
}
