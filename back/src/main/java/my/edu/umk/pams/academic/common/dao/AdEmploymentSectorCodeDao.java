package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdEmploymentSectorCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdEmploymentSectorCodeDao extends GenericDao<Long, AdEmploymentSectorCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdEmploymentSectorCode findByCode(String code);

    List<AdEmploymentSectorCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
