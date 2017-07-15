package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
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

/**
 * @author asyikin.mr@umk and ziana
 */

@JGivenStage
public class WhenIWantToSetCapacityForOfferedCourse extends Stage<WhenIWantToSetCapacityForOfferedCourse> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToSetCapacityForOfferedCourse.class);

    public static final String COURSE_CODE = "GST5013";
    public static final String PROGRAM_CODE = "MBA-MASTER";

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
    
    @ProvidedScenarioState
    private AdProgram program;

    @ExpectedScenarioState
    private AdFaculty faculty;

    @ProvidedScenarioState
    private String code;

    @ProvidedScenarioState
    private String canonicalCode;
    
  
    public WhenIWantToSetCapacityForOfferedCourse I_create_and_set_offering_capacity() throws Exception {
        
    	
    	
    	// offer a course
    	course = plannerService.findCourseByCodeAndFaculty(COURSE_CODE, faculty);
    	Assert.notNull(course, "course data should be not null");
        LOG.debug("Listed Courses ID: {}", course.getId());
        LOG.debug("Listed Courses ID: {}", course.getTitleMs());
        LOG.debug("Listed Courses ID: {}", course.getTitleEn());
        LOG.debug("Listed Courses ID: {}", course.getFaculty().getName());

        // set term properties
        code = course.getCode() + "/" + academicSession.getCode();  // course/session
        canonicalCode = PROGRAM_CODE + "/" + course.getCode(); // fac/course/session
        offering = new AdOfferingImpl();
        offering.setCode(code);
        offering.setCanonicalCode(canonicalCode);
        offering.setCapacity(20);
        offering.setTitleMs("Economics & Business Environment");
        offering.setTitleEn("Economics & Business Environment");
        offering.setCourse(course);

        // save term
        termService.saveOffering(offering);
        
        Assert.notNull(offering, "offering data should be not null");
        LOG.debug("==============new offering data====================");
		LOG.debug("section ID: {}", offering.getId());
		LOG.debug("section Course: {}", offering.getCourse().getCode());
		LOG.debug("section Title: {}", offering.getTitleMs());
		LOG.debug("section Capacity: {}", offering.getCapacity());
		
        return self();
    }
}
