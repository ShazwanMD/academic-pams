package my.edu.umk.pams.academic.common.dao;


import my.edu.umk.pams.academic.common.model.AdParliamentCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdParliamentCodeDao extends GenericDao<Long, AdParliamentCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdParliamentCode findByCode(String code);

    List<AdParliamentCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
