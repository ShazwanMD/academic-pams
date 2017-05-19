package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class thenExamVivaInfoCurrent extends Stage<thenExamVivaInfoCurrent> {

	private static final Logger LOG = LoggerFactory.getLogger(thenExamVivaInfoCurrent.class);
	
	@Autowired
	private TermService termService;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ExpectedScenarioState
	private AdOffering offering;
	
	@ExpectedScenarioState
	private AdAssessment assessment;
	
	public thenExamVivaInfoCurrent exam_info_current() {

		boolean assessments = termService.hasAssessment(offering);
		Assert.isTrue(assessments, "assessment should not be null");
		
		LOG.debug ("Assessment: {}", assessment.getCanonicalCode());
		LOG.debug ("Assessment: {}", assessment.getCategory());

		return self();
	}

	@Pending
	public thenExamVivaInfoCurrent viva_info_current() {
		
		return self();
		
	}

}
