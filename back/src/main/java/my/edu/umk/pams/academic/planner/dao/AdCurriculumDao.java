package my.edu.umk.pams.academic.planner.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdCurriculumDao extends GenericDao<Long, AdCurriculum> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdCurriculum findByCode(String code);

    AdCurriculum findLatestByProgram(AdProgram program);

    AdSubject findSubjectById(Long id);

    List<AdCurriculum> find(String filter, Integer offset, Integer limit);

    List<AdCurriculum> find(AdProgram program);

    List<AdCurriculum> find(AdProgram program, Integer offset, Integer limit);

    List<AdSubject> findSubjects(AdCurriculum curriculum);

    List<AdSubject> findSubjects(AdSubjectType subjectType, AdCurriculum curriculum);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(AdProgram program);

    Integer countSubject(AdCurriculum Curriculum);

    boolean isExists(String code);

    boolean isSubjectExists(AdCourse course, AdCurriculum curriculum);

    boolean hasCurriculum(AdProgram program);

    boolean hasSubjects(AdCurriculum curriculum);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addSubject(AdCurriculum curriculum, AdSubject subject, AdUser user);

    void updateSubject(AdCurriculum Curriculum, AdSubject subject, AdUser user);

    void deleteSubject(AdCurriculum Curriculum, AdSubject subject, AdUser user);

    void addSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part, AdUser user);

    void deleteSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part, AdUser user);

}
