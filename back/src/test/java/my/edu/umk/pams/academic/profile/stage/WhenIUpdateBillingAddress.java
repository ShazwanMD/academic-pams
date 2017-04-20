package my.edu.umk.pams.academic.profile.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdAddressType;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIUpdateBillingAddress extends Stage<WhenIUpdateBillingAddress> {

    private static final Logger LOG = LoggerFactory.getLogger(WhenIUpdateBillingAddress.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private CommonService commonService;

    @ProvidedScenarioState
    private AdStudent student;

    @ProvidedScenarioState
    private List<AdAddress> addresses;
    
	@ExpectedScenarioState
	private static String matricNo;

	public WhenIUpdateBillingAddress I_update_billing_address() {
		
    	student = profileService.findStudentByMatricNo(matricNo);
    	addresses = student.getAddresses();
        for (AdAddress address : addresses) {
            if (address.getType().equals(AdAddressType.BILLING)) {
                address.setAddress1("Lot 431,");
                address.setAddress2("Lorong Teratai");
                address.setAddress3("Kota Bharu");
                address.setPostCode("15150");
                address.setStateCode(commonService.findStateCodeByCode("MY-03"));
                address.setCountryCode(commonService.findCountryCodeByCode("MY"));
                
                
                profileService.updateAddress(student, address);

            }
        }

        return self();
    }
    
    public WhenIUpdateBillingAddress I_review_address(){
    	student = profileService.findStudentByMatricNo(matricNo);
    	addresses = student.getAddresses();
    	for(AdAddress address : addresses)
    	LOG.debug("Find Address by Student Matric No :{}", address.getAddress1()+","+
    													   address.getAddress2()+","+
    													   address.getAddress3()+","+
    													   address.getPostCode()+","+
    													   address.getStateCode().getDescription()+","+
    													   address.getCountryCode().getDescription());

    	
    	return self();
    }

}
