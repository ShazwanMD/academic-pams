package my.edu.umk.pams.academic.studyplan.dao;


import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.studyplan.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdProgramDao extends GenericDao<Long, AdProgram> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdProgram findByCode(String code);

    AdProgram findByCodeAndFaculty(String code, AdFaculty faculty);

    List<AdProgram> find(String filter);

    List<AdProgram> find(String filter, Integer offset, Integer limit);

    List<AdProgram> find(String filter, AdFaculty faculty, Integer offset, Integer limit);

    List<AdProgram> find(String filter, AdProgramType type, AdFaculty faculty, Integer offset, Integer limit);

    List<AdProgram> find(AdFaculty faculty);

    List<AdProgram> find(AdProgramType type, AdFaculty faculty);

    List<AdProgram> find(AdFaculty faculty, Integer offset, Integer limit);

    List<AdProgram> find(AdProgramType type, AdFaculty faculty, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(String filter, AdProgramType type);

    Integer count(String filter, AdFaculty faculty);

    Integer count(String filter, AdProgramType type, AdFaculty faculty);

    Integer count(AdFaculty faculty);

    Integer count(AdProgramType type, AdFaculty faculty);

    boolean isExists(String code, AdFaculty faculty);

    boolean hasGrades(AdProgram program);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addOffering(AdProgram program, AdCourse course, AdOffering offering, AdUser user);

    void updateOffering(AdProgram program, AdCourse course, AdOffering offering, AdUser user);

    void removeOffering(AdProgram program, AdCourse course, AdOffering offering, AdUser user);

    void addGradeCode(AdProgram program, AdGradeCode gradeCode, AdUser user);

    void updateGradeCode(AdProgram program, AdGradeCode gradeCode, AdUser user);

    void removeGradeCode(AdProgram program, AdGradeCode gradeCode, AdUser user);
}
