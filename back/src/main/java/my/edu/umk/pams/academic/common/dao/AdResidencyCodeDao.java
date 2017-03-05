package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdResidencyCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdResidencyCodeDao extends GenericDao<Long, AdResidencyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdResidencyCode findByCode(String code);

    List<AdResidencyCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
