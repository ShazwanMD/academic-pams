package my.edu.umk.pams.academic.term.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.planner.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdSectionDao extends GenericDao<Long, AdSection> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdSection findByCodeAndSessionAndOffering(String code, AdAcademicSession academicSession, AdOffering offering);

    AdSection findByCanonicalCode(String canonicalCode);

    AdSectionPolicy findPolicyById(Long id);

    List<AdSection> find(AdOffering offering);

    List<AdSection> find(AdOffering offering, Integer offset, Integer limit);

    List<AdSection> find(String filter, AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdSection> find(AdAcademicSession academicSession);

    List<AdSection> find(AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdSection> find(AdAcademicSession academicSession, AdOffering offering);

    List<AdSection> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdSection> find(String filter, AdAcademicSession academicSession, AdAdmission admission, Integer offset, Integer limit);

    List<AdSectionPolicy> findPolicies(AdSection section);

    List<AdSectionPolicy> findPolicies(AdSection section, Integer offset, Integer limit);

    List<AdEnrollment> findEnrollments(AdSection section);

    List<AdEnrollment> findEnrollments(AdSection section, Integer offset, Integer limit);

    List<AdAppointment> findAppointments(AdOffering offering);

    List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdOffering offering);

    List<AdAppointment> findAppointments(AdCourse course);

    List<AdAppointment> findAppointments(AdSection section);

    List<AdAppointment> findAppointments(AdSection section, Integer offset, Integer limit);

    List<AdStudent> findStudents(AdSection section);

    List<AdStudent> findStudents(AdSection section, Integer offset, Integer limit);

    List<AdStaff> findStaffs(AdSection section);

    List<AdStaff> findStaffs(AdSection section, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter, AdAcademicSession academicSession);

    Integer count(AdOffering offering);

    Integer count(AdCourse course);

    Integer count(AdAcademicSession academicSession);

    Integer count(AdAcademicSession academicSession, AdOffering offering);

    Integer count(AdAcademicSession academicSession, AdCourse course);

    Integer count(String filter, AdAcademicSession academicSession, AdAdmission admission);

    Integer countStudent(AdSection section);

    Integer countAvailableStudent(AdOffering offering);

    Integer countAvailableStudent(AdCourse course);

    Integer countAvailableStudent(String filter, AdOffering offering);

    Integer countAvailableStudent(String filter, AdCourse course);

    Integer countAvailableStaff(AdOffering offering);

    Integer countAvailableStaff(AdCourse course);

    Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering);

    Integer countPolicy(AdSection section);

    Integer countEnrollment(AdSection section);

    Integer countAppointment(AdSection section);

    boolean hasSection(AdAcademicSession academicSession);

    boolean hasSection(AdAcademicSession academicSession, AdOffering offering);

    boolean isExists(String canonicalCode);

    boolean isAppointmentExists(AdSection section, AdStaff staff);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addPolicy(AdSection section, AdSectionPolicy policy, AdUser user);

    void updatePolicy(AdSection section, AdSectionPolicy policy, AdUser user);

    void deletePolicy(AdSection section, AdSectionPolicy policy, AdUser user);

    void addEnrollment(AdSection section, AdEnrollment enrollment, AdUser user);

    void updateEnrollment(AdSection section, AdEnrollment enrollment, AdUser user);

    void deleteEnrollment(AdSection section, AdEnrollment enrollment, AdUser user);

    void addAppointment(AdSection section, AdAppointment appointment, AdUser user);

    void updateAppointment(AdSection section, AdAppointment appointment, AdUser user);

    void deleteAppointment(AdSection section, AdAppointment appointment, AdUser user);

}
