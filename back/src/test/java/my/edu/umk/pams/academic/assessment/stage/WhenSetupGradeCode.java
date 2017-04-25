package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenSetupGradeCode extends Stage<WhenSetupGradeCode> {
	private static final Logger LOG = LoggerFactory.getLogger(WhenSetupGradeCode.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private PlannerService plannerService;

	@ProvidedScenarioState
	private AdAssessment assessment;

	@ProvidedScenarioState
	private AdOffering offering;

	@ProvidedScenarioState
	private AdAcademicSession session;

	@ProvidedScenarioState
	private AdActor actor;

	@ProvidedScenarioState
	private AdProgram program;

	@ProvidedScenarioState
	private AdStaff staff;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdProgramLevel level;

	@ExpectedScenarioState
	private AdUser user;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdSection section;

	@ProvidedScenarioState
	private AdGradeCode grade;

	@ExpectedScenarioState
	private static String staffNo;
	
	@ExpectedScenarioState
	private AdGradebook gradeBook;

	public WhenSetupGradeCode setup_gradeCode() {

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("A+");
		grade.setDescription("Cemerlang");
		grade.setOrdinal(0);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("A");
		grade.setDescription("Cemerlang");
		grade.setOrdinal(1);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("A-");
		grade.setDescription("KEPUJIAN");
		grade.setOrdinal(2);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("B+");
		grade.setDescription("KEPUJIAN");
		grade.setOrdinal(3);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("B");
		grade.setDescription("KEPUJIAN");
		grade.setOrdinal(4);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("B-");
		grade.setDescription("BAIK");
		grade.setOrdinal(5);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("C");
		grade.setDescription("LULUS");
		grade.setOrdinal(6);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("C-");
		grade.setDescription("LULUS BERSYARAT");
		grade.setOrdinal(7);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("D");
		grade.setDescription("LULUS BERSYARAT");
		grade.setOrdinal(8);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("C+");
		grade.setDescription("LULUS");
		grade.setOrdinal(9);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		// setup gradeCode
		grade = new AdGradeCodeImpl();
		grade.setCode("F");
		grade.setDescription("GAGAL");
		grade.setOrdinal(10);
		commonService.saveGradeCode(grade);

		LOG.debug("Grade:{}", grade.getCode());
		LOG.debug("Desc:{}", grade.getDescription());

		return self();
	}

}
