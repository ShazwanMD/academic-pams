package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdProgramCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdProgramCodeDao extends GenericDao<Long, AdProgramCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdProgramCode findByCode(String code);

    AdProgramCode findByUpuCode(String upuCode);

    List<AdProgramCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);

}
