package my.edu.umk.pams.academic.term.stage;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenIViewTheCurrentEnrollmentCourses extends Stage<ThenIViewTheCurrentEnrollmentCourses> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenIViewTheCurrentEnrollmentCourses.class);

	@Autowired
	private TermService termService;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdEnrollmentApplication application;

	@ExpectedScenarioState
	private AdEnrollmentApplicationItem item;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ExpectedScenarioState
	private List<AdEnrollmentApplication> applications;
	
	public ThenIViewTheCurrentEnrollmentCourses I_view_the_current_enrollment_courses() {

		Integer countAdmissionApp= termService.countAdmissionApplication("des", academicSession, student);
		LOG.debug("countAdmissionApplication:{}",countAdmissionApp);
		
		if (countAdmissionApp == 0) {
			LOG.debug("Please do admission application process first.");

			return self();
		} else {
			LOG.debug("Can view new enrollment data");
			
			applications = termService.findEnrollmentApplications("des", academicSession, student, 0, 100);
			// Assert.notEmpty(applications, "applications are empty");

			for (AdEnrollmentApplication application : applications) {
				LOG.debug("Application Id:{}", application.getId());

				LOG.debug("New application id:{}", application.getDescription());
				LOG.debug("New application audit:{}", application.getAuditNo());
				LOG.debug("New application :{}", application.getCancelComment());
				LOG.debug("New application :{}", application.getType());
				LOG.debug("New item action :{}", item.getAction());
			}
							
		}
		
		return self();

	}

}