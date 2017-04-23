package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.academic.identity.model.AdActorType;
import my.edu.umk.pams.academic.identity.model.AdContact;
import my.edu.umk.pams.academic.identity.model.AdContactImpl;
import my.edu.umk.pams.academic.identity.model.AdContactType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;


@JGivenStage
public class WhenIUpdateContactNumber extends Stage<WhenIUpdateContactNumber> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateContactNumber.class);

    @Autowired
    private IdentityService identityService;
    @Autowired
    private ProfileService profileService;

    

    @ProvidedScenarioState
    private AdStudent student;
    
  
    
    @ProvidedScenarioState
    private AdContact contact;

    @ExpectedScenarioState
    private static String matricNo;


	public WhenIUpdateContactNumber I_add_my_contact_number() {
	      
		student = profileService.findStudentByMatricNo(matricNo);
		Assert.notNull(student, "Student Must Exists");
		LOG.debug("Student Name :{}", student.getName());
		
		contact = new AdContactImpl();
		contact.setIdentityNo("920718035555");
		contact.setName("Mohd Din");
		contact.setStudent(student);
		contact.setType(AdContactType.FATHER);
		contact.setSomething("09-7477133");
		
		student = new AdStudentImpl();
		student.setActorType(AdActorType.STUDENT);
		student.setPhone("09-7477133");
        student.setMobile("0179282817");
        student.setFax("09-7477133");
        
       profileService.addContact(student, contact);

       student = profileService.findStudentByMatricNo(matricNo);
       Assert.notNull(student, "Student Must Not Null");
       LOG.debug("Student Name :{}", student.getName());
       
       List<AdContact> contacts = student.getContacts();
       for(AdContact contact1 : contacts)
       LOG.debug("Student Contact :{}", contact1.getIdentityNo()+","+
							    		contact1.getStudent().getName()+","+
							    		contact1.getName()+","+
							    		contact1.getType().name()+","+
							    		contact1.getSomething());
 

							        
   
        return self();

	}

    public WhenIUpdateContactNumber I_update_contact_number() {
       
        
        return self();
    }
}