package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCompetencyCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdCompetencyCodeDao extends GenericDao<Long, AdCompetencyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdCompetencyCode findByCode(String code);

    List<AdCompetencyCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
