package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.math.BigDecimal;
import java.util.List;

public interface AdGradeCodeDao extends GenericDao<Long, AdGradeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdGradeCode findByCode(String code);
    
    AdGradeCode findByScore(BigDecimal score);
    
    List<AdGradeCode> find(String filter, Integer offset, Integer limit);
    
    List<AdGradeCode> find(AdGradeCode grade);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
