package my.edu.umk.pams.academic.web.module.profile.controller;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdAddressImpl;
import my.edu.umk.pams.academic.identity.model.AdContact;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentStatus;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.profile.vo.Address;
import my.edu.umk.pams.academic.web.module.profile.vo.AddressType;
import my.edu.umk.pams.academic.web.module.profile.vo.Contact;
import my.edu.umk.pams.academic.web.module.profile.vo.Guarantor;
import my.edu.umk.pams.academic.web.module.profile.vo.Guardian;
import my.edu.umk.pams.academic.web.module.term.controller.TermTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.Enrollment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author PAMS
 */
@Transactional
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PlannerService plannerService;

    @Autowired
    private TermService termService;

    @Autowired
    private TermTransformer termTransformer;

    @Autowired										
    private ProfileTransformer profileTransformer;
    
    //====================================================================================================
    // PROFILE EDITOR
    //====================================================================================================
	@RequestMapping(value = "/students/{matricNo}", method = RequestMethod.PUT)
	 public ResponseEntity<String> updateStudent(@PathVariable String matricNo, @RequestBody Student vo) {
		dummyLogin();

		AdStudent student = profileService.findStudentById(vo.getId());
		student.setName(vo.getName());
		student.setPhone(vo.getPhone());
		student.setEmail(vo.getEmail());
		student.setMobile(vo.getMobile());
		student.setFax(vo.getFax());
		profileService.updateStudent(student);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
		
	}
	
    @RequestMapping(value = "/students/{identityNo}/addresses", method = RequestMethod.PUT)
	 public ResponseEntity<String> updateAddress(@PathVariable String identityNo, @RequestBody Address vo){
    	dummyLogin();
    	AdStudent student = profileService.findStudentByMatricNo(identityNo);
    	List<AdAddress> addresses = profileService.findAddresses(student);
    	for(AdAddress address:addresses){
    		address.setAddress1(vo.getAddress1());
    		address.setAddress2(vo.getAddress2());
    		address.setAddress3(vo.getAddress3());
    		address.setPostCode(vo.getPostcode());
    		profileService.updateAddress(student, address);
    	}
    	return new ResponseEntity<String>("Success",HttpStatus.OK);
    	
    }
    
    @RequestMapping(value = "/students/{identityNo}/contacts", method = RequestMethod.PUT)
	 public ResponseEntity<String> updateContact(@PathVariable String identityNo, @RequestBody Contact vo){
    	dummyLogin();
    	AdStudent student = profileService.findStudentByMatricNo(identityNo);
    	List<AdContact> contacts =  profileService.findContacts(student);
    	for(AdContact contact:contacts){
    		contact.setName(vo.getName());
    		contact.setIdentityNo(vo.getIdentityNo());
    		profileService.updateContact(student, contact);
    	}
    	return new ResponseEntity<String>("Success",HttpStatus.OK);
    	
    }
    //====================================================================================================
    // PROFILE
    //====================================================================================================

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findStudents() {
        List<AdStudent> students = profileService.findStudents("%",0,Integer.MAX_VALUE);
        return new ResponseEntity<List<Student>>(profileTransformer
                .toStudentVos(students), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{matricNo}", method = RequestMethod.GET)
    public ResponseEntity<Student> findStudentByMatricNo(@PathVariable String matricNo) throws UnsupportedEncodingException {
        return new ResponseEntity<Student>(profileTransformer
                .toStudentVo(profileService.findStudentByMatricNo(matricNo)), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{identityNo}/guardians", method = RequestMethod.GET)
    public ResponseEntity<List<Guardian>> findGuardiansByStudent(@PathVariable String identityNo) {
        AdStudent student = profileService.findStudentByMatricNo(identityNo);
        return new ResponseEntity<List<Guardian>>(profileTransformer
                .toGuardianVos(profileService.findGuardians(student)), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{identityNo}/guarantors", method = RequestMethod.GET)
    public ResponseEntity<List<Guarantor>> findGuarantorsByStudent(@PathVariable String identityNo) {
        AdStudent student = profileService.findStudentByMatricNo(identityNo);
        return new ResponseEntity<List<Guarantor>>(profileTransformer
                .toGuarantorVos(profileService.findGuarantors(student)), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{identityNo}/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollmentsByStudent(@PathVariable String identityNo) {
        AdStudent student = profileService.findStudentByMatricNo(identityNo);
        // AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdEnrollment> enrollments = termService.findEnrollments(student);
        List<Enrollment> vos = termTransformer.toEnrollmentVos(enrollments);
        return new ResponseEntity<List<Enrollment>>(vos, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{identityNo}/addresses", method = RequestMethod.GET)
    public ResponseEntity<List<Address>> findAddressesByStudent(@PathVariable String identityNo) {
        AdStudent student = profileService.findStudentByMatricNo(identityNo);
        return new ResponseEntity<List<Address>>(profileTransformer
                .toAddressVos(profileService.findAddresses(student)), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{identityNo}/contacts", method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> findContactsByStudent(@PathVariable String identityNo) {
        AdStudent student = profileService.findStudentByMatricNo(identityNo);
        return new ResponseEntity<List<Contact>>(profileTransformer
                .toContactVos(profileService.findContacts(student)), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/students/{identityNo}/activate", method = RequestMethod.POST)
    public ResponseEntity<AdStudentStatus> activateStudent(@PathVariable String identityNo) {
    	dummyLogin();
    	AdStudent student = profileService.findStudentByMatricNo(identityNo);
    	student.setStudentStatus(AdStudentStatus.ACTIVE);
    	profileService.activateStudent(student);
    	return new ResponseEntity<AdStudentStatus>( student.getStudentStatus(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/students/{identityNo}/deactivate", method = RequestMethod.POST)
    public ResponseEntity<AdStudentStatus> deactivateStudent(@PathVariable String identityNo) {
    	dummyLogin();
    	AdStudent student = profileService.findStudentByMatricNo(identityNo);
    	student.setStudentStatus(AdStudentStatus.INACTIVE);
    	profileService.deactivateStudent(student);
    	return new ResponseEntity<AdStudentStatus>( student.getStudentStatus(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/students/{identityNo}/barStudent", method = RequestMethod.POST)
    public ResponseEntity<AdStudentStatus> barStudent(@PathVariable String identityNo) {
    	dummyLogin();
    	AdStudent student = profileService.findStudentByMatricNo(identityNo);
    	student.setStudentStatus(AdStudentStatus.BARRED);
    	profileService.barStudent(student);
    	return new ResponseEntity<AdStudentStatus>( student.getStudentStatus(), HttpStatus.OK);
    }
    
    //====================================================================================================
    // PRIVATE METHODS
    //====================================================================================================

    private void dummyLogin() {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("root", "abc123");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }
}
