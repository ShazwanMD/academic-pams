package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdGradebookImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenCreateGradeBook extends Stage<WhenCreateGradeBook> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenCreateGradeBook.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	private PlannerService plannerService;

	@ExpectedScenarioState
	private AdAssessment assessment;

	@ExpectedScenarioState
	private AdAcademicSession session;

	@ExpectedScenarioState
	private AdStaff staff;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdAdmission admission;

	@ExpectedScenarioState
	private AdStudyCenter studyCenter;

	@ExpectedScenarioState
	private AdCohort cohort;

	@ExpectedScenarioState
	private AdGradeCode grade;

	@ExpectedScenarioState
	private AdGradebook gradebook;

	@ExpectedScenarioState
	private AdOffering offering;

	public WhenCreateGradeBook create_gradeBook() {
		
		List<AdEnrollment> enrollments = termService.findEnrollments(offering);
		for (AdEnrollment enrollment : enrollments) {
			List<AdAssessment> assessments = termService.findAssessments(offering);
			for (AdAssessment assessment : assessments) {
				List<AdGradebook> gradebooks = termService.findGradebooks(assessment);
				for (AdGradebook gradebook : gradebooks) {
					gradebook.setAssessment(assessment);
					gradebook.setEnrollment(enrollment);
					gradebook.setSection(enrollment.getSection());
					gradebook.setScore(new BigDecimal(BigInteger.valueOf(50)));
					
					termService.saveGradebook(gradebook);
					termService.normalizeGradebooks(enrollment);
				}

				
	
			}
			termService.calculateGrade(offering);
			LOG.debug("enrollmentTotalScore:{}",enrollment.getTotalScore());
		}

		return self();
	}
}
