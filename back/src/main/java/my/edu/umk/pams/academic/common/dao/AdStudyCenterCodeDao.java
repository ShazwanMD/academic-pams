package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdStudyCenterCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdStudyCenterCodeDao extends GenericDao<Long, AdStudyCenterCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdStudyCenterCode findByCode(String code);

    List<AdStudyCenterCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
