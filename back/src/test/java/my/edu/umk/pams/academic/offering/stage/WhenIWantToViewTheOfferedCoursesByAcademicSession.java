package my.edu.umk.pams.academic.offering.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.offering.model.AdEnrollment;
import my.edu.umk.pams.academic.offering.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.offering.service.OfferingService;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.studyplan.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdSection;

@JGivenStage
public class WhenIWantToViewTheOfferedCoursesByAcademicSession
		extends Stage<WhenIWantToViewTheOfferedCoursesByAcademicSession> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToViewTheOfferedCoursesByAcademicSession.class);

	@ProvidedScenarioState
	private AdOffering offering;

	@Autowired
	private OfferingService offeringService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ProvidedScenarioState
	private AdMetadata metadata;
	
	@ProvidedScenarioState
	private AdEnrollmentStatus status;
	
	@ProvidedScenarioState
	private AdEnrollmentStanding level;
	
	@ProvidedScenarioState
	private AdGradeCode gradeCode;


	public WhenIWantToViewTheOfferedCoursesByAcademicSession I_want_to_view_the_offered_courses_by_academic_session() {
        offering = offeringService.findOfferingByProgramAndCourse(program, course);
			
		enrollment = new AdEnrollmentImpl();
		enrollment.setSection(section);
		enrollment.setStudent(student);
		enrollment.setAdmission(admission);
		enrollment.setStanding(level);
		enrollment.setMetadata(metadata);
		enrollment.setStatus(status);
		enrollment.setGradeCode(gradeCode);
	
		offeringService.saveOffering(offering);
		return self();

	}

}
