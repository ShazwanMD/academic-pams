package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdDisabilityCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdDisabilityCodeDao extends GenericDao<Long, AdDisabilityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdDisabilityCode findByCode(String code);

    List<AdDisabilityCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
