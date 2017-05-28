package my.edu.umk.pams.academic.graduation.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdGraduationApplicationDao extends GenericDao<Long, AdGraduationApplication> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdGraduationApplication findByReferenceNo(String referenceNo);

    List<AdGraduationApplication> find(AdAcademicSession academicSession, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdAcademicSession academicSession);

}
