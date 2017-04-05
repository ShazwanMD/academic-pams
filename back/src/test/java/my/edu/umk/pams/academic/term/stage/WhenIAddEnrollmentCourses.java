package my.edu.umk.pams.academic.term.stage;
//@author:asyikin
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationAction;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationImpl;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationType;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIAddEnrollmentCourses extends Stage<WhenIAddEnrollmentCourses> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAddEnrollmentCourses.class);

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private TermService termService;

	@ProvidedScenarioState
	private AdAcademicSession session;
	
	@ExpectedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdSection section;
	
	@ProvidedScenarioState
	private AdActor actor;
	
	@ProvidedScenarioState
	private AdEnrollmentApplication application;
	
	@ProvidedScenarioState
	private AdEnrollmentApplicationItem item;

	@Pending
	public WhenIAddEnrollmentCourses I_add_enrollment_courses() {
		
		section = termService.findSectionByCanonicalCode("FKP/PHD/0001/DDA2113/201720181");
		AdStaff advisor = identityService.findStaffByStaffNo("01001A");
		
		actor = identityService.findActorByIdentityNo("01001A");
		
		LOG.debug("Student No: {}", student.getIdentityNo());
		LOG.debug("Session Code: {}", session.getDescription());
		LOG.debug("Advisor Code: {}", actor.getName());
		
		//have to setup admission service
		//AdAdmission admission = identityService.f
	/*	
		application = new AdEnrollmentApplicationImpl();
		application.setReferenceNo(identityNo);
		application.setDescription("New enrollment");
		application.setType(AdEnrollmentApplicationType.PRA);
		application.setRemoveComment("Remove Comment");
		application.setCancelComment("Cancel Comment");
		application.setStudent(student);
		//application.setAdmission(admission);
		application.setAdvisor(advisor);
		application.setSession(session);
		
		item.setAction(AdEnrollmentApplicationAction.ADD);
		item.setApplication(application);
		item.setSection(section);
		
		termService.addEnrollmentApplicationItem(application, item);
		
*/
		return self();
	}

}
