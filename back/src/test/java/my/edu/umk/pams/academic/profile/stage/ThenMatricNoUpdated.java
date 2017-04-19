package my.edu.umk.pams.academic.profile.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenMatricNoUpdated extends Stage<ThenMatricNoUpdated> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenMatricNoUpdated.class);
	public ThenMatricNoUpdated new_matricNo_generated() {
		
		
		return self();
		
		
	}

}
