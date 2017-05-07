package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;

import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdStudyCenterDao extends GenericDao<Long, AdStudyCenter> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdStudyCenter findByCode(String code);

    List<AdStudyCenter> find(String filter, Integer offset, Integer limit);


    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
