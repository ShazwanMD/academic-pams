package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.common.service.CommonService;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.term.vo.*;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private PlannerService plannerService;

    @Autowired
    private TermTransformer termTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;

    //====================================================================================================
    // ADMISSION
    //====================================================================================================

    @RequestMapping(value = "/admissions", method = RequestMethod.GET)
    public ResponseEntity<List<Admission>> findAdmissions() {
        return new ResponseEntity<List<Admission>>(termTransformer.toAdmissionVos(
                termService.findAdmissions(0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissions/current", method = RequestMethod.GET)
    public ResponseEntity<List<Admission>> findCurrentAdmissions() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAdmission> admissions = termService.findAdmissions(academicSession, 0, 100);
        return new ResponseEntity<List<Admission>>(termTransformer.toAdmissionVos(admissions), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissions/{academicSessionCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Admission>> findAdmissionsByAcademicSession(@PathVariable String academicSessionCode) {
        AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
        List<AdAdmission> admissions = termService.findAdmissions(academicSession, 0, 100);
        return new ResponseEntity<List<Admission>>(termTransformer.toAdmissionVos(admissions), HttpStatus.OK);
    }

    // workflow

    @RequestMapping(value = "/admissionApplications/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplicationTask>> findAssignedAdmissionApplications() {
        dummyLogin();
        List<Task> tasks = termService.findAssignedAdmissionApplicationTasks(0, 100);
        return new ResponseEntity<List<AdmissionApplicationTask>>(termTransformer.toAdmissionApplicationTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplicationTask>> findPooledAdmissionApplications() {
        dummyLogin();
        List<Task> tasks = termService.findPooledAdmissionApplicationTasks(0, 100);
        return new ResponseEntity<List<AdmissionApplicationTask>>(termTransformer.toAdmissionApplicationTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications/startTask", method = RequestMethod.POST)
    public void startAdmissionApplicationTask(@RequestBody AdmissionApplication vo) throws Exception {
        dummyLogin();

        AdStudent student = identityService.findStudentById(vo.getStudent().getId());
        AdAdmissionApplication application = new AdAdmissionApplicationImpl();
        application.setDescription(vo.getDescription());
        application.setStudent(student);
        termService.startAdmissionApplicationTask(application);
    }

    @RequestMapping(value = "/admissionApplications/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<AdmissionApplicationTask> findAdmissionApplicationTaskByTaskId(@PathVariable String taskId) {
        return new ResponseEntity<AdmissionApplicationTask>(termTransformer
                .toAdmissionApplicationTaskVo(
                        termService.findAdmissionApplicationTaskByTaskId(taskId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications/claimTask", method = RequestMethod.POST)
    public void claimAdmissionApplicationTask(@RequestBody AdmissionApplicationTask vo) {
        dummyLogin();
        Task task = termService.findAdmissionApplicationTaskByTaskId(vo.getTaskId());
        workflowService.claimTask(task);
    }

    @RequestMapping(value = "/admissionApplications/completeTask", method = RequestMethod.POST)
    public void completeAdmissionApplicationTask(@RequestBody AdmissionApplicationTask vo) {
        dummyLogin();
        Task task = termService.findAdmissionApplicationTaskByTaskId(vo.getTaskId());
        workflowService.completeTask(task);
    }

    //====================================================================================================
    // ENROLLMENT
    //====================================================================================================
    @RequestMapping(value = "/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdEnrollment> enrollments = termService.findEnrollments(academicSession);
        return new ResponseEntity<List<Enrollment>>(termTransformer.toEnrollmentVos(enrollments), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollments/current", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findCurrentEnrollments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdEnrollment> enrollments = termService.findEnrollments(academicSession);
        return new ResponseEntity<List<Enrollment>>(termTransformer.toEnrollmentVos(enrollments), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollments/{academicSessionCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollmentsByAcademicSession(@PathVariable String academicSessionCode) {
        AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
        List<AdEnrollment> enrollments = termService.findEnrollments(academicSession);
        return new ResponseEntity<List<Enrollment>>(termTransformer.toEnrollmentVos(enrollments), HttpStatus.OK);
    }

    // workflow

    @RequestMapping(value = "/enrollmentApplications/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationTask>> findAssignedEnrollmentApplications() {
        dummyLogin();
        List<Task> tasks = termService.findAssignedEnrollmentApplicationTasks(0, 100);
        return new ResponseEntity<List<EnrollmentApplicationTask>>(termTransformer.toEnrollmentApplicationTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationTask>> findPooledEnrollmentApplications() {
        dummyLogin();
        List<Task> tasks = termService.findPooledEnrollmentApplicationTasks(0, 100);
        return new ResponseEntity<List<EnrollmentApplicationTask>>(termTransformer.toEnrollmentApplicationTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/startTask", method = RequestMethod.POST)
    public void startEnrollmentApplicationTask(@RequestBody EnrollmentApplication vo) throws Exception {
        dummyLogin();

        AdAdmission admission = termService.findAdmissionById(vo.getAdmission().getId());
        AdEnrollmentApplication application = new AdEnrollmentApplicationImpl();
        application.setDescription(vo.getDescription());
        application.setAdmission(admission);
        termService.startEnrollmentApplicationTask(application);
    }

    @RequestMapping(value = "/enrollmentApplications/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<EnrollmentApplicationTask> findEnrollmentApplicationTaskByTaskId(@PathVariable String taskId) {
        return new ResponseEntity<EnrollmentApplicationTask>(termTransformer
                .toEnrollmentApplicationTaskVo(
                        termService.findEnrollmentApplicationTaskByTaskId(taskId)), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/claimTask", method = RequestMethod.POST)
    public void claimEnrollmentApplicationTask(@RequestBody EnrollmentApplicationTask vo) {
        dummyLogin();
        Task task = termService.findEnrollmentApplicationTaskByTaskId(vo.getTaskId());
        workflowService.claimTask(task);
    }

    @RequestMapping(value = "/enrollmentApplications/completeTask", method = RequestMethod.POST)
    public void completeEnrollmentApplicationTask(@RequestBody EnrollmentApplicationTask vo) {
        dummyLogin();
        Task task = termService.findEnrollmentApplicationTaskByTaskId(vo.getTaskId());
        workflowService.completeTask(task);
    }

    //====================================================================================================
    // APPOINTMENT
    //====================================================================================================

    @RequestMapping(value = "/appointments/", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAppointment> appointments = termService.findAppointments(academicSession);
        return new ResponseEntity<List<Appointment>>(termTransformer.toAppointmentVos(appointments), HttpStatus.OK);
    }

    @RequestMapping(value = "/appointments/current", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointments(@PathVariable Integer pageNo) {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAppointment> appointments = termService.findAppointments(academicSession);
        return new ResponseEntity<List<Appointment>>(termTransformer.toAppointmentVos(appointments), HttpStatus.OK);
    }


    @RequestMapping(value = "/appointments/{academicSessionCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointmentsByAcademicSession(@PathVariable String academicSessionCode) {
        AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
        List<AdAppointment> appointments = termService.findAppointments(academicSession);
        return new ResponseEntity<List<Appointment>>(termTransformer.toAppointmentVos(appointments), HttpStatus.OK);
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
    public ResponseEntity<List<Offering>> findOfferings(@PathVariable String academicSessionCode, @PathVariable Integer pageNo) {
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

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private void dummyLogin() {
        AdAutoLoginToken token = new AdAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

}
