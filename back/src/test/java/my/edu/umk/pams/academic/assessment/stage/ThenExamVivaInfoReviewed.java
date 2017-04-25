package my.edu.umk.pams.academic.assessment.stage;

import java.util.List;

import org.springframework.util.Assert;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.common.model.AdVenueCode;import my.edu.umk.pams.academic.term.service.TermService;;

@JGivenStage
public class ThenExamVivaInfoReviewed extends Stage<ThenExamVivaInfoReviewed> {

	@ExpectedScenarioState
	private TermService termService;
	
	@ExpectedScenarioState
	private AdVenueCode venue;
	
	@Pending
	public ThenExamVivaInfoReviewed exam_info_reviewed() {
		
//
//		List<AdVenueCode> venues  = termService.findExamVenues(venue);        //Assert.notEmpty(venues, "venue for exam is not empty");
////         
		return self();

		
	}

	
	@Pending
	public ThenExamVivaInfoReviewed viva_info_reviewed() {
	
		
		return self();
	}

}
