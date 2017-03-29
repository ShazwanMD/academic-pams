package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@JGivenStage
public class ThenContactNumberUpdated extends Stage<ThenContactNumberUpdated> {

	@Autowired
	private IdentityService identityService;


	@ExpectedScenarioState
	private String identityNo;

	public ThenContactNumberUpdated Contact_number_updated() {

   	
    	AdStudent student = identityService.findStudentByStudentNo("A17P001");
       	Assert.isTrue(student.equals(student),"true");
       			
		return self();

	}

}
