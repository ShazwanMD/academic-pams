package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdInvolvementLevelCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdInvolvementLevelCodeDao extends GenericDao<Long, AdInvolvementLevelCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdInvolvementLevelCode findByCode(String code);

    List<AdInvolvementLevelCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
