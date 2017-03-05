package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdSchoolCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdSchoolCodeDao extends GenericDao<Long, AdSchoolCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdSchoolCode findByCode(String code);

    List<AdSchoolCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
