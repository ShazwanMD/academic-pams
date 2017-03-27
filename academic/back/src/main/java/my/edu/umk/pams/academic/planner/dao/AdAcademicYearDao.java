package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.planner.model.AdAcademicYear;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAcademicYearDao extends GenericDao<Long, AdAcademicYear> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAcademicYear findByCode(String code);

    List<AdAcademicYear> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isCodeExists(String code);

}
