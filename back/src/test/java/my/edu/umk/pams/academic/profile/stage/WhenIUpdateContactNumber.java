package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@JGivenStage
public class WhenIUpdateContactNumber extends Stage<WhenIUpdateContactNumber> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateContactNumber.class);

    @Autowired
    private IdentityService identityService;


    @ExpectedScenarioState
    private AdStudent student;


	public WhenIUpdateContactNumber I_add_my_contact_number() {
	      
		AdStudent student = identityService.findStudentByMatricNo("A17P001");
        student.setMobile("0148040444");
        student.setPhone("097777177");
        
        identityService.saveStudent(student);
        
        return self();

	}

    public WhenIUpdateContactNumber I_update_contact_number() {
       
    	AdStudent student = identityService.findStudentByMatricNo("A17P001");
        student.setMobile("0148040400");
        student.setPhone("097777111");
        
        identityService.updateStudent(student);
        
        LOG.debug("Student's mobile: {}", student.getMobile());
		LOG.debug("Student's phone: {}", student.getPhone());

        
        return self();
    }
}