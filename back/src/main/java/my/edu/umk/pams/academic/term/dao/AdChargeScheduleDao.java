package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.term.model.AdChargeSchedule;
import my.edu.umk.pams.academic.planner.model.AdAcademicPeriod;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdChargeScheduleDao extends GenericDao<Long, AdChargeSchedule> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdChargeSchedule findByCode(String code);
    
    AdChargeSchedule findByRefNo(String refNo);

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
