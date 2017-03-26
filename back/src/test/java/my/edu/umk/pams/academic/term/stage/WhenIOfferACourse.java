 package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author asyikin.mr and ziana
 */
@JGivenStage
public class WhenIOfferACourse extends Stage<WhenIOfferACourse> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIOfferACourse.class);

    @Autowired
    private TermService termService;

    @Autowired
    private PlannerService plannerService;

    @ExpectedScenarioState
    private AdAcademicSession academicSession;

    @ExpectedScenarioState
    private AdProgram program;

    public WhenIOfferACourse I_offer_all_courses_under_program_faculty() {
        // find faculty of the program
        AdFaculty faculty = program.getFaculty();

        // find ALL courses under this faculty
        // to be offered by this program
        List<AdCourse> courses = plannerService.findCourses(faculty);
        for (AdCourse course : courses) {
            String code = program.getCode() + "/" + course.getCode();
            String canonicalCode = program.getCode() + "/" + course.getCode() + "/" + academicSession.getCode();
            LOG.debug("course: {}", course.getCode());
            AdOffering offering = new AdOfferingImpl();
            offering.setCode(code);
            offering.setCanonicalCode(canonicalCode);
            offering.setTitle(course.getTitle());
            offering.setCapacity(50);
            offering.setCourse(course);
            offering.setProgram(program);
            // todo(uda): setSession ???
            termService.saveOffering(offering);
        }
        return self();
    }
}
