package my.edu.umk.pams.academic.term.service;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;
import my.edu.umk.pams.academic.web.module.term.vo.Section;

import org.activiti.engine.task.Task;

import java.math.BigDecimal;
import java.util.List;

/**
 * Enroll = student enrolled into section<br/>
 * Withdraw = student withdrawn from section<br/>
 * <p>
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
    
    AdOffering findOfferingByCode(String code);

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
    
    boolean isOfferingExists(String canonicalCode);

    void saveOffering(AdOffering offering) ;

    void updateOffering(AdOffering offering);

    void calculateGradebook(AdOffering offering);
       
    void calculateGPA(AdOffering offering);
    

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
     
    Integer countSection(String canonicalCode);

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

    @Deprecated
    void saveSection(AdSection section); // use addSection

    void addSection(AdOffering offering, AdSection section);

    void deleteSection(AdOffering offering, AdSection section);


    void updateSection(AdOffering offering, AdSection section);

    void removeSection(AdOffering offering, AdSection section);


    //====================================================================================================
    // ASSESSMENT
    //====================================================================================================

    AdAssessment findAssessmentById(Long id);

    AdAssessment findAssessmentByCanonicalCode(String canonicalCode);

    AdAssessment findAssessmentByCodeAndOffering(String code, AdOffering offering);

    List<AdAssessment> findAssessments(AdOffering offering);

    List<AdAssessment> findAssessments(Integer offset, Integer limit);

    List<AdAssessment> findAssessments(AdOffering offering, Integer offset, Integer limit);

    Integer countAssessment(AdOffering offering);

    Integer countAssessment(AdOffering offering, AdAssessmentType type);

    boolean hasAssessment(AdOffering offering);

    boolean isAssessmentExists(String code, AdOffering offering);

    boolean isAssessmentExists(String canonicalCode);

    void initAssessment(AdOffering offering, AdAssessment assessment); // todo: throws AssessmentException;

    void addAssessment(AdOffering offering, AdAssessment assessment);

    void updateAssessment(AdOffering offering, AdAssessment assessment);

    void deleteAssessment(AdOffering offering, AdAssessment assessment);

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
    
    void updateAdmissionApplication(AdStudent student, AdAdmissionApplication application, AdAdmission admission);

    void cancelAdmissionApplication(AdAdmissionApplication application);

    void postToAdmission(AdAdmissionApplication application);

    void saveAdmissionApplication(AdAdmissionApplication application);


    // finder


    AdAdmissionApplication findAdmissionApplicationById(Long id);

    AdAdmissionApplication findAdmissionApplicationByReferenceNo(String referenceNo);

    AdAdmissionApplication findAdmissionApplicationByProgramAndStudent(AdProgram program, AdStudent student);

    List<AdAdmissionApplication> findAdmissionApplicationsByFlowState(AdFlowState flowState);

    List<AdAdmissionApplication> findAdmissionApplicationsByFlowStates(AdFlowState... flowStates);

    List<AdAdmissionApplication> findAdmissionApplications(AdAcademicSession session);
    
    List<AdAdmissionApplication> findAdmissionApplications(AdStudent student);
    
    List<AdAdmissionApplication> findAdmissionApplications(AdStaff staff);

    List<AdAdmissionApplication> findAdmissionApplications(AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdAdmissionApplication> findAdmissionApplications(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

    Integer countAdmissionApplication(AdAcademicSession session);

    Integer countAdmissionApplication(String filter, AdAcademicSession session);

    Integer countAdmissionApplication(String filter, AdAcademicSession session, AdStudent student);
    
    Integer countAdmissionApplication(AdAcademicSession session, AdStudent student);

    Integer countAdmissionApplication(String filter, AdAcademicSession session, AdStaff staff);

    //====================================================================================================
    // ADMISSION
    //====================================================================================================

    AdAdmission findAdmissionById(Long id);

    AdAdmission findAdmissionByAcademicSessionCohortAndStudent(AdAcademicSession academicSession, AdCohort cohort, AdStudent student);

    List<AdAdmission> findAdmissions(Integer offset, Integer limit);
    
    List<AdAdmission> findAdmissions(AdStudent student);
    
    List<AdAdmission> findAdmissions(AdStudent student, Integer offset, Integer limit);

    List<AdAdmission> findAdmissions(AdAcademicSession academicSession, Integer offset, Integer limit);
    
    List<AdAdmission> findAdmissions(AdAcademicSession academicSession);
    
    List<AdAdmission> findAdmissions(AdAcademicSession academicSession, AdStudent student);

    Integer countAdmission(AdAcademicSession academicSession, AdStudent student);

    void admit(AdAcademicSession academicSession, AdStudent student, AdStudyCenter studyCenter, AdProgram program, AdStaff advisor);

    void admit(AdAcademicSession session, AdStudent student, AdStudyCenter studyCenter, AdProgram program,
			Integer ordinal, AdStaff advisor);
    
    void saveAdmission(AdAdmission admission);

    void updateAdmission(AdAdmission admission);
    
    void updateAdmission(AdStudent student, AdAdmissionApplication application);
    
    void updateAdmission(AdStudent student, AdAdmission admission);

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
    
    Integer countEnrollmentApplication(AdAdmission admission);

    String startEnrollmentApplicationTask(AdEnrollmentApplication application);

    void updateEnrollmentApplication(AdEnrollmentApplication application);

    void cancelEnrollmentApplication(AdEnrollmentApplication application);

    void addEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void updateEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void deleteEnrollmentApplicationItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item);

    void postToEnrollment(AdEnrollmentApplication application);
    
    void removeEnrollmentApplication(AdAdmission admission, AdEnrollmentApplication application);

    //====================================================================================================
    // ENROLLMENT APPLICATION
    //====================================================================================================

    AdEnrollmentApplication findEnrollmentApplicationById(Long id);

    AdEnrollmentApplication findEnrollmentApplicationByReferenceNo(String referenceNo);

    AdEnrollmentApplicationItem findEnrollmentApplicationItemById(Long id);

    AdEnrollmentApplicationItem findEnrollmentApplicationItemBySection(AdSection section);

    List<AdEnrollmentApplication> findEnrollmentApplicationsByFlowState(AdFlowState flowState);

    List<AdEnrollmentApplication> findEnrollmentApplicationsByFlowStates(AdFlowState... flowStates);

    List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session);

    List<AdEnrollmentApplication> findEnrollmentApplications(AdAdmission admission);

    List<AdEnrollmentApplication> findEnrollmentApplications(AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdEnrollmentApplication> findEnrollmentApplications(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

    List<AdEnrollmentApplicationItem> findEnrollmentApplicationItems(AdEnrollmentApplication application);

    Integer countEnrollmentApplication(AdAcademicSession session);

    Integer countEnrollmentApplication(String filter, AdAcademicSession session);

    Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStudent student);

    Integer countEnrollmentApplication(String filter, AdAcademicSession session, AdStaff staff);

    boolean isEnrollmentApplicationItemExists(AdEnrollmentApplication application, AdSection section);
    
    //====================================================================================================
    // ENROLLMENT
    //====================================================================================================

    AdEnrollment findEnrollmentById(Long id);

    AdEnrollment findEnrollmentBySectionAndStudent(AdSection section, AdStudent student);

    AdEnrollment findEnrollmentByMatricNoAndOffering(String matricNo, AdOffering offering);

    List<AdEnrollment> findEnrollments(Integer offset, Integer limit);

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
    void enroll(boolean override, AdSection section, AdAdmission admission); // throws

    void withdraw(boolean override, AdSection section, AdAdmission admission); // throws

    // todo(uda): business method is enroll()
    @Deprecated
    void saveEnrollment(AdEnrollment enrollment);

    void updateEnrollment(AdEnrollment enrollment);

//    todo(sam/syikin) Remove?
//    void updateEnrollment(AdSection section, AdEnrollment enrollment);

    void deleteEnrollment(AdEnrollment enrollment);

    void addGradebook(AdSection section, AdEnrollment enrollment, AdGradebook gradebook);

    @Deprecated
    void addGradebook(AdSection section, AdAssessment assessment);

    //====================================================================================================
    // APPOINTMENT
    //====================================================================================================

    AdAppointment findAppointmentById(Long id);

    AdAppointment findAppointmentBySectionAndStaff(AdSection section, AdStaff staff);
    
    AdAppointment findAppointmentByStaff(AdStaff staff);

    List<AdAppointment> findAppointments(AdOffering offering);

    List<AdAppointment> findAppointments(AdSection section);
    
    List<AdAppointment> findAppointments(AdStaff staff);

    List<AdAppointment> findAppointments(AdAcademicSession academicSession);

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
    @Deprecated
    void saveAppointment(AdAppointment appointment); //use addAppointment

    void addAppointment(AdSection section, AdAppointment appointment);

    //void updateAppointment(AdAppointment appointment);

    void updateAppointment(AdSection section, AdAppointment appointment);

    void removeAppointment(AdSection section, AdAppointment appointment);

    void deleteAppointment(AdAppointment appointment);

    //====================================================================================================
    // GRADEBOOK
    //====================================================================================================

    AdGradebook findGradebookById(Long id);

    AdGradebook findGradebookByAssessmentAndEnrollment(AdAssessment assessment, AdEnrollment enrollment);

    List<AdGradebook> findGradebooks(AdEnrollment enrollment);

    List<AdGradebook> findGradebooks(AdOffering offering);

    List<AdGradebook> findGradebooks(AdOffering offering, Integer offset, Integer limit);

    List<AdGradebook> findGradebooks(AdSection section);

    List<AdGradebook> findGradebooks(AdSection section, AdAssessment assessment);

    List<AdGradebook> findGradebooks(AdSection section, Integer offset, Integer limit);

    List<AdGradebook> findGradebooks(AdSection section, AdAssessment assessment, Integer offset, Integer limit);

    List<AdGradebook> findGradebooks(AdAssessment assessment);

    List<AdGradebook> findGradebooks(AdAssessment assessment, Integer offset, Integer limit);

    Integer countGradebook(AdSection section, AdAssessment assessment);

    boolean isGradebookExists(AdAssessment assessment, AdEnrollment enrollment);

    boolean hasGradebook(AdSection section, AdAssessment assessment);

    void saveGradebook(AdGradebook gradebook);

    void updateGradebook(AdGradebook gradebook);

    void deleteGradebook(AdGradebook gradebook);

    BigDecimal normalizeGradebooks(AdEnrollment enrollment);
    
    void admit(AdAcademicSession session, AdStudent student, AdStudyCenter studyCenter, AdProgram program,
			Integer ordinal);

	void updateAdmissionApplication(AdStudent student, AdAdmissionApplication application);

}
