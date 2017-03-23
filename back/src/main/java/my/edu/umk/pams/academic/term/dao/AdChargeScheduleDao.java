package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicPeriod;
import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdChargeScheduleDao extends GenericDao<Long, AdChargeSchedule> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdChargeSchedule findByCode(String code);

    AdChargeSchedule find(AdAcademicPeriod period, AdCohort cohortCode, AdProgram programCode);

    List<AdChargeSchedule> find(AdProgram programCode);

    List<AdChargeSchedule> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(AdProgram program);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

}
