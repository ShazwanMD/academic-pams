package my.edu.umk.pams.academic.studyplan.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.studyplan.model.AdProgramLevel;

import java.util.List;

public interface AdProgramLevelDao extends GenericDao<Long, AdProgramLevel> {

    // ===================================================================
    // FINDER
    // ===================================================================

    AdProgramLevel findByCode(String code);

    List<AdProgramLevel> find(String filter, Integer offset, Integer limit);

    // ===================================================================
    // HELPER
    // ===================================================================

    Integer count(String filter);

}
