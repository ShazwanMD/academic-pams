package my.edu.umk.pams.academic.term.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAdmissionDao extends GenericDao<Long, AdAdmission> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

	AdAdmission findById(Long id);
	
	AdAdmission findBySessionCohortAndStudent(AdAcademicSession academicSession, AdCohort cohort, AdStudent student);

    List<AdAdmission> findByProgramAndStudent(AdProgram program, AdStudent student);

    List<AdAdmission> find(AdAcademicSession academicSession);

    List<AdAdmission> find(AdProgram program);

    List<AdAdmission> find(AdStudent student);

    List<AdAdmission> find(AdAcademicSession academicSession, AdStudent student);

    List<AdAdmission> find(AdStudent student, Integer offset, Integer limit);

    List<AdAdmission> find(String filter, AdStudent student, Integer offset, Integer limit);

    List<AdAdmission> find(String filter, AdStudent student, AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdAdmission> find(AdProgram program, Integer offset, Integer limit);

    List<AdAdmission> find(String filter, AdProgram program, Integer offset, Integer limit);

    List<AdStudent> findStudents(AdProgram program);

    List<AdStudent> findStudents(AdProgram program, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdProgram program);

    Integer count(String filter, AdProgram program);

    Integer count(AdStudent student);

    Integer count(String filter, AdStudent student);
    
    Integer count(AdAcademicSession academicSession, AdStudent student);

    Integer countStudent(AdProgram program);

    boolean isExists(AdProgram program, AdStudent student);

    boolean hasAdmission(AdProgram program);

    Integer count(String filter, AdStudent student, AdAcademicSession academicSession);
    
    void removeEnrollmentApplication(AdAdmission admission, AdEnrollmentApplication application, AdUser user);

}
