package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdDependencyCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdDependencyCodeDao extends GenericDao<Long, AdDependencyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdDependencyCode findByCode(String code);

    List<AdDependencyCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
