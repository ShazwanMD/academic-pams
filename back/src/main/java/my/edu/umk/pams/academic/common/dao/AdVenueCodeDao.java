package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdVenueCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdVenueCodeDao extends GenericDao<Long, AdVenueCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdVenueCode findByCode(String code);

    List<AdVenueCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
