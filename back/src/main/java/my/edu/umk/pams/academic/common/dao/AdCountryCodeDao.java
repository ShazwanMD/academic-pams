package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdCountryCodeDao extends GenericDao<Long, AdCountryCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdCountryCode findByCode(String code);

    List<AdCountryCode> findCountryCodes(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
