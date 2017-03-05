package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdRaceCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdRaceCodeDao extends GenericDao<Long, AdRaceCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdRaceCode findByCode(String code);

    List<AdRaceCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
