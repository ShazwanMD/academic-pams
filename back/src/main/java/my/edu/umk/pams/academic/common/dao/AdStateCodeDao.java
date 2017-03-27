package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdStateCodeDao extends GenericDao<Long, AdStateCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdStateCode findByCode(String code);

    List<AdStateCode> find(String filter, Integer offset, Integer limit);

    List<AdStateCode> find(AdCountryCode countryCode, Integer offset, Integer limit);

    List<AdStateCode> find(String filter, AdCountryCode countryCode, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    Integer count(AdCountryCode countryCode);

    Integer count(String filter, AdCountryCode countryCode);

    boolean isExists(String code);


}
