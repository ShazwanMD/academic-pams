package my.edu.umk.pams.academic.studyplan.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdCohort;
import my.edu.umk.pams.academic.studyplan.model.AdIntakeCode;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdCohortDao extends GenericDao<Long, AdCohort> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdCohort findByCode(String code);

    AdCohort findByCodeAndProgram(String code, AdProgram program);

    AdCohort findByParent(AdCohort parent);

    AdCohort findByProgramAndIntakeCode(AdProgram program, AdIntakeCode intakeCode);

    List<AdCohort> findRoots();

    List<AdCohort> findByProgram(AdProgram program);

    List<AdCohort> find(String filter, Integer offset, Integer limit);

    List<AdCohort> find(AdCohort parent, Integer offset, Integer limit);

    List<AdCohort> find(AdProgram program, Integer offset, Integer limit);

    List<AdCohort> find(String filter, AdProgram program);

    List<AdCohort> find(String filter, AdProgram program, Integer offset, Integer limit);

    List<AdCohort> findGraduated();

    List<AdCohort> findNonGraduated();

    List<AdStudent> findStudents(AdCohort cohort);

    List<AdStudent> findStudents(AdCohort cohort, Integer offset, Integer limit);

    List<AdStudent> findStudents(String filter, AdCohort cohort, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(AdCohort parent);

    Integer count(AdProgram program);

    Integer countStudent(AdCohort cohort);

    Integer countStudent(String filter, AdCohort cohort);

    boolean isExists(String code);
}
