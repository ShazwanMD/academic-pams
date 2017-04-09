package my.edu.umk.pams.academic.term.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenTheNewAdmissionIsAdded extends Stage<ThenTheNewAdmissionIsAdded> {
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheNewAdmissionIsAdded.class);
	
	public ThenTheNewAdmissionIsAdded the_new_admission_is_added() {
	
		//view new admission data from AD_ADMN
		
		return self();

	}

}

