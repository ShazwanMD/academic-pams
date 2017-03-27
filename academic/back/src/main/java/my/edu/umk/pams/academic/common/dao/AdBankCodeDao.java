package my.edu.umk.pams.academic.common.dao;


import my.edu.umk.pams.academic.common.model.AdBankCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdBankCodeDao extends GenericDao<Long, AdBankCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdBankCode findByCode(String code);

    List<AdBankCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
