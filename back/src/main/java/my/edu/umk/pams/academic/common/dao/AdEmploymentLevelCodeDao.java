package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdEmploymentLevelCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdEmploymentLevelCodeDao extends GenericDao<Long, AdEmploymentLevelCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdEmploymentLevelCode findByCode(String code);

    List<AdEmploymentLevelCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
