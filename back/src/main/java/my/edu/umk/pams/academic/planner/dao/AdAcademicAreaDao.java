package my.edu.umk.pams.academic.planner.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.planner.model.AdAcademicArea;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAcademicAreaDao extends GenericDao<Long, AdAcademicArea> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAcademicArea findByCode(String code);

    List<AdAcademicArea> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    Integer count(String filter);

    boolean isCodeExists(String code);
}
