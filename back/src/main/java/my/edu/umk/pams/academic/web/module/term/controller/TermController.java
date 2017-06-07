package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.common.service.CommonService;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;
import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.service.PlannerService;
import my.edu.umk.pams.academic.security.integration.AdAutoLoginToken;
import my.edu.umk.pams.academic.system.service.SystemService;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.planner.controller.PlannerTransformer;
import my.edu.umk.pams.academic.web.module.term.vo.*;
import my.edu.umk.pams.academic.workflow.service.WorkflowService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PAMS
 */
@Transactional
@RestController
@RequestMapping("/api/term")
public class TermController {

    private static final Logger LOG = LoggerFactory.getLogger(TermController.class);

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
    private PlannerTransformer plannerTransformer;

    @Autowired
    private AuthenticationManager authenticationManager;
    // ====================================================================================================
    // ADMISSION
    // ====================================================================================================

    @RequestMapping(value = "/admissions", method = RequestMethod.GET)
    public ResponseEntity<List<Admission>> findAdmissions() {
        return new ResponseEntity<List<Admission>>(
                termTransformer.toAdmissionVos(termService.findAdmissions(0, Integer.MAX_VALUE)), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissions/current", method = RequestMethod.GET)
    public ResponseEntity<List<Admission>> findCurrentAdmissions() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAdmission> admissions = termService.findAdmissions(academicSession, 0, 100);
        return new ResponseEntity<List<Admission>>(termTransformer.toAdmissionVos(admissions), HttpStatus.OK);
    }

    @RequestMapping(value = "/admissions/{id}", method = RequestMethod.GET)
    public ResponseEntity<Admission> findAdmissionById(@PathVariable Long id) throws UnsupportedEncodingException {
        return new ResponseEntity<Admission>(termTransformer.toAdmissionVo(termService.findAdmissionById(id)),
                HttpStatus.OK);
    }

    // workflow

    @RequestMapping(value = "/admissions", method = RequestMethod.POST)
    public ResponseEntity<String> saveAdmission(@RequestBody Admission vo) {
        dummyLogin();
        AdAdmission admission = new AdAdmissionImpl();
        admission.setCgpa(vo.getCgpa());
        admission.setCreditEarned(vo.getCreditEarned());
        admission.setCreditTaken(vo.getCreditTaken());
        admission.setGpa(vo.getGpa());
        admission.setStatus(AdAdmissionStatus.get(vo.getStatus().ordinal()));
        admission.setStanding(AdAcademicStanding.get(vo.getStanding().ordinal()));
        admission.setCohort(plannerService.findCohortByCode(vo.getCohort().getCode()));
        admission.setStudent(identityService.findStudentByMatricNo(vo.getStudent().getIdentityNo()));
        admission.setStudyCenter(commonService.findStudyCenterByCode(vo.getStudyCenter().getCode()));
        admission.setSession(plannerService.findAcademicSessionByCode(vo.getAcademicSession().getCode()));
        termService.saveAdmission(admission);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/admissions", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAdmission(@PathVariable AdAcademicSession academicSession, @PathVariable AdCohort cohort, @PathVariable AdStudent student,@RequestBody Admission vo) {
        dummyLogin();
        AdAdmission admission = termService.findAdmissionByAcademicSessionCohortAndStudent(academicSession, cohort, student);
        admission.setCgpa(vo.getCgpa());
        admission.setCreditEarned(vo.getCreditEarned());
        admission.setCreditTaken(vo.getCreditTaken());
        admission.setGpa(vo.getGpa());
        admission.setStatus(AdAdmissionStatus.get(vo.getStatus().ordinal()));
        admission.setStanding(AdAcademicStanding.get(vo.getStanding().ordinal()));
        admission.setCohort(plannerService.findCohortByCode(vo.getCohort().getCode()));
        admission.setStudent(identityService.findStudentByMatricNo(vo.getStudent().getIdentityNo()));
        admission.setStudyCenter(commonService.findStudyCenterByCode(vo.getStudyCenter().getCode()));
        admission.setSession(plannerService.findAcademicSessionByCode(vo.getAcademicSession().getCode()));
        termService.updateAdmission(admission);
        return new ResponseEntity<String>("Success Update Admission", HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplication>> findAdmissionsApplications() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        return new ResponseEntity<List<AdmissionApplication>>(
                termTransformer.toAdmissionApplicationVos(termService.findAdmissionApplications(academicSession)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications/save", method = RequestMethod.POST)
    public ResponseEntity<String> saveAdmissionApplication(@RequestBody AdmissionApplication vo) {
        dummyLogin();
        AdAdmissionApplication application = new AdAdmissionApplicationImpl();
        application.setReferenceNo(vo.getReferenceNo());
        application.setAuditNo(vo.getAuditNo());
        application.setSourceNo(vo.getSourceNo());
        application.setDescription(vo.getDescription());
        application.setCancelComment(vo.getCancelComment());
        application.setRemoveComment(vo.getRemoveComment());
        application.setAdvisor(identityService.findStaffByStaffNo(vo.getAdvisor().getIdentityNo()));
        application.setStudent(identityService.findStudentByMatricNo(vo.getStudent().getIdentityNo()));
        application.setProgram(plannerService.findProgramByCode(vo.getProgram().getCode()));
        application.setSession(plannerService.findAcademicSessionByCode(vo.getSession().getCode()));
        application.setStudyCenter(commonService.findStudyCenterByCode(vo.getStudyCenter().getCode()));
        termService.saveAdmissionApplication(application);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }


    @RequestMapping(value = "/admissionApplications/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplicationTask>> findAssignedAdmissionApplications() {
        dummyLogin();
        List<Task> tasks = termService.findAssignedAdmissionApplicationTasks(0, 100);
        return new ResponseEntity<List<AdmissionApplicationTask>>(termTransformer.toAdmissionApplicationTaskVos(tasks),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<AdmissionApplicationTask>> findPooledAdmissionApplications() {
        dummyLogin();
        List<Task> tasks = termService.findPooledAdmissionApplicationTasks(0, 100);
        return new ResponseEntity<List<AdmissionApplicationTask>>(termTransformer.toAdmissionApplicationTaskVos(tasks),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/admissionApplications/startTask", method = RequestMethod.POST)
    public void startAdmissionApplicationTask(@RequestBody AdmissionApplication vo) throws Exception {
        dummyLogin();
        AdStudent student = identityService.findStudentById(vo.getStudent().getId());
        AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getSession().getId());
        AdAdmissionApplication application = new AdAdmissionApplicationImpl();
        application.setDescription(vo.getDescription());
        application.setStudent(student);
        application.setSession(academicSession);
        termService.startAdmissionApplicationTask(application);
    }

    @RequestMapping(value = "/admissionApplications/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<AdmissionApplicationTask> findAdmissionApplicationTaskByTaskId(@PathVariable String taskId) {
        return new ResponseEntity<AdmissionApplicationTask>(
                termTransformer.toAdmissionApplicationTaskVo(termService.findAdmissionApplicationTaskByTaskId(taskId)),
                HttpStatus.OK);
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

    @RequestMapping(value = "/admissionApplications/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<AdmissionApplication> findAdmissionApplicationByReferenceNo(
            @PathVariable String referenceNo) {
        dummyLogin();
        AdAdmissionApplication application = termService.findAdmissionApplicationByReferenceNo(referenceNo);
        return new ResponseEntity<AdmissionApplication>(termTransformer.toAdmissionApplicationVo(application),
                HttpStatus.OK);
    }
    // ====================================================================================================
    // ENROLLMENT
    // ====================================================================================================

    @RequestMapping(value = "/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdEnrollment> enrollments = termService.findEnrollments(academicSession);
        return new ResponseEntity<List<Enrollment>>(termTransformer.toEnrollmentVos(enrollments), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollments/academicSession/current", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findCurrentEnrollments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdEnrollment> enrollments = termService.findEnrollments(academicSession);
        return new ResponseEntity<List<Enrollment>>(termTransformer.toEnrollmentVos(enrollments), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollments/academicSession/{academicSessionCode}", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollmentsByAcademicSession(@PathVariable String academicSessionCode) {
        AdAcademicSession academicSession = plannerService.findAcademicSessionByCode(academicSessionCode);
        List<AdEnrollment> enrollments = termService.findEnrollments(academicSession);
        return new ResponseEntity<List<Enrollment>>(termTransformer.toEnrollmentVos(enrollments), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollments/{id}", method = RequestMethod.GET)
    public ResponseEntity<Enrollment> findEnrollmentByid(@PathVariable Long id) {
        AdEnrollment enrollment = termService.findEnrollmentById(id);
        return new ResponseEntity<Enrollment>(termTransformer.toEnrollmentVo(enrollment), HttpStatus.OK);
    }

    // ====================================================================================================
    // ENROLLMENT APPLICATION
    // ====================================================================================================
    // workflow

    @RequestMapping(value = "/enrollmentApplications", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplication>> findenrollmentApplications() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdEnrollmentApplication> enrollmentApplications = termService.findEnrollmentApplications(academicSession);
        return new ResponseEntity<List<EnrollmentApplication>>(
                termTransformer.toEnrollmentApplicationVos(enrollmentApplications), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/{referenceNo}", method = RequestMethod.GET)
    public ResponseEntity<EnrollmentApplication> findEnrollmentApplicationByReferenceNo(
            @PathVariable String referenceNo) {
        AdEnrollmentApplication enrollmentApplication = (AdEnrollmentApplication) termService
                .findEnrollmentApplicationByReferenceNo(referenceNo);
        return new ResponseEntity<EnrollmentApplication>(
                termTransformer.toEnrollmentApplicationVo(enrollmentApplication), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/{referenceNo}", method = RequestMethod.PUT)
    public ResponseEntity<EnrollmentApplication> updateEnrollmentApplication(@PathVariable String referenceNo,
                                                                             @RequestBody EnrollmentApplication vo) {
        AdEnrollmentApplication enrollmentApplication = (AdEnrollmentApplication) termService
                .findEnrollmentApplicationByReferenceNo(referenceNo);
        return new ResponseEntity<EnrollmentApplication>(
                termTransformer.toEnrollmentApplicationVo(enrollmentApplication), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/{referenceNo}/enrollmentApplicationItems", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationItem>> findEnrollmentApplicationItems(
            @PathVariable String referenceNo) {
        dummyLogin();
        AdEnrollmentApplication enrollmentApplication = termService.findEnrollmentApplicationByReferenceNo(referenceNo);
        return new ResponseEntity<List<EnrollmentApplicationItem>>(termTransformer.toEnrollmentApplicationItemVos(
                termService.findEnrollmentApplicationItems(enrollmentApplication)), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/{referenceNo}/enrollmentApplicationItems", method = RequestMethod.POST)
    public ResponseEntity<String> addEnrollmentApplicationItem(@PathVariable String referenceNo,
                                             @RequestBody EnrollmentApplicationItem vo) {
        dummyLogin();

        LOG.debug("referenceNo: {}", referenceNo);
        AdEnrollmentApplication enrollmentApplication = termService.findEnrollmentApplicationByReferenceNo(referenceNo);
        AdEnrollmentApplicationItem e = new AdEnrollmentApplicationItemImpl();
        e.setAction(AdEnrollmentApplicationAction.get(vo.getAction().ordinal()));
        e.setSection(termService.findSectionById(vo.getSection().getId()));
        termService.addEnrollmentApplicationItem(enrollmentApplication, e);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/{referenceNo}/enrollmentApplicationItems", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEnrollmentApplicationItems(@PathVariable String referenceNo,
                                                 @RequestBody EnrollmentApplicationItem item) {
        dummyLogin();
        AdEnrollmentApplication enrollmentApplication = termService.findEnrollmentApplicationByReferenceNo(referenceNo);
        AdEnrollmentApplicationItem e = termService.findEnrollmentApplicationItemById(item.getId());
        e.setAction(AdEnrollmentApplicationAction.ADD);
        e.setSection(termService.findSectionById(item.getSection().getId()));
        termService.updateEnrollmentApplicationItem(enrollmentApplication, e);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/{referenceNo}/enrollmentApplicationItems/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEnrollmentApplicationItems(@PathVariable String referenceNo, @PathVariable Long id) {
        dummyLogin();
        AdEnrollmentApplication enrollmentApplication = termService.findEnrollmentApplicationByReferenceNo(referenceNo);
        AdEnrollmentApplicationItem e = termService.findEnrollmentApplicationItemById(id);
        termService.deleteEnrollmentApplicationItem(enrollmentApplication, e);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/assignedTasks", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationTask>> findAssignedEnrollmentApplications() {
        dummyLogin();
        List<Task> tasks = termService.findAssignedEnrollmentApplicationTasks(0, 100);
        return new ResponseEntity<List<EnrollmentApplicationTask>>(
                termTransformer.toEnrollmentApplicationTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/pooledTasks", method = RequestMethod.GET)
    public ResponseEntity<List<EnrollmentApplicationTask>> findPooledEnrollmentApplications() {
        dummyLogin();
        List<Task> tasks = termService.findPooledEnrollmentApplicationTasks(0, 100);
        return new ResponseEntity<List<EnrollmentApplicationTask>>(
                termTransformer.toEnrollmentApplicationTaskVos(tasks), HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/startTask", method = RequestMethod.POST)
    public ResponseEntity<String> startEnrollmentApplicationTask(@RequestBody EnrollmentApplication vo)
            throws Exception {
        dummyLogin();

        AdAdmission admission = termService.findAdmissionById(vo.getAdmission().getId());
        AdAcademicSession academicSession = plannerService.findAcademicSessionById(vo.getAcademicSession().getId());
        AdEnrollmentApplication application = new AdEnrollmentApplicationImpl();
        application.setDescription(vo.getDescription());
        application.setAdmission(admission);
        application.setSession(academicSession);
        application.setAuditNo(vo.getAuditNo());
        application.setCancelComment(vo.getCancelComment());
        application.setRemoveComment(vo.getRemoveComment());
        application.setSourceNo(vo.getSourceNo());
        application.setType(AdEnrollmentApplicationType.get(vo.getApplicationType().ordinal()));

        String referenceNo = termService.startEnrollmentApplicationTask(application);
        return new ResponseEntity<String>(referenceNo, HttpStatus.OK);
    }

    @RequestMapping(value = "/enrollmentApplications/viewTask/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<EnrollmentApplicationTask> findEnrollmentApplicationTaskByTaskId(
            @PathVariable String taskId) {
        return new ResponseEntity<EnrollmentApplicationTask>(termTransformer.toEnrollmentApplicationTaskVo(
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

    // ====================================================================================================
    // APPOINTMENT
    // ====================================================================================================

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAppointment> appointments = termService.findAppointments(academicSession);
        return new ResponseEntity<List<Appointment>>(termTransformer.toAppointmentVos(appointments), HttpStatus.OK);
    }

    @RequestMapping(value = "/appointments/current", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findCurrentAppointments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAppointment> appointments = termService.findAppointments(academicSession);
        return new ResponseEntity<List<Appointment>>(termTransformer.toAppointmentVos(appointments), HttpStatus.OK);
    }

    @RequestMapping(value = "/appointments/{id}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable Long id) throws UnsupportedEncodingException {
        return new ResponseEntity<Appointment>(termTransformer.toAppointmentVo(termService.findAppointmentById(id)),
                HttpStatus.OK);
    }

    // ====================================================================================================
    // OFFERING
    // ====================================================================================================

    // finder
    @RequestMapping(value = "/offerings", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOfferings() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdOffering> offerings = termService.findOfferings(0, 100);
        return new ResponseEntity<List<Offering>>(termTransformer.toOfferingVos(offerings), HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{academicSessionCode}/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOfferings(@PathVariable String academicSessionCode,
                                                        @PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/current/page/{pageNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Offering>> findOfferings(@PathVariable Integer pageNo) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}", method = RequestMethod.GET)
    public ResponseEntity<Offering> findOffering(@PathVariable String canonicalCode) {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        return new ResponseEntity<Offering>(termTransformer.toOfferingVo(offering), HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/sections", method = RequestMethod.GET)
    public ResponseEntity<List<Section>> findSectionsByOffering(@PathVariable String canonicalCode)
            throws UnsupportedEncodingException {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        List<AdSection> sections = termService.findSections(offering);
        List<Section> sectionVos = decorateSection(termTransformer.toSectionVos(sections));
        return new ResponseEntity<List<Section>>(sectionVos, HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/sections/{sectionCanonicalCode}", method = RequestMethod.GET)
    public ResponseEntity<Section> findSectionByCanonicalCode(@PathVariable String canonicalCode,
                                                              @PathVariable String sectionCanonicalCode) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/assessments", method = RequestMethod.GET)
    public ResponseEntity<List<Assessment>> findAssessmentsByOffering(@PathVariable String canonicalCode)
            throws UnsupportedEncodingException {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        List<AdAssessment> assessments = termService.findAssessments(offering);
        List<Assessment> assessmentVos = termTransformer.toAssessmentVos(assessments);
        return new ResponseEntity<List<Assessment>>(assessmentVos, HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/assessments/{assessmentCanonicalCode}", method = RequestMethod.GET)
    public ResponseEntity<Assessment> findAssessmentByCanonicalCode(@PathVariable String canonicalCode,
                                                                    @PathVariable String assessmentCanonicalCode) throws UnsupportedOperationException {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdAssessment assessment = termService.findAssessmentByCanonicalCode(assessmentCanonicalCode);
        return new ResponseEntity<Assessment>(HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/appointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointmentsByOffering(@PathVariable String canonicalCode) {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        List<AdAppointment> appointments = termService.findAppointments(offering);
        List<Appointment> appointmentVos = termTransformer.toAppointmentVos(appointments);
        return new ResponseEntity<List<Appointment>>(appointmentVos, HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/appointments/{appointmentId}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable String canonicalCode,
                                                           @PathVariable Long appointmentId) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollmentsByOffering(@PathVariable String canonicalCode) {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        List<AdEnrollment> enrollments = termService.findEnrollments(offering);
        List<Enrollment> enrollmentVos = termTransformer.toEnrollmentVos(enrollments);
        return new ResponseEntity<List<Enrollment>>(enrollmentVos, HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments/{enrollmentId}", method = RequestMethod.GET)
    public ResponseEntity<Enrollment> findEnrollmentById(@PathVariable String canonicalCode,
                                                         @PathVariable Long enrollmentId) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/assessments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAssessment(@PathVariable String canonicalCode, @RequestBody Assessment vo) {
        dummyLogin();
        LOG.debug("assessment_ID:{}", vo.getId());
        LOG.debug("Offering Canonical:{}", canonicalCode);

        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdAssessment assessment = termService.findAssessmentById(vo.getId());
        assessment.setCode(vo.getCode());
        assessment.setCanonicalCode(vo.getCanonicalCode());
        assessment.setDescription(vo.getDescription());
        assessment.setOrdinal(vo.getOrdinal());
        assessment.setWeight(vo.getWeight());
        assessment.setTotalScore(vo.getTotalScore());
        assessment.setType(AdAssessmentType.get(vo.getAssessmentType().ordinal()));
        assessment.setCategory(AdAssessmentCategory.get(vo.getAssessmentCategory().ordinal()));
        assessment.setOffering(offering);
        termService.updateAssessment(offering, assessment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/assessments", method = RequestMethod.POST)
    public ResponseEntity<String> addAssessment(@PathVariable String canonicalCode, @RequestBody Assessment vo) {
        dummyLogin();
        LOG.debug("assessment:{}", vo);
        LOG.debug("Offering Canonical:{}", canonicalCode);

        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdAssessment assessment = new AdAssessmentImpl();
        assessment.setCode(vo.getCode());
        assessment.setCanonicalCode(vo.getCanonicalCode());
        assessment.setDescription(vo.getDescription());
        assessment.setOrdinal(vo.getOrdinal());
        assessment.setWeight(vo.getWeight());
        assessment.setTotalScore(vo.getTotalScore());
        assessment.setType(AdAssessmentType.get(vo.getAssessmentType().ordinal()));
        assessment.setCategory(AdAssessmentCategory.get(vo.getAssessmentCategory().ordinal()));
        assessment.setOffering(termService.findOfferingById(vo.getOffering().getId()));
        termService.addAssessment(offering, assessment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/assessments/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAssessment(@PathVariable String canonicalCode, @PathVariable Long id) {
        dummyLogin();
        LOG.debug("assessment:{}", id);
        LOG.debug("Offering Canonical:{}", canonicalCode);
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdAssessment assessment = termService.findAssessmentById(id);
        termService.deleteAssessment(offering, assessment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/sections", method = RequestMethod.POST)
    public ResponseEntity<String> addSection(@PathVariable String canonicalCode, @RequestBody Section vo) {
        dummyLogin();

        LOG.debug("adding section code: {}", vo.getCode());
        LOG.debug("adding section canonical code: {}", vo.getCanonicalCode());
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdSection section = new AdSectionImpl();
        section.setCode(vo.getCode());
        section.setCanonicalCode(vo.getCanonicalCode());
        section.setCapacity(vo.getCapacity());
        section.setOrdinal(vo.getOrdinal());
        section.setOffering(termService.findOfferingById(vo.getOffering().getId()));
        termService.addSection(offering, section);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings", method = RequestMethod.POST)
    public ResponseEntity<String> saveOffering(@RequestBody Offering vo) {
        dummyLogin();

        AdOffering offering = new AdOfferingImpl();
        offering.setCode(vo.getCode());
        offering.setCanonicalCode(vo.getCanonicalCode());
        offering.setCapacity(vo.getCapacity());
        offering.setTitleMs(vo.getTitleMs());
        offering.setTitleEn(vo.getTitleEn());
        offering.setCourse(plannerService.findCourseByCode(vo.getCourse().getCode()));
        offering.setProgram(plannerService.findProgramByCode(vo.getProgram().getCode()));
        offering.setSession(plannerService.findAcademicSessionByCode(vo.getAcademicSession().getCode()));

        termService.saveOffering(offering);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateOffering(@PathVariable String canonicalCode, @RequestBody Offering vo) {
        dummyLogin();

        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        offering.setCode(vo.getCode());
        offering.setCanonicalCode(vo.getCanonicalCode());
        offering.setCapacity(vo.getCapacity());
        offering.setTitleMs(vo.getTitleMs());
        offering.setTitleEn(vo.getTitleEn());
        offering.setCourse(plannerService.findCourseByCode(vo.getCourse().getCode()));
        offering.setProgram(plannerService.findProgramByCode(vo.getProgram().getCode()));
        offering.setSession(plannerService.findAcademicSessionByCode(vo.getAcademicSession().getCode()));

        termService.updateOffering(offering);
        return new ResponseEntity<String>("Success Update Offering", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/sections/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateSection(@PathVariable String canonicalCode, @RequestBody Section vo) {
        dummyLogin();

        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdSection section = termService.findSectionByCanonicalCode(vo.getCanonicalCode());

        section.setCanonicalCode(vo.getCanonicalCode());
        section.setCode(vo.getCode());
        section.setCapacity(vo.getCapacity());
        section.setOrdinal(vo.getOrdinal());
        section.setOffering(offering);
        termService.updateSection(offering, section);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments", method = RequestMethod.POST)
    public ResponseEntity<String> addEnrollment(@PathVariable String canonicalCode, @RequestBody Enrollment vo) {
        dummyLogin();

        throw new UnsupportedOperationException();
    }

    //delete section by offering
    @RequestMapping(value = "/offerings/{canonicalCode}/sections/{sectionId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSection(@PathVariable String canonicalCode, @PathVariable Long sectionId) {
        dummyLogin();

        LOG.debug("section:{}", sectionId);
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdSection section = termService.findSectionById(sectionId);
        termService.deleteSection(offering, section);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/appointments/{appointmentId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAppointment(@PathVariable String canonicalCode,
                                                    @PathVariable Long appointmentId) {
        dummyLogin();
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdAppointment appointment = termService.findAppointmentById(appointmentId);
        termService.deleteAppointment(appointment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/offerings/{canonicalCode}/enrollments/{enrollmentId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEnrollment(@PathVariable String canonicalCode,
                                                   @PathVariable Long enrollmentId) {
        dummyLogin();
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdEnrollment enrollment = termService.findEnrollmentById(enrollmentId);
        termService.deleteEnrollment(enrollment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // ====================================================================================================
    // ASSESSMENT
    // ====================================================================================================
    // finder

    @RequestMapping(value = "/assessments/{id}", method = RequestMethod.GET)
    public ResponseEntity<Assessment> findAssessmentById(@PathVariable Long id) {
        AdAssessment assessment = termService.findAssessmentById(id);
        return new ResponseEntity<Assessment>(termTransformer.toAssessmentVo(assessment), HttpStatus.OK);
    }

    @RequestMapping(value = "/assessments", method = RequestMethod.GET)
    public ResponseEntity<List<Assessment>> findAssessments() {
        AdAcademicSession academicSession = plannerService.findCurrentAcademicSession();
        List<AdAssessment> assessments = termService.findAssessments(0, Integer.MAX_VALUE);
        return new ResponseEntity<List<Assessment>>(termTransformer.toAssessmentVos(assessments), HttpStatus.OK);
    }

    // ====================================================================================================
    // SECTION
    // ====================================================================================================

    // finder
    @RequestMapping(value = "/sections", method = RequestMethod.GET)
    public ResponseEntity<List<Section>> findSections() {
        List<AdSection> sections = termService.findSections(0, 100);
        return new ResponseEntity<List<Section>>(termTransformer.toSectionVos(sections), HttpStatus.OK);
    }

    @RequestMapping(value = "/sections/{canonicalCode}", method = RequestMethod.GET)
    public ResponseEntity<Section> findSection(@PathVariable String canonicalCode) {
        AdSection section = termService.findSectionByCanonicalCode(canonicalCode);
        return new ResponseEntity<Section>(termTransformer.toSectionVo(section), HttpStatus.OK);
    }

    @RequestMapping(value = "/sections/{canonicalCode}/appointments", method = RequestMethod.POST)
    public ResponseEntity<String> addAppointment(@PathVariable String canonicalCode, @RequestBody Appointment vo) {
        dummyLogin();

        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        AdSection section = termService.findSectionById(vo.getSection().getId());
        AdAppointment appointment = new AdAppointmentImpl();
        appointment.setStatus(AdAppointmentStatus.get(vo.getAppointmentStatus().ordinal()));
        //appointment.setStatus(AdAppointmentStatus.CONFIRMED);
        appointment.setSection(section);
        appointment.setStaff(identityService.findStaffById(vo.getStaff().getId()));
        termService.addAppointment(section, appointment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    // update appointment by section
    @RequestMapping(value = "/sections/{canonicalCode}/appointments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateAppointment(@PathVariable String canonicalCode, @RequestBody Appointment vo) {
        dummyLogin();

        AdSection section = termService.findSectionByCanonicalCode(canonicalCode);
        AdAppointment appointment = termService.findAppointmentById(vo.getId());
        appointment.setSection(section);
        appointment.setStaff(identityService.findStaffById(vo.getStaff().getId()));
        appointment.setStatus(AdAppointmentStatus.get(vo.getAppointmentStatus().ordinal()));
        termService.updateAppointment(section, appointment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }


    //delete appointment by section
    @RequestMapping(value = "/sections/{canonicalCode}/appointments/{appointmentId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeAppointment(@PathVariable String canonicalCode, @PathVariable Long appointmentId) {
        dummyLogin();

        LOG.debug("appointment:{}", appointmentId);
        AdSection section = termService.findSectionByCanonicalCode(canonicalCode);
        AdAppointment appointment = termService.findAppointmentById(appointmentId);
        termService.removeAppointment(section, appointment);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/sections/{canonicalCode}/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> findEnrollmentsBySection(@PathVariable String canonicalCode) {
        AdSection section = termService.findSectionByCanonicalCode(canonicalCode);
        List<AdEnrollment> enrollments = termService.findEnrollments(section);
        List<Enrollment> enrollmentVos = termTransformer.toEnrollmentVos(enrollments);
        return new ResponseEntity<List<Enrollment>>(enrollmentVos, HttpStatus.OK);

    }

    @RequestMapping(value = "/sections/{canonicalCode}/appointments", method = RequestMethod.GET)
    public ResponseEntity<List<Appointment>> findAppointmentsBySection(@PathVariable String canonicalCode) {
        AdSection section = termService.findSectionByCanonicalCode(canonicalCode);
        List<AdAppointment> appointments = termService.findAppointments(section);
        List<Appointment> appointmentVos = termTransformer.toAppointmentVos(appointments);
        return new ResponseEntity<List<Appointment>>(appointmentVos, HttpStatus.OK);

    }

    // gradebook
    @RequestMapping(value = "/offerings/{canonicalCode}/gradebookMatrices", method = RequestMethod.GET)
    public ResponseEntity<List<GradebookMatrix>> findGradebookMatrices(@PathVariable String canonicalCode) {
        AdOffering offering = termService.findOfferingByCanonicalCode(canonicalCode);
        List<AdEnrollment> enrollments = termService.findEnrollments(offering);
        List<GradebookMatrix> matrices = new ArrayList<GradebookMatrix>();
        for (AdEnrollment enrollment : enrollments) {
            GradebookMatrix matrix = new GradebookMatrix();
            matrix.setEnrollment(termTransformer.toSimpleEnrollmentVo(enrollment));
            List<AdAssessment> assessments = termService.findAssessments(offering);
            for (AdAssessment assessment : assessments) {
                Gradebook gradebook = new Gradebook();
                gradebook.setScore(BigDecimal.ZERO);
                gradebook.setAssessment(termTransformer.toAssessmentVo(assessment));
                matrix.addGradebook(gradebook);
            }
            matrices.add(matrix);
        }
        LOG.debug("Enrollment:{}", enrollments);
        return new ResponseEntity<List<GradebookMatrix>>(matrices, HttpStatus.OK);
    }

    // ====================================================================================================
    // PRIVATE METHODS
    // ====================================================================================================

    private List<Section> decorateSection(List<Section> sections) {
        for (Section section : sections) {
            AdSection s = termService.findSectionById(section.getId());
            section.setAppointmentCount(termService.countAppointment(s));
            section.setEnrollmentCount(termService.countEnrollment(s));
        }
        return sections;
    }

    private void dummyLogin() {
        AdAutoLoginToken token = new AdAutoLoginToken("root");
        Authentication authed = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authed);
    }

}