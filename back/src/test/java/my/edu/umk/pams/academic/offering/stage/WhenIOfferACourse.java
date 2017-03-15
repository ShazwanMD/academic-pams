package my.edu.umk.pams.academic.offering.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.model.AdOfferingImpl;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdSection;
import my.edu.umk.pams.academic.studyplan.service.StudyplanService;

/**
 * @author asyikin.mr@umk and ziana
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
	private AdMetadata metadata;

	@ProvidedScenarioState
	private AdProgram program;
	
	@ProvidedScenarioState
	private AdFaculty faculty;
	
	@ProvidedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	private String canonicalCode;

	public WhenIOfferACourse I_offer_a_course() {
		
		program = studyplanService.findProgramByCode("MEM");
		course = studyplanService.findCourseByCode("DDA2113");
		AdFaculty faculty = course.getFaculty();
	    code = course.getCode() + "/" + academicSession.getCode();
		canonicalCode = faculty.getCode() + "/" + course.getCode() + "/" + academicSession.getCode(); 
		
		offering = new AdOfferingImpl();
		
		offering.setCode(code);
		offering.setCanonicalCode(canonicalCode);
		offering.setTitle("my sample title "); // @ProvidedScenarioState title above is null
		offering.setMetadata(metadata);
		offering.setCapacity(50);
		offering.setSectionCount(3);
		offering.setCourse(course);
		offering.setProgram(program);
		offering.setSections(sections);

		offeringService.saveOffering(offering);
		
		return self();
	}
}
