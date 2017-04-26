package my.edu.umk.pams.academic.assessment.stage;

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
public class ThenExamVivaUpdated extends Stage<ThenExamVivaUpdated> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIAmUpdateExamVivaInfo.class);
	
	@Autowired
	private TermService termService;
	
	@ExpectedScenarioState
	private AdAcademicSession academicSession;
	
	@ExpectedScenarioState
	private AdOffering offering;
	
	@ExpectedScenarioState
	private AdAssessment assessment;

	public ThenExamVivaUpdated exam_info_updated() {
		
		boolean assessments = termService.hasAssessment(academicSession, offering);
		Assert.isTrue(assessments, "assessment should not be null");
		
		LOG.debug ("Assessment: {}", assessment.getCanonicalCode());
		LOG.debug ("Assessment: {}", assessment.getCategory());
		LOG.debug ("Session: {}", assessment.getSession());
		
		return self();
		
	}

	@Pending
	public ThenExamVivaUpdated viva_info_updated() {
		
		
		return self();
		
	}

}
