package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdInvolvementTypeCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdInvolvementTypeCodeDao extends GenericDao<Long, AdInvolvementTypeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdInvolvementTypeCode findByCode(String code);

    List<AdInvolvementTypeCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
