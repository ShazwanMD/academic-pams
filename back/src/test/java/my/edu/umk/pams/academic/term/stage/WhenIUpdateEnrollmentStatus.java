package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
/**
 * @author asyikin.mr and ziana
 */
import com.tngtech.jgiven.annotation.Pending;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIUpdateEnrollmentStatus extends Stage<WhenIUpdateEnrollmentStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateEnrollmentStatus.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdAcademicSession session;

	@ProvidedScenarioState
	private AdGradeCode gradeCode;

	@ProvidedScenarioState
	private AdAdmission admission;

	@ProvidedScenarioState
	private AdEnrollmentApplication application;
	
	

	public WhenIUpdateEnrollmentStatus I_update_enrollment_status_for_program_$(String code) {

		List<AdEnrollmentApplication> applications = termService.findEnrollmentApplications(session);
		
			
		for (AdEnrollmentApplication application : applications) {

			LOG.debug("Listed application ID: {}", application.getId());

			List<AdEnrollmentApplicationItem> items = termService.findEnrollmentApplicationItems(application);

			for (AdEnrollmentApplicationItem item : items) {

				LOG.debug("Item id: {}", item.getId());

				enrollment = new AdEnrollmentImpl();
				enrollment.setStanding(AdEnrollmentStanding.HW);
				enrollment.setStudent(application.getStudent());
				enrollment.setSection(item.getSection());
				enrollment.setStatus(AdEnrollmentStatus.NEW);
				enrollment.setGradeCode(gradeCode);
				enrollment.setAdmission(admission);

				termService.saveEnrollment(enrollment);

				LOG.debug("New enrollment inserted id: {}", enrollment.getId());
				Assert.notNull(enrollment, "Enrollment data should be not null");

			}

		}

		student = identityService.findStudentByMatricNo("A17P001");
		section = termService.findSectionByCanonicalCode("FIAT/MASTER/PBH/GST5023/201720181");

		enrollment = termService.findEnrollmentBySectionAndStudent(section, student);
		Assert.notNull(enrollment, "Enrollment data should be not null");

		LOG.debug("Student:{}", student.getIdentityNo());
		LOG.debug("Section:{}", section.getCanonicalCode());
		LOG.debug("Enrollment status:{}", enrollment.getStatus());

		enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
		termService.updateEnrollment(enrollment);

		LOG.debug("New updated enrollment status:{}", enrollment.getStatus());

		return self();
	}
}
