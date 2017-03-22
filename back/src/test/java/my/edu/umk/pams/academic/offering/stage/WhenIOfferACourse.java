package my.edu.umk.pams.academic.offering.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.model.AdOfferingImpl;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;
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
	private OfferingService offeringService;

	@Autowired
	private StudyplanService studyplanService;

	@ExpectedScenarioState
	private AdAcademicSession academicSession;

	@ProvidedScenarioState
	private String code;

	@ProvidedScenarioState
	private String title;

	@ProvidedScenarioState
	private List<AdSection> sections;

	@ProvidedScenarioState
	private AdOffering offering;

	@ExpectedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private AdFaculty faculty;
	
	@ProvidedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	private String canonicalCode;

	public WhenIOfferACourse I_offer_a_course() {
		program = studyplanService.findProgramByCode("FIAT/PHD/0001");
		course = studyplanService.findCourseByCode("GST5021");
	    code = course.getCode() + "/" + academicSession.getCode();
		canonicalCode = faculty.getCode() + "/" + course.getCode() + "/" + academicSession.getCode(); 
		
		offering = new AdOfferingImpl();
		
		offering.setCode(code);
		offering.setCanonicalCode(canonicalCode);
		offering.setTitle("MBA-ECONOMICS & BUSINESS ENVIRONMENT"); 
		offering.setCapacity(50);
		offering.setSectionCount(3);
		offering.setCourse(course);
		offering.setProgram(program);
		offeringService.saveOffering(offering);
		
		return self();
	}
}
