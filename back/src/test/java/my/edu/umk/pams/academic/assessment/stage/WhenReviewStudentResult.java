package my.edu.umk.pams.academic.assessment.stage;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdAssessmentCategory;
import my.edu.umk.pams.academic.term.model.AdAssessmentImpl;
import my.edu.umk.pams.academic.term.model.AdAssessmentType;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdOfferingImpl;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class WhenReviewStudentResult extends Stage<WhenReviewStudentResult> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentResult.class);

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

	@ExpectedScenarioState
	private AdUser user;

	@ProvidedScenarioState
	private AdFaculty faculty;

	@ProvidedScenarioState
	private AdCourse course;

	@ProvidedScenarioState
	private AdStudent student;

	@ProvidedScenarioState
	private AdCohort cohort;

	@ProvidedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private String matricNo;

	@ExpectedScenarioState
	private int mark;

	@ProvidedScenarioState
	private AdGradeCode grade;

	public WhenReviewStudentResult I_review_result() {
				
		// student
		student = identityService.findStudentByMatricNo(matricNo);
		LOG.debug("Student Name :{}", student.getName());
		Assert.notNull(student, "Student must not NULL");

		// student status
		studentStatus = student.getStudentStatus();
		LOG.debug("Student Status :{}", studentStatus.name());

		// cohort
		cohort = student.getCohort();
		
		// program
		program = cohort.getProgram();
		LOG.debug("Program :{}", program.getTitle());
		
		faculty = program.getFaculty();
		LOG.debug("faculty :{}", faculty.getName());
		
		List<AdCourse> courses = faculty.getCourses();
		LOG.debug("course(s) :{}", courses.get(0));

		// new offering
		offering = new AdOfferingImpl();
		offering.setCanonicalCode("A01/MASTER/1/DDA2113");
		offering.setCapacity(100);
		offering.setCode("DDA2113");
		offering.setTitle("Offering 1");
		offering.setProgram(program);
		termService.saveOffering(offering);
		Assert.notNull(offering, "offering is null");

		// setup assessment
		AdAssessment quiz1 = new AdAssessmentImpl();
		quiz1.setCanonicalCode("A01/MASTER/Q1/DDA2113");
		quiz1.setCategory(AdAssessmentCategory.COURSE_WORK);
		quiz1.setCode("MASTER/Q1");
		quiz1.setDescription("MECHANICS OF MATERIALS");
		quiz1.setOffering(offering);
		quiz1.setOrdinal(0);
		quiz1.setSession(session);
		quiz1.setTotalScore(BigDecimal.ZERO);
		quiz1.setType(AdAssessmentType.QUIZ);
		quiz1.setWeight(BigDecimal.ZERO);
		termService.addAssessment(session, offering, quiz1);
		Assert.notNull(quiz1, "quiz1 is null");

		// setup gradeCode
		AdGradeCode grade = new AdGradeCodeImpl();
		grade.setCode("A+");
		grade.setDescription("Cemerlang");
		grade.setOrdinal(0);
		commonService.saveGradeCode(grade);

		// setup gradeCode
		AdGradeCode grade1 = new AdGradeCodeImpl();
		grade1.setCode("A");
		grade1.setDescription("Cemerlang");
		grade1.setOrdinal(1);
		commonService.saveGradeCode(grade1);

		// setup gradeCode
		AdGradeCode grade2 = new AdGradeCodeImpl();
		grade2.setCode("A-");
		grade2.setDescription("KEPUJIAN");
		grade2.setOrdinal(2);
		commonService.saveGradeCode(grade2);

		// setup gradeCode
		AdGradeCode grade3 = new AdGradeCodeImpl();
		grade3.setCode("B+");
		grade3.setDescription("KEPUJIAN");
		grade3.setOrdinal(3);
		commonService.saveGradeCode(grade3);

		// setup gradeCode
		AdGradeCode grade4 = new AdGradeCodeImpl();
		grade4.setCode("B");
		grade4.setDescription("KEPUJIAN");
		grade4.setOrdinal(4);
		commonService.saveGradeCode(grade4);

		// setup gradeCode
		AdGradeCode grade5 = new AdGradeCodeImpl();
		grade5.setCode("B-");
		grade5.setDescription("BAIK");
		grade5.setOrdinal(5);
		commonService.saveGradeCode(grade5);

		// setup gradeCode
		AdGradeCode grade6 = new AdGradeCodeImpl();
		grade6.setCode("C");
		grade6.setDescription("LULUS");
		grade6.setOrdinal(6);
		commonService.saveGradeCode(grade6);

		// setup gradeCode
		AdGradeCode grade7 = new AdGradeCodeImpl();
		grade7.setCode("C-");
		grade7.setDescription("LULUS BERSYARAT");
		grade7.setOrdinal(7);
		commonService.saveGradeCode(grade7);

		// setup gradeCode
		AdGradeCode grade8 = new AdGradeCodeImpl();
		grade8.setCode("D");
		grade8.setDescription("LULUS BERSYARAT");
		grade8.setOrdinal(8);
		commonService.saveGradeCode(grade8);

		// setup gradeCode
		AdGradeCode grade9 = new AdGradeCodeImpl();
		grade9.setCode("C+");
		grade9.setDescription("LULUS");
		grade9.setOrdinal(9);
		commonService.saveGradeCode(grade9);

		// setup gradeCode
		AdGradeCode grade10 = new AdGradeCodeImpl();
		grade10.setCode("F");
		grade10.setDescription("GAGAL");
		grade10.setOrdinal(10);
		commonService.saveGradeCode(grade10);

		

		return self();
	}
	
	public WhenReviewStudentResult i_review_student_mark(){
	
	// check condition
			if (studentStatus == AdStudentStatus.ACTIVE) {

				if (mark > 90 && mark <= 100) {

					// logging

					grade = commonService.findGradeCodeByCode("A+");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 80 && mark <= 89) {

					grade = commonService.findGradeCodeByCode("A");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 75 && mark <= 79) {

					grade = commonService.findGradeCodeByCode("A-");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
				

				} else if (mark >= 70 && mark <= 74) {

					grade = commonService.findGradeCodeByCode("B+");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 65 && mark <= 69) {

					grade = commonService.findGradeCodeByCode("B");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 60 && mark <= 64) {

					grade = commonService.findGradeCodeByCode("B-");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 55 && mark <= 59) {

					grade = commonService.findGradeCodeByCode("C+");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 50 && mark <= 54) {

					grade = commonService.findGradeCodeByCode("C");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 45 && mark <= 49) {

					grade = commonService.findGradeCodeByCode("C-");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 40 && mark <= 44) {
					grade = commonService.findGradeCodeByCode("D");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
					

				} else if (mark >= 0 && mark <= 39) {

					grade = commonService.findGradeCodeByCode("F");
					LOG.debug("Mark :{}", mark);
					LOG.debug("Grade :{}", grade.getCode());
					LOG.debug("Ordinal :{}", grade.getOrdinal());
					LOG.debug("Grade Desc :{}", grade.getDescription());
									
				}else if (mark>100){
					
					LOG.debug("Mark :{}", mark);
					LOG.debug("Cannot More than 100% marks");
					
				}else if(mark<0){
					
					LOG.debug("Mark :{}", mark);
					LOG.debug("Cannot Less than 0% marks");
				}

			} else {
				LOG.debug("Not student");
			}

			
	return self();		
	}
}
