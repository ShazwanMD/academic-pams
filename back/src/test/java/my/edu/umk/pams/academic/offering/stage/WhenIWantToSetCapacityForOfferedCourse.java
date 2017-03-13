package my.edu.umk.pams.academic.offering.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.model.AdOfferingImpl;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

/**
 * @author asyikin.mr@umk and ziana
 */

@JGivenStage
public class WhenIWantToSetCapacityForOfferedCourse extends Stage<WhenIWantToSetCapacityForOfferedCourse> {

	@Autowired
	private OfferingService offeringService;

	@Autowired
	private StudyplanService studyplanService;

	@ProvidedScenarioState
	private AdCourse course;

	@ExpectedScenarioState
	AdAcademicSession academicSession;

	public WhenIWantToSetCapacityForOfferedCourse I_set_offering_capacity() {

		// offer a course
		AdCourse course = studyplanService.findCourseByCode("DDA1163");

		// set offering capacities
		AdOffering offering = new AdOfferingImpl();
        offering.setCapacity(10);
        offering.setCode("XX");
        offering.setCanonicalCode("ss");
        offering.setTitle("vv");
        offering.setCourse(course);
                
		// save offering
        offeringService.saveOffering(offering);
		return self();
	}
}
