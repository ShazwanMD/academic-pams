package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCityCode;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdCityCodeDao extends GenericDao<Long, AdCityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdCityCode findByCode(String code);

    List<AdCityCode> find(AdStateCode stateCode);

    List<AdCityCode> find(AdStateCode stateCode, Integer offset, Integer limit);

    List<AdCityCode> find(String filter, AdStateCode stateCode, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdStateCode stateCode);

    Integer count(String filter, AdStateCode stateCode);

    boolean isExists(String code);
}
