package my.edu.umk.pams.academic.studyplan.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSemester;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAcademicSessionDao extends GenericDao<Long, AdAcademicSession> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAcademicSession findByCode(String code);

    AdAcademicSession findCurrentSession();

    AdAcademicSession findNextSession(AdAcademicSession current);

    AdAcademicSession findPreviousSession();

    List<AdAcademicSession> find(String filter, Integer offset, Integer limit);

    List<AdAcademicSession> find(String filter, AdAcademicSemester semester, Integer offset, Integer limit);

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    Integer count(String filter);

    boolean isCodeExists(String code);

    boolean isCurrent();

}
