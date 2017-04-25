package my.edu.umk.pams.academic.web.module.profile.controller;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.profile.service.ProfileService;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.profile.vo.Address;
import my.edu.umk.pams.academic.web.module.profile.vo.Contact;
import my.edu.umk.pams.academic.web.module.profile.vo.Guarantor;
import my.edu.umk.pams.academic.web.module.profile.vo.Guardian;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private ProfileTransformer profileTransformer;


    //====================================================================================================
    // FACULTY
    //====================================================================================================

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findStudents() {
        List<AdStudent> students = profileService.findStudents(0, 100);
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
}
