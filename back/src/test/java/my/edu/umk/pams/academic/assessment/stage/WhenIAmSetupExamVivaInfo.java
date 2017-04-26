package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdAssessmentCategory;
import my.edu.umk.pams.academic.term.model.AdAssessmentImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdSectionImpl;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenIAmSetupExamVivaInfo extends Stage<WhenIAmSetupExamVivaInfo> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmSetupExamVivaInfo.class);
	
	@Autowired
	private CommonService commonService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@Autowired
	private TermService termService;
	
	@ProvidedScenarioState
	private AdCourse course;
	
	@ProvidedScenarioState
	private AdProgram program;
	
	@ExpectedScenarioState
	private static String staffNo;

	@ProvidedScenarioState
	private AdStaff staff;
	
	@ProvidedScenarioState
	private AdSection section;
	
	@ProvidedScenarioState
	private AdAssessment assessment;
	
	@ProvidedScenarioState
	private AdAcademicSession academicSession;
	
	@ProvidedScenarioState
	private AdOffering offering; 
	
	public WhenIAmSetupExamVivaInfo i_setup_assessment_info() {
	
		staff = identityService.findStaffByStaffNo(staffNo);
		LOG.debug("Staff name :{}", staff.getName());
		LOG.debug("Staff Type :{}", staff.getStaffType().name());
		
		offering = new AdOfferingImpl();
		offering.setCanonicalCode("FIAT/MASTER/PBH/GST5090");
		offering.setCapacity(50);
		offering.setCode("GST5090");
		offering.setTitle("Business Management");
		offering.setCourse(course);
		offering.setProgram(program);
		offering.getSections();
		termService.saveOffering(offering);
		
		section = new AdSectionImpl();
		section.setCanonicalCode("FIAT/MASTER/PBH/GST5090/201720181");
		section.setCapacity(15);
		section.setCode("GST5090");
		section.setOrdinal(1);
		section.setOffering(offering);
		section.setSession(academicSession);
		termService.saveSection(section);
		
		assessment = new AdAssessmentImpl();
		assessment.setCanonicalCode("MASTER/MBA/GST503/201720181/Q1");
		assessment.setCategory(AdAssessmentCategory.COURSE_WORK);
		assessment.setCode("MASTER/MBA/GST503/Q1");
		assessment.setDescription("Economics & Environment");
		assessment.setOrdinal(0);
		assessment.setTotalScore(new BigDecimal(BigInteger.valueOf(100)));
		assessment.setWeight(new BigDecimal (BigInteger.valueOf(10)));
		assessment.setOffering(offering);
		assessment.setSession(academicSession);
		termService.addAssessment(academicSession, offering, assessment);
				
		Assert.notNull(assessment, "quiz1 is null");
		
		return self();

	}

}
