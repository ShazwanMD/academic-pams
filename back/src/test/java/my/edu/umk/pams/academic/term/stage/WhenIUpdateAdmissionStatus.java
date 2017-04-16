package my.edu.umk.pams.academic.term.stage;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdAdmissionImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

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

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStudyCenter studyCenter;
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	@ExpectedScenarioState
    private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private	AdAdmissionApplication application;

	public WhenIUpdateAdmissionStatus I_update_admission_status_for_program_$(String code) {

		student = identityService.findStudentByMatricNo("A17P001");
		program = plannerService.findProgramByCode("A01/MASTER/0001");
		
		LOG.debug("student: {}", student.getId());
		LOG.debug("program: {}", program.getId());
		LOG.debug("academicSession: {}", academicSession.getId());
		
		//transfer new admission application to admission for updating status 
		application = termService.findAdmissionApplicationByProgramAndStudent(program, student);
		Assert.notNull(application, "application data is not null");
		
		LOG.debug("application ID:{}", application.getId());
		LOG.debug("application studyCenter:{}", application.getStudyCenter().getId());
		
		studyCenter =  application.getStudyCenter();
		
		//admission = termService.findAdmissionBySessionProgramAndStudent(academicSession, program, student);
		//Assert.isNull(application, "data admission is null and can begin to tranfer");
		
		admission = new AdAdmissionImpl();
		admission.setCgpa(new BigDecimal("1.90"));
		admission.setCreditEarned(100);
		admission.setCreditTaken(100);
		admission.setGpa(new BigDecimal("1.90"));
		admission.setProgram(program);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KS);
		admission.setStatus(AdAdmissionStatus.POSTPONED);
		admission.setStudent(student);
		admission.setStudyCenter(studyCenter);
		
		termService.saveAdmission(admission);
		
		//new data added in ad_admn from ad_admn_apln
		Assert.notNull(admission, "Item data should be not null");
		
		LOG.debug("New admission id inserted:{}", admission.getId());
		LOG.debug("New admission Program inserted:{}", admission.getProgram().getId());
		LOG.debug("New admission Session inserted:{}", admission.getSession().getId());
		LOG.debug("New admission Gpa inserted:{}", admission.getGpa());
		LOG.debug("New admission Cgpa inserted:{}", admission.getCgpa());
		LOG.debug("New admission Standing inserted:{}", admission.getStanding());
		LOG.debug("New admission Status inserted:{}", admission.getStatus());
		LOG.debug("New admission StudyCenter inserted:{}", admission.getStudyCenter().getId());
				
		//find data admission to update status		
		admission = termService.findAdmissionBySessionProgramAndStudent(academicSession, program, student);
		Assert.notNull(admission, "The admission data must not be null");
		LOG.debug("current admission id: {}", admission.getId());
		LOG.debug("current admission status: {}", admission.getStatus().getDescription());
		
		
		admission.setCgpa(new BigDecimal("3.80"));
		admission.setCreditEarned(110);
		admission.setCreditTaken(110);
		admission.setGpa(new BigDecimal("3.80"));
		admission.setProgram(program);
		admission.setSession(academicSession);
		admission.setStanding(AdAcademicStanding.KB);
		admission.setStatus(AdAdmissionStatus.ADMITTED);
		
		termService.updateAdmission(admission);
		Assert.notNull(admission, "New admission data must not be null");

		return self();

	}
}
