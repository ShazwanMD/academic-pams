package my.edu.umk.pams.academic.web.module.identity.controller;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.identity.vo.Actor;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.term.controller.TermTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.Appointment;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author PAMS
 */
@RestController
@Transactional
@RequestMapping("/api/identity")
public class IdentityController {

    private static final Logger LOG = LoggerFactory.getLogger(IdentityController.class);

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TermService termService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private IdentityTransformer identityTransformer;
    
    @Autowired
    private TermTransformer termTransformer;

    @Autowired
    AuthenticationManager authenticationManager;

    // ==================================================================================================== //
    // ACTOR
    // ==================================================================================================== //

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public ResponseEntity<List<Actor>> findActors() {
        return new ResponseEntity<List<Actor>>(identityTransformer
                .toActorVos(identityService.findActors(0, 100)), HttpStatus.OK);
    }

    // ==================================================================================================== //
    // STAFF
    // ==================================================================================================== //

    @RequestMapping(value = "/staffs", method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> findStaffs() {
        return new ResponseEntity<List<Staff>>(identityTransformer
                .toStaffVos(identityService.findStaffs(AdStaffType.ACADEMIC, 0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/staffs/{identityNo}", method = RequestMethod.GET)
    public ResponseEntity<Staff> findStaffByIdentityNo(@PathVariable String identityNo) {
        return new ResponseEntity<Staff>(identityTransformer
                .toStaffVo(identityService.findStaffByStaffNo(identityNo)), HttpStatus.OK);
    }
    
    //find appointments by staff
    @RequestMapping(value = "/staffs/{identityNo}/appointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointmentsByStaff(@PathVariable String identityNo) {
        AdStaff staff = identityService.findStaffByIdentityNo(identityNo);
        List<AdAppointment> appointments = termService.findAppointments(staff);
        List<Appointment> appointmentVos = termTransformer.toAppointmentVos(appointments);
        return new ResponseEntity<List<Appointment>>(appointmentVos, HttpStatus.OK);

    }
    
    // ==================================================================================================== //
    // STUDENT
    // ==================================================================================================== //

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> findStudents() {
        return new ResponseEntity<List<Student>>(identityTransformer
                .toStudentVos(identityService.findStudents(0, 100)), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{identityNo}", method = RequestMethod.GET)
    public ResponseEntity<Student> findStudentByIdentityNo(@PathVariable String identityNo) {
        return new ResponseEntity<Student>(identityTransformer
                .toStudentVo(identityService.findStudentByMatricNo(identityNo)), HttpStatus.OK);
    }
}
