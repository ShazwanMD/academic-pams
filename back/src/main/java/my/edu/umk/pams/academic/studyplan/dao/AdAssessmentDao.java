package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.studyplan.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAssessmentDao extends GenericDao<Long, AdAssessment> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAssessment findByCanonicalCode(String canonicalCode);

    AdAssessment findByCodeAndOfferingAndSession(String code, AdAcademicSession academicSession, AdOffering offering);

    List<AdAssessment> find(AdAcademicSession academicSession, AdOffering offering);

    List<AdAssessment> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdAssessment> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(AdAcademicSession academicSession, AdOffering offering);

    Integer count(AdAcademicSession academicSession, AdOffering offering, AdAssessmentType type);

    boolean isExists(String code, AdAcademicSession academicSession, AdOffering offering);

    boolean isExists(String canonicalCode);

    boolean hasAssessment(AdAcademicSession academicSession, AdOffering offering);

    boolean hasGradebook(AdSection section, AdAssessment assessment);

}
