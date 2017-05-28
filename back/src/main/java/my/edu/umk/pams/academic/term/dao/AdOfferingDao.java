package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdOfferingDao extends GenericDao<Long, AdOffering> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdOffering findByCode(String code);

    AdOffering findByCanonicalCode(String code);

    AdOffering findByProgramAndCourse(AdProgram program, AdCourse course);

    AdAcademicSession find(AdAcademicSession academicSession, AdCourse course);

    List<AdOffering> find(String filter, Integer offset, Integer limit);

    List<AdOffering> find(String filter, AdProgram program, Integer offset, Integer limit);

    List<AdOffering> find(String filter, AdAcademicSession academicSession, AdProgram program, Integer offset, Integer limit);

    List<AdOffering> find(AdProgram program);

    List<AdOffering> find(AdProgram program, Integer offset, Integer limit);

    List<AdOffering> find(AdCourse course);

    List<AdOffering> find(AdAcademicSession academicSession);

    List<AdOffering> find(AdCourse course, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(String filter, AdProgram program);

    Integer count(AdProgram program);

    Integer count(AdCourse course);

    Integer countWithSection(String filter);

    Integer countWithSection(String filter, AdAcademicSession academicSession);

    boolean isExists(AdProgram program, AdCourse course);

    boolean isExists(String canonicalCode);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addAssessment(AdOffering offering, AdAssessment assessment, AdUser user);

    void updateAssessment(AdOffering offering, AdAssessment assessment, AdUser user);

    void deleteAssessment(AdOffering offering, AdAssessment assessment, AdUser user);

    void addSection(AdOffering offering, AdSection section, AdUser user);

    void updateSection(AdOffering offering, AdSection section, AdUser user);

    void deleteSection(AdOffering offering, AdSection section, AdUser user);
    
    void removeSection(AdOffering offering, AdSection section, AdUser user);

}
