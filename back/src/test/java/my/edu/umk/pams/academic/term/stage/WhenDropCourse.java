package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenDropCourse extends Stage<WhenDropCourse> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenDropCourse.class);

	@Autowired
    private IdentityService identityService;
	
	@Autowired
	private TermService termService;
	
	@ProvidedScenarioState
	private AdEnrollment enrollment;
	
	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdSection section;
	
	public WhenDropCourse I_want_to_drop_enrollment_course() {
		
		
		String identityNo = "A17P002";
		student = (AdStudent) identityService.findActorByIdentityNo(identityNo);
		section = termService.findSectionByCanonicalCode("FKP/PHD/0001/DDA2113/201720181");
		enrollment = new AdEnrollmentImpl();
		enrollment.setStudent(student);
		enrollment.setSection(section);
		termService.deleteEnrollment(enrollment);
		
		return self();	
	}

}
