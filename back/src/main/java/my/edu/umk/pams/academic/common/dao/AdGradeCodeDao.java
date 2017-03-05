package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdGradeCodeDao extends GenericDao<Long, AdGradeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdGradeCode findByCode(String code);

    List<AdGradeCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
