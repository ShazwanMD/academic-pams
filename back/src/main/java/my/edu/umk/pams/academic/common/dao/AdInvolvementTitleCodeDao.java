package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdInvolvementTitleCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdInvolvementTitleCodeDao extends GenericDao<Long, AdInvolvementTitleCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdInvolvementTitleCode findByCode(String code);

    List<AdInvolvementTitleCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
