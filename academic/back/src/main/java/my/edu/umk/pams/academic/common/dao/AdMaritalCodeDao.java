package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdMaritalCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdMaritalCodeDao extends GenericDao<Long, AdMaritalCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdMaritalCode findByCode(String code);

    List<AdMaritalCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
