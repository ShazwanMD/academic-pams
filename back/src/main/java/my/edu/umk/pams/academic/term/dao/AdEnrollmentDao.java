package my.edu.umk.pams.academic.term.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.planner.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdEnrollmentDao extends GenericDao<Long, AdEnrollment> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdEnrollment findByMatricNoAndOffering(String matricNo, AdOffering offering);

    AdEnrollment findBySectionAndStudent(AdSection section, AdStudent student);

    List<AdEnrollment> find(AdAcademicSession academicSession);

    List<AdEnrollment> find(AdAcademicSession academicSession, AdProgram program);

    List<AdEnrollment> find(AdProgram program);

    List<AdEnrollment> find(AdOffering offering);

    List<AdEnrollment> find(AdSection section);

    List<AdEnrollment> find(AdStudent student);

    List<AdEnrollment> find(AdAcademicSession academicSession, AdOffering offering);

    List<AdEnrollment> find(AdAcademicSession academicSession, AdStudent student);

    List<AdEnrollment> find(AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> find(String filter, AdOffering offering, Integer offset, Integer limit);
    
    List<AdEnrollment> find(AdEnrollmentStatus status, AdOffering offering, Integer offset, Integer limit);


    List<AdEnrollment> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> find(String filter, AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdEnrollment> find(AdSection section, Integer offset, Integer limit);

    List<AdEnrollment> find(String filter, AdSection section, Integer offset, Integer limit);

    List<AdEnrollment> find(AdStudent student, Integer offset, Integer limit);

    List<AdEnrollment> find(AdAdmission admission);
    
    List<AdEnrollment> find(AdAdmission admission, AdEnrollmentStatus status);

    List<AdStudent> findStudents(AdProgram program, Integer offset, Integer limit);

    List<AdStudent> findStudents(AdOffering offering);

    List<AdStudent> findStudents(AdOffering offering, Integer offset, Integer limit);

    List<AdStudent> findStudents(AdSection section);

    List<AdStudent> findStudents(AdSection section, Integer offset, Integer limit);

    List<AdStudent> findAvailableStudents(AdOffering offering);

    List<AdStudent> findAvailableStudents(AdOffering offering, Integer offset, Integer limit);

    List<AdStudent> findAvailableStudents(String filter, AdOffering offering, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdOffering offering);

    Integer count(String filter, AdOffering offering);

    Integer count(AdAcademicSession academicSession, AdOffering offering);

    Integer count(String filter, AdAcademicSession academicSession, AdOffering offering);

    Integer count(AdSection section);

    Integer count(AdEnrollmentStatus status, AdSection section);

    Integer count(String filter, AdSection section);

    Integer count(AdStudent student);

    Integer count(AdAdmission admission);

    Integer countStudent(AdOffering offering);

    Integer countStudent(AdSection section);

    boolean isExists(AdSection section, AdStudent student);

    boolean isAnyExists(AdAcademicSession academicSession, AdOffering offering, AdStudent student);

    boolean hasEnrollment(AdSection section);

}
