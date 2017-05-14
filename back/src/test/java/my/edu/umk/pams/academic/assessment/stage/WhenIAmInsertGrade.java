package my.edu.umk.pams.academic.assessment.stage;

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
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;

@JGivenStage
public class WhenIAmInsertGrade extends Stage<WhenIAmInsertGrade> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmInsertGrade.class);
	
	@Autowired
	private IdentityService identityService;
	
	@ProvidedScenarioState
	private AdStudent student;

	@Autowired
	private CommonService commonService;

	@ProvidedScenarioState
	private AdGradeCode grade;
	
	@ProvidedScenarioState
	private AdStudentStatus studentStatus;

	@ExpectedScenarioState
	private String matricNo;

	@ExpectedScenarioState
	private int mark;

	public WhenIAmInsertGrade i_insert_grades() {

		
		
		// student
		student = identityService.findStudentByMatricNo(matricNo);
		LOG.debug("Student Name :{}", student.getName());
		Assert.notNull(student, "Student must not NULL");
		
		// student status
		studentStatus = student.getStudentStatus();
		LOG.debug("Student Status :{}", studentStatus.name());

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

			} else if (mark > 100) {

				LOG.debug("Mark :{}", mark);
				LOG.debug("Cannot More than 100% marks");

			} else if (mark < 0) {

				LOG.debug("Mark :{}", mark);
				LOG.debug("Cannot Less than 0% marks");
			}

		} else {
			LOG.debug("Not student");
		}

		return self();

	}

}
