package my.edu.umk.pams.academic.term.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@JGivenStage
public class WhenIUpdateAdmissionStatus extends Stage<WhenIUpdateAdmissionStatus> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateAdmissionStatus.class);

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdSection section;

	@ExpectedScenarioState
	private AdStudent student;

	@ExpectedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdStudyCenter studyCenter;
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	@ExpectedScenarioState
    private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private	AdAdmissionApplication application;

	@ProvidedScenarioState
	private String matricNo = "A17P001";
	
	public WhenIUpdateAdmissionStatus I_update_admission_status_for_program_$(String code) {

		student = identityService.findStudentByMatricNo(matricNo);
		program = plannerService.findProgramByCode(code);
		cohort = plannerService.findCohortByCode("FIAT/PHD/PBT/CHRT/201720181");

		LOG.debug("student: {}", student.getMatricNo());
		LOG.debug("program: {}", program.getCode());
		LOG.debug("academicSession: {}", academicSession.getId());
		LOG.debug("cohort: {}", cohort.getCode());
		
		//transfer new admission application to admission for updating status 
		application = termService.findAdmissionApplicationByProgramAndStudent(program, student);
		Assert.notNull(application, "application data is not null");
		
		LOG.debug("application ID:{}", application.getId());
		LOG.debug("application studyCenter:{}", application.getStudyCenter().getId());
		
		studyCenter =  application.getStudyCenter();
		
				
		//if countAdmission=1, cannot proceed process to insert new and update
		Integer countAdmissionApplication = termService.countAdmissionApplication("des", academicSession, student);
		LOG.debug("countAdmissionApplication:{}", countAdmissionApplication);
		if (countAdmissionApplication != 0){
			LOG.debug("Data Exist!! @AdmissionApplication. Admission cannot be INSERTED AND UPDATED.");
			return self();
		}else{
			LOG.debug("Data Not Exist!! @AdmissionApplication. Continue with the next process.");
		}
		
		admission = new AdAdmissionImpl();
		admission.setCgpa(new BigDecimal("1.90"));
		admission.setCreditEarned(100);
		admission.setCreditTaken(100);
		admission.setGpa(new BigDecimal("1.90"));
		admission.setCohort(cohort);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KS);
		admission.setStatus(AdAdmissionStatus.POSTPONED);
		admission.setStudent(student);
		admission.setStudyCenter(studyCenter);
		
		termService.saveAdmission(admission);
		
		//new data added in ad_admn from ad_admn_apln
		Assert.notNull(admission, "Item data should be not null");
		
		LOG.debug("New admission id inserted:{}", admission.getId());
		LOG.debug("New admission Cohort inserted:{}", admission.getCohort().getId());
		LOG.debug("New admission Session inserted:{}", admission.getSession().getId());
		LOG.debug("New admission Gpa inserted:{}", admission.getGpa());
		LOG.debug("New admission Cgpa inserted:{}", admission.getCgpa());
		LOG.debug("New admission Standing inserted:{}", admission.getStanding());
		LOG.debug("New admission Status inserted:{}", admission.getStatus());
		LOG.debug("New admission StudyCenter inserted:{}", admission.getStudyCenter().getId());
				
		//find data admission to update status
		cohort = admission.getCohort();
		academicSession = admission.getSession();
		student = admission.getStudent();
		
		admission = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, cohort, student);
		Assert.notNull(admission, "The admission data must not be null");
		LOG.debug("current admission id: {}", admission.getId());
		LOG.debug("current admission status: {}", admission.getStatus().getDescription());
		
		
		
		admission.setCgpa(new BigDecimal("3.80"));
		admission.setCreditEarned(110);
		admission.setCreditTaken(110);
		admission.setGpa(new BigDecimal("3.80"));
		admission.setCohort(cohort);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KB);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		
		termService.updateAdmission(admission);
		Assert.notNull(admission, "New admission data must not be null");

		return self();

	}
}
