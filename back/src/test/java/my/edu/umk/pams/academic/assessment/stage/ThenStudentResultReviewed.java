package my.edu.umk.pams.academic.assessment.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.service.CommonService;

@JGivenStage
public class ThenStudentResultReviewed extends Stage<ThenStudentResultReviewed > {

	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentResultReviewed.class);
	
	@Autowired
	private CommonService commonService;
	
	@ExpectedScenarioState
	private AdGradeCode grade;
	
	@ExpectedScenarioState
	private int mark;
	
	@Pending
	public ThenStudentResultReviewed result_student_reviewed() {

		return self();
	}

}
