package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.term.vo.*;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author PAMS
 */
@Transactional
@RestController
@RequestMapping("/api/term")
public class TermController {

    @Autowired
    private TermService termService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private TermTransformer termTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;

    //====================================================================================================
    // ADMISSION
    //====================================================================================================

    @RequestMapping(value = "/admissions", method = RequestMethod.GET)
    public ResponseEntity<Admission> findAdmissions() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissions/current", method = RequestMethod.GET)
    public ResponseEntity<Admission> findCurrentAdmissions() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissions/{academicSessionCode}", method = RequestMethod.GET)
    public ResponseEntity<Admission> findAdmissions(@PathVariable String academicSessionCode) {
        throw new UnsupportedOperationException();
    }

    // workflow

    @RequestMapping(value = "/admissionApplications/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplicationTask>> findAssignedAdmissionApplications() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissionApplications/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplicationTask>> findPooledAdmissionApplications() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissionApplications/startTask", method = RequestMethod.POST)
    public void startAdmissionApplicationTask(@RequestBody AdmissionApplication vo) throws Exception {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissionApplications/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<AdmissionApplicationTask> findAdmissionApplicationTaskByTaskId(@PathVariable String taskId) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissionApplications/claimTask", method = RequestMethod.POST)
    public void claimAdmissionApplicationTask(@RequestBody AdmissionApplicationTask vo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/admissionApplications/completeTask", method = RequestMethod.POST)
    public void completeAdmissionApplicationTask(@RequestBody AdmissionApplicationTask vo) {
        throw new UnsupportedOperationException();
    }

    //====================================================================================================
    // ENROLLMENT
    //====================================================================================================
    @RequestMapping(value = "/enrollments/", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollments() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/enrollments/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollments(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    // workflow

    @RequestMapping(value = "/enrollmentApplications/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationTask>> findAssignedEnrollmentApplications() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/enrollmentApplications/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationTask>> findPooledEnrollmentApplications() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/enrollmentApplications/startTask", method = RequestMethod.POST)
    public void startEnrollmentApplicationTask(@RequestBody EnrollmentApplication vo) throws Exception {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/enrollmentApplications/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<EnrollmentApplicationTask> findEnrollmentApplicationTaskByTaskId(@PathVariable String taskId) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/enrollmentApplications/claimTask", method = RequestMethod.POST)
    public void claimEnrollmentApplicationTask(@RequestBody EnrollmentApplicationTask vo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/enrollmentApplications/completeTask", method = RequestMethod.POST)
    public void completeEnrollmentApplicationTask(@RequestBody EnrollmentApplicationTask vo) {
        throw new UnsupportedOperationException();
    }

    //====================================================================================================
    // APPOINTMENT
    //====================================================================================================

    @RequestMapping(value = "/appointments/", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointments() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/appointments/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointments(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    //====================================================================================================
    // OFFERING
    //====================================================================================================

    // finder
    @RequestMapping(value = "/offerings/", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOfferings() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{academicSessionCode}/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOfferings(@PathVariable String academicSessionCode,  @PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/current/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOfferings(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOffering(@PathVariable String canonicalCode) {
        throw new UnsupportedOperationException();
    }


    @RequestMapping(value = "/offerings/{canonicalCode}/sections", method = RequestMethod.GET)
    public ResponseEntity<List<Section>> findSectionsByOffering(@PathVariable String canonicalCode) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/sections/{sectionCode}", method = RequestMethod.GET)
    public ResponseEntity<Section> findSectionById(@PathVariable String canonicalCode,
                                                          @PathVariable String sectionCode) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/appointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointmentsByOffering(@PathVariable String canonicalCode) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/appointments/{appointmentId}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable String canonicalCode,
                                                                 @PathVariable Long appointmentId) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollmentsByOffering(@PathVariable String canonicalCode) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments/{enrollmentId}", method = RequestMethod.GET)
    public ResponseEntity<Enrollment> findEnrollmentById(@PathVariable String canonicalCode,
                                                              @PathVariable Long enrollmentId) {
        throw new UnsupportedOperationException();
    }

    // business

    @RequestMapping(value = "/offerings/{canonicalCode}/sections", method = RequestMethod.POST)
    public ResponseEntity<List<Offering>> addSection(@PathVariable String canonicalCode, @RequestBody Section section) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/appointments", method = RequestMethod.POST)
    public ResponseEntity<List<Offering>> addAppointment(@PathVariable String canonicalCode, @RequestBody Appointment appointment) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments", method = RequestMethod.POST)
    public ResponseEntity<List<Offering>> addEnrollment(@PathVariable String canonicalCode, @RequestBody Enrollment enrollment) {
        throw new UnsupportedOperationException();
    }
}
