package my.edu.umk.pams.academic.assessment.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;

@JGivenStage
public class WhenReviewStudentResult extends Stage<WhenReviewStudentResult> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenReviewStudentResult.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private TermService termService;

	@Autowired
	private IdentityService identityService;

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
		LOG.debug("=================================");
		LOG.debug("STUDENT INFORMATION");
		LOG.debug("=================================");
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
		LOG.debug("Program :{}", program.getTitle().toUpperCase());
		
		faculty = program.getFaculty();
		LOG.debug("faculty :{}", faculty.getName());
		
		List<AdCourse> courses = faculty.getCourses();
		LOG.debug("course(s) :{}", courses.get(0));

		// new offering
		offering = new AdOfferingImpl();
		offering.setCanonicalCode("FIAT/MASTER/PBH/GST5055");
		offering.setCapacity(100);
		offering.setCode("GST5055");
		offering.setTitle("Offering 1");
		offering.setProgram(program);
		termService.saveOffering(offering);
		Assert.notNull(offering, "offering is null");

		// setup assessment
		AdAssessment quiz1 = new AdAssessmentImpl();
		quiz1.setCanonicalCode("FIAT/MASTER/PBH/Q1/GST5055");
		quiz1.setCategory(AdAssessmentCategory.COURSE_WORK);
		quiz1.setCode("MASTER/PBH/Q1");
		quiz1.setDescription("MECHANICS OF MATERIALS");
		quiz1.setOffering(offering);
		quiz1.setOrdinal(0);
		quiz1.setTotalScore(BigDecimal.ZERO);
		quiz1.setType(AdAssessmentType.QUIZ);
		quiz1.setWeight(BigDecimal.ZERO);
		termService.addAssessment(offering, quiz1);
		Assert.notNull(quiz1, "quiz1 is null");

		

		return self();
	}
	
	public WhenReviewStudentResult i_review_student_mark(){
	LOG.debug("=================================");
	LOG.debug("GRADE INFROMATION");
	LOG.debug("=================================");
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

			LOG.debug("=================================");
	return self();		
	}
}
