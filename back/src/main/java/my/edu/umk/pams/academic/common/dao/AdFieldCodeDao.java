package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdFieldCode;
import my.edu.umk.pams.academic.core.GenericDao;

import java.util.List;

public interface AdFieldCodeDao extends GenericDao<Long, AdFieldCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdFieldCode findByCode(String code);

    List<AdFieldCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================
    Integer count(String filter);

    boolean isExists(String code);

}
