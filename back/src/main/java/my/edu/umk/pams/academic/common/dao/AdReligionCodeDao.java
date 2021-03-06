package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdReligionCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdReligionCodeDao extends GenericDao<Long, AdReligionCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdReligionCode findByCode(String code);

    List<AdReligionCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
