package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdGenderCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdGenderCodeDao extends GenericDao<Long, AdGenderCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdGenderCode findByCode(String code);

    List<AdGenderCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
