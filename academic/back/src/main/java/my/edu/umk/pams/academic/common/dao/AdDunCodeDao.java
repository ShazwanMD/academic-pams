package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdDunCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdDunCodeDao extends GenericDao<Long, AdDunCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdDunCode findByCode(String code);

    List<AdDunCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
