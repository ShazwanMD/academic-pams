package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.studyplan.model.AdIntakeCode;

import java.util.List;

/**
 * @author team utamacad
 */
public interface AdIntakeCodeDao extends GenericDao<Long, AdIntakeCode> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdIntakeCode findByCode(String code);

    List<AdIntakeCode> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    Integer count(String filter);

    boolean isExists(String code);
}
