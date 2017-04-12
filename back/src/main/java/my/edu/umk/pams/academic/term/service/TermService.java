package my.edu.umk.pams.academic.term.service;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.*;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Enroll = student enrolled into section<br/>
 * Withdraw = student withdrawn from section<br/>
 *
 * Appoint = staff appointed into section<br/>
 * Dismiss = staff dismissed from section<br/>
 *
 * @author PAMS
 */
public interface TermService {

    //====================================================================================================
    // OFFERING
    //====================================================================================================

    AdOffering findOfferingById(Long id);

    AdOffering findOfferingByCanonicalCode(String canonicalCode);

    AdOffering findOfferingByProgramAndCourse(AdProgram program, AdCourse course);

    // todo: ???
    AdAcademicSession findLastOfferedOffering(AdAcademicSession current, AdCourse course);

    List<AdOffering> findOfferings(Integer offset, Integer limit);

    List<AdOffering> findOfferings(String filter, Integer offset, Integer limit);

    List<AdOffering> findOfferings(AdProgram program);

    List<AdOffering> findOfferings(AdProgram program, Integer offset, Integer limit);

    List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, AdProgram program, Integer offset, Integer limit);

    List<AdOffering> findRunningOfferings(AdAcademicSession session);

    Integer countOffering(String filter);

    Integer countOffering(AdProgram program);

    Integer countOffering(AdCourse course);

    Integer countOffering(boolean authorized, String filter);

    Integer countOffering(boolean authorized, String filter, AdProgram program);

    Integer countOfferingWithSection(boolean authorized, String filter);

    Integer countOfferingWithSection(boolean authorized, String filter, AdAcademicSession session);

    boolean isOfferingExists(AdProgram program, AdCourse course);

    void saveOffering(AdOffering offering);
    
    void updateOffering(AdOffering offering);

    //==========+==========================================================================================
    // SECTION
    //====================================================================================================

    AdSection findSectionById(Long id);

    AdSection findSectionByCanonicalCode(String canonicalCode);

    List<AdSection> findSections(Integer offset, Integer limit);

    List<AdSection> findSections(String filter, AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdSection> findSections(AdOffering offering);

    List<AdSection> findSections(AdAcademicSession academicSession);

    List<AdSection> findSections(AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering);

    List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdSection> findSections(String filter, AdAcademicSession academicSession, AdAdmission admission, Integer offset, Integer limit);

    Integer countSection();

    Integer countSection(String filter, AdAcademicSession academicSession);

    Integer countSection(AdOffering offering);

    Integer countSection(AdAcademicSession academicSession);

    Integer countSection(AdAcademicSession academicSession, AdOffering offering);

    Integer countSection(String filter, AdAcademicSession academicSession, AdAdmission admission);

    Integer countAvailableStaff(AdOffering offering);

    Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering);

    boolean hasSection(AdAcademicSession academicSession);

    boolean hasSection(AdAcademicSession academicSession, AdOffering offering);

    boolean isSectionExists(String canonicalCode);

    void openSection(AdSection section); // todo(uda): throws SectionException;

    void closeSection(AdSection section);// todo(uda): throws SectionException;

    void saveSection(AdSection section);

    void updateSection(AdSection section);

    void removeSection(AdSection section);


    //====================================================================================================
    // ADMISSION APPLICATION
    //====================================================================================================

    // workflow

    AdAdmissionApplication findAdmissionApplicationByTaskId(String taskId);

    Task findAdmissionApplicationTaskByTaskId(String taskId);

    List<Task> findAssignedAdmissionApplicationTasks(Integer offset, Integer limit);

    List<Task> findPooledAdmissionApplicationTasks(Integer offset, Integer limit);

    Integer countAssignedAdmissionApplicationTasks();

    Integer countPooledAdmissionApplicationTasks();

    String startAdmissionApplicationTask(AdAdmissionApplication application);

    void updateAdmissionApplication(AdAdmissionApplication application);

    void cancelAdmissionApplication(AdAdmissionApplication application);

    void publishToAdmission(AdAdmissionApplication application);

    // finder

    AdAdmissionApplication findAdmissionApplicationById(Long id);

    AdAdmissionApplication findAdmissionApplicationByReferenceNo(String referenceNo);

    List<AdAdmissionApplication> findAdmissionApplications(AdAcademicSession session);

    List<AdAdmissionApplication> findAdmissionApplications(AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

    Integer countAdmissionApplication(AdAcademicSession session);

    Integer countAdmissionApplication(String filter, AdAcademicSession session);

    Integer countAdmissionApplication(String filter, AdAcademicSession session, AdStudent student);

    Integer countAdmissionApplication(String filter, AdAcademicSession session, AdStaff staff);

    //====================================================================================================
    // ADMISSION APPLICATION
    //====================================================================================================

    AdAdmissionApplication findAdmissionApplicationByProgramAndStudent(AdProgram program, AdStudent student);

    AdAdmission findAdmissionBySessionProgramAndStudent(AdAcademicSession academicSession, AdProgram program, AdStudent student);

    @Deprecated // use startAdmissionApplication
    void saveAdmissionApplication(AdAdmissionApplication application);

    //====================================================================================================
    // ADMISSION
    // TODO:
    //====================================================================================================

    void admit(AdAcademicSession academicSession, AdStudent student, AdStudyCenter studyCenter, AdProgram program);

    @Deprecated // use startAdmissionApplication
    void saveAdmission(AdAdmission admission);
    
    void updateAdmission(AdAdmission admission);
    

    //====================================================================================================
    // ENROLLMENT APPLICATION
    //====================================================================================================
    // workflow

    AdEnrollmentApplication findEnrollmentApplicationByTaskId(String taskId);

    Task findEnrollmentApplicationTaskByTaskId(String taskId);

    List<Task> findAssignedEnrollmentApplicationTasks(Integer offset, Integer limit);

    List<Task> findPooledEnrollmentApplicationTasks(Integer offset, Integer limit);

    Integer countAssignedEnrollmentApplicationTasks();

    Integer countPooledEnrollmentApplicationTasks();

    String startEnrollmentApplicationTask(AdEnrollmentApplication application);

    void updateEnrollmentApplication(AdEnrollmentApplication application);

    void cancelEnrollmentApplication(AdEnrollmentApplication application);

    void addEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void updateEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void deleteEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void publishToEnrollment(AdEnrollmentApplication application);

    //====================================================================================================
    // ENROLLMENT APPLICATION
    //====================================================================================================

    AdEnrollmentApplication findEnrollmentApplicationById(Long id);

    AdEnrollmentApplication findEnrollmentApplicationByReferenceNo(String referenceNo);

    AdEnrollmentApplicationItem findEnrollmentApplicationItemById(Long id);

    List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session);

    List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

    List<AdEnrollmentApplicationItem> findEnrollmentApplicationItems(AdEnrollmentApplication application);

    Integer countEnrollmentApplication(AdAcademicSession session);

    Integer countEnrollmentApplication(String filter, AdAcademicSession session);

    Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStudent student);

    Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStaff staff);

    //====================================================================================================
    // ENROLLMENT
    //====================================================================================================

    AdEnrollment findEnrollmentById(Long id);

    AdEnrollment findEnrollmentBySectionAndStudent(AdSection section, AdStudent student);

    AdEnrollment findEnrollmentByMatricNoAndOffering(String matricNo, AdOffering offering);

    List<AdEnrollment> findEnrollments(AdAcademicSession academicSession);

    List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdProgram program);

    List<AdEnrollment> findEnrollments(AdProgram program);

    List<AdEnrollment> findEnrollments(AdOffering offering);

    List<AdEnrollment> findEnrollments(AdSection section);

    List<AdEnrollment> findEnrollments(AdStudent student);

    List<AdEnrollment> findEnrollments(AdAdmission admission);

    List<AdEnrollment> findEnrollments(AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(String filter, AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(String filter, AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdOffering offering);

    List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdStudent student);

    List<AdEnrollment> findEnrollments(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(AdStudent student, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(AdSection section, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(String filter, AdSection section, Integer offset, Integer limit);

    Integer countEnrollment(AdOffering offering);

    Integer countEnrollment(AdAcademicSession academicSession, AdOffering offering);

    Integer countEnrollment(String filter, AdOffering offering);

    Integer countEnrollment(String filter, AdAcademicSession academicSession, AdOffering offering);

    Integer countEnrollment(AdSection section);

    Integer countEnrollment(AdEnrollmentStatus status, AdSection section);

    Integer countEnrollment(String filter, AdSection section);

    Integer countEnrollment(AdStudent student);

    Integer countEnrollment(AdAdmission admission);

    boolean isAnyEnrollmentExists(AdAcademicSession academicSession, AdOffering offering, AdStudent student);

    boolean isEnrollmentExists(AdSection section, AdStudent student);

    boolean hasEnrollment(AdSection section);

    boolean hasExceededEnrollment(AdSection section);

    // note: this is used by workflow
    void enroll(boolean override, AdSection section, AdStudent student, AdAdmission admission); // throws

    void withdraw(boolean override, AdSection section, AdStudent student, AdAdmission admission); // throws

    // todo(uda): business method is enroll()
    @Deprecated
    void saveEnrollment(AdEnrollment enrollment);

    void updateEnrollment(AdEnrollment enrollment);

    void deleteEnrollment(AdEnrollment enrollment);

    void addGradebooks(AdSection section, AdEnrollment enrollment);

    void addGradebooks(AdSection section, AdAssessment assessment);

    //====================================================================================================
    // APPOINTMENT
    //====================================================================================================

    AdAppointment findAppointmentById(Long id);

    AdAppointment findAppointmentBySectionAndStaff(AdSection section, AdStaff staff);

    List<AdAppointment> findAppointments(AdOffering offering);

    List<AdAppointment> findAppointments(AdSection section);

    List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdOffering offering);

    List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdStaff staff);

    List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdStaff staff, Integer offset, Integer limit);

    List<AdAppointment> findAppointments(AdSection section, Integer offset, Integer limit);

    Integer countAppointment(AdSection section);

    Integer countAppointment(AdAcademicSession academicSession, AdOffering offering);

    Integer countAppointment(AdAcademicSession academicSession, AdStaff staff);

    boolean hasAppointment(AdSection section);

    boolean isAppointmentExists(AdSection section, AdStaff staff);

    boolean isAnyAppointmentExists(AdAcademicSession academicSession, AdOffering offering, AdStaff staff);

    // business
    void appoint(AdSection section, AdStaff staff);

    void dismiss(AdSection section, AdStaff staff);

    // todo(uda): business method is appoint()
    void saveAppointment(AdAppointment appointment);

    void updateAppointment(AdAppointment appointment);

    void deleteAppointment(AdAppointment appointment);
}
