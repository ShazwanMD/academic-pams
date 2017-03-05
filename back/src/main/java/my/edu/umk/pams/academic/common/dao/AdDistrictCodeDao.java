package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdDistrictCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdDistrictCodeDao extends GenericDao<Long, AdDistrictCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdDistrictCode findByCode(String code);

    List<AdDistrictCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
