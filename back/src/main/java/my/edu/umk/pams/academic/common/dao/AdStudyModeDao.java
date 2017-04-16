package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdStudyModeDao extends GenericDao<Long, AdStudyMode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdStudyMode findByCode(String code);

    List<AdStudyMode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
