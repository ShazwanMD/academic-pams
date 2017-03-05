package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdNationalityCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdNationalityCodeDao extends GenericDao<Long, AdNationalityCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdNationalityCode findByCode(String code);

    List<AdNationalityCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);
}
