package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCampusCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdCampusCodeDao extends GenericDao<Long, AdCampusCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdCampusCode findByCode(String code);

    List<AdCampusCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
