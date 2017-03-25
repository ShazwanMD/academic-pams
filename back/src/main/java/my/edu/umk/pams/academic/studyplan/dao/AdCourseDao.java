package my.edu.umk.pams.academic.studyplan.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.studyplan.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdCourseDao extends GenericDao<Long, AdCourse> {
    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdCourse findByCode(String code);

    AdCourse findByCodeAndFaculty(String code, AdFaculty faculty);

    List<AdCourse> find(String filter, Integer offset, Integer limit);

    List<AdCourse> find(AdFaculty faculty);

    List<AdCourse> find(String filter, AdFaculty faculty, Integer offset, Integer limit);

    List<AdCourse> findAvailable(AdAcademicSession academicSession, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(AdFaculty faculty);

    Integer count(String filter, AdFaculty faculty);

    Integer count(AdProgram program);

    boolean isExists(String code, AdFaculty faculty);

    boolean isPrerequisite(AdCourse course, AdCourse prerequisite);

    void addPrerequisites(AdCourse course, AdUser user, AdCourse... prerequisites);
}
