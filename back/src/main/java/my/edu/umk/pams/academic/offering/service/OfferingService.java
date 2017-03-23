package my.edu.umk.pams.academic.offering.service;

import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.offering.model.*;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
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
public interface OfferingService {

    //====================================================================================================
    // OFFERING
    //====================================================================================================

    AdOffering findOfferingById(Long id);

    AdOffering findOfferingByCanonicalCode(String canonicalCode);

    AdOffering findOfferingByProgramAndCourse(AdProgram program, AdCourse course);

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

    // todo(uda): addEnrollment

    //==========+==========================================================================================
    // ENROLLMENT
    //====================================================================================================

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

    // todo(uda): business method is enroll()
    void saveEnrollment(AdEnrollment enrollment);

    void updateEnrollment(AdEnrollment enrollment);

    void deleteEnrollment(AdEnrollment enrollment);

    //====================================================================================================
    // ENROLLMENT APPLICATION
    //====================================================================================================

    AdEnrollmentApplication findEnrollmentApplicationByTaskId(String taskId);

    List<Task> findAssignedEnrollmentApplicationTasks(Integer offset, Integer limit);

    List<Task> findCandidateEnrollmentApplicationTasks(Integer offset, Integer limit);

    Integer countAssignedEnrollmentApplicationTasks();

    Integer countCandidateEnrollmentApplicationTasks();

    String processEnrollmentApplication(AdEnrollmentApplication application);

    void updateEnrollmentApplication(AdEnrollmentApplication application);

    void cancelEnrollmentApplication(AdEnrollmentApplication application);

    void addEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void updateEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void deleteEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void serializeToEnrollment(AdEnrollmentApplication application);

    void enroll(boolean override, AdSection section, AdStudent student, AdAdmission admission); // throws

    void withdraw(boolean override, AdSection section, AdStudent student, AdAdmission admission); // throws

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

    // todo(uda): business method is appoint()
    void saveAppointment(AdAppointment appointment);

    void updateAppointment(AdAppointment appointment);

    void deleteAppointment(AdAppointment appointment);
}
