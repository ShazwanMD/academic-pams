package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.term.model.AdAdmission;

@JGivenStage
public class ThenTheNewAdmissionIsAdded extends Stage<ThenTheNewAdmissionIsAdded> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheNewAdmissionIsAdded.class);
	
	@ProvidedScenarioState
	private AdAdmission admission;
	
	public ThenTheNewAdmissionIsAdded the_new_admission_is_added() {
	
		
		//view new admission data from AD_ADMN
		LOG.debug("Admission for repeated course is {} ", admission.getCgpa());
		LOG.debug("Admission for repeated course is {} ", admission.getCgpa());
		LOG.debug("Admission for repeated course is {} ", admission.getStanding());
		LOG.debug("Admission for repeated course is {} ", admission.getStatus());
		LOG.debug("Admission for repeated course is {} ", admission.getSession());
		
		Assert.notNull(admission, "Admission data should be inserted");
		
		return self();

	}

}