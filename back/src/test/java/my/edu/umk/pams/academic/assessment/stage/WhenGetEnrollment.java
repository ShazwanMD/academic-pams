package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenGetEnrollment extends Stage<WhenGetEnrollment> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenGetEnrollment.class);

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

	@ProvidedScenarioState
	private AdAssessment assessment;

	@ProvidedScenarioState
	private AdAcademicSession session;

	@ProvidedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdStudent student;
	
	@ProvidedScenarioState
	private AdEnrollment enrollment;

	@ExpectedScenarioState
	private AdSection section;
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	@ProvidedScenarioState
	private AdStudyCenter studyCenter;
	
	@ProvidedScenarioState
	private AdCohort cohort;
	
	@ExpectedScenarioState
	private AdGradeCode grade;


	public WhenGetEnrollment get_enrollment(){
		
		student = profileService.findStudentByMatricNo("A17P003");
		
		session = plannerService.findCurrentAcademicSession();
		
		cohort = student.getCohort();
		
		studyCenter = commonService.findStudyCenterByCode("A");
		
		admission = new AdAdmissionImpl();
		
		admission.setGpa(BigDecimal.TEN);
		admission.setCgpa(BigDecimal.TEN);
		admission.setCreditTaken(3);
		admission.setCreditEarned(3);
		admission.setStudent(student);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		admission.setStanding(AdAcademicStanding.KG);
		admission.setStudyCenter(studyCenter);
		admission.setSession(session);
		admission.setCohort(cohort);
		termService.saveAdmission(admission);
		LOG.debug("Admission Student Name :{}", admission.getStudent().getName());
		LOG.debug("Admission study center :{}", admission.getStudyCenter().getDescription());
		LOG.debug("Admission academic session :{}", admission.getSession().getCode());
		LOG.debug("Admission cohort :{}", admission.getCohort().getCode());
		LOG.debug("GPA :{}", admission.getGpa());
		LOG.debug("CGPA :{}", admission.getCgpa());
		
		enrollment = new AdEnrollmentImpl();
		enrollment.setAdmission(admission);
		enrollment.setStudent(student);
		enrollment.setSection(section);
		enrollment.setGradeCode(grade);
		enrollment.setStatus(AdEnrollmentStatus.CONFIRMED);
		LOG.debug("Enrollment Status :{}", enrollment.getAdmission().getStanding().getDescription());
		LOG.debug("Enroll Student Name :{}", enrollment.getStudent().getName());	
		LOG.debug("Grade Code :{}", enrollment.getGradeCode().getCode());
		termService.saveEnrollment(enrollment);
		
		
		
		return self();
	}
}
