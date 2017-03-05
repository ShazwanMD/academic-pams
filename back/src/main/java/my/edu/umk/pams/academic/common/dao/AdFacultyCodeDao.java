package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdFacultyCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdFacultyCodeDao extends GenericDao<Long, AdFacultyCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdFacultyCode findByCode(String code);

    List<AdFacultyCode> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
