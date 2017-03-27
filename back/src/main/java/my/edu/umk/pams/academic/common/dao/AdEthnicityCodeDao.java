package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdEthnicityCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdEthnicityCodeDao extends GenericDao<Long, AdEthnicityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdEthnicityCode findByCode(String code);

    List<AdEthnicityCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
