package my.edu.umk.pams.academic.profile.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAdmissionDao extends GenericDao<Long, AdAdmission> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAdmission findBySessionProgramAndStudent(AdAcademicSession academicSession, AdProgram program, AdStudent student);

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

    Integer countStudent(AdProgram program);

    boolean isExists(AdProgram program, AdStudent student);

    boolean hasAdmission(AdProgram program);

    Integer count(String filter, AdStudent student, AdAcademicSession academicSession);

}
