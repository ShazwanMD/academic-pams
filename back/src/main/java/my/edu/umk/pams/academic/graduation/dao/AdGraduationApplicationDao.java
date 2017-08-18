package my.edu.umk.pams.academic.graduation.dao;


import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;

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

    List<AdGraduationApplication> findByFlowStates(AdFlowState... flowStates);
    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdAcademicSession academicSession);

}
