package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdVenueCode;import my.edu.umk.pams.academic.term.service.TermService;

@JGivenStage
public class ThenExamVivaInfoReviewed extends Stage<ThenExamVivaInfoReviewed> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenExamVivaInfoReviewed.class);

	
	@ExpectedScenarioState
	private TermService termService;
	
	@ExpectedScenarioState
	private AdVenueCode venue;
	
	public ThenExamVivaInfoReviewed exam_info_reviewed() {
		
		Assert.notNull(venue, "Exam venue cannot be null");
		LOG.debug("Venue Code:{}",venue.getCode());
		LOG.debug("Venue Code:{}",venue.getDescription());
		
        return self();

	}

	
	@Pending
	public ThenExamVivaInfoReviewed viva_info_reviewed() {
	
		
		return self();
	}

}
