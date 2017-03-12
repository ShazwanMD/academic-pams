package my.edu.umk.pams.academic.offering.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.offering.model.AdEnrollment;
import my.edu.umk.pams.academic.offering.model.AdGradebook;
import my.edu.umk.pams.academic.studyplan.model.AdAssessment;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.studyplan.model.AdSection;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdGradebookDao extends GenericDao<Long, AdGradebook> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdGradebook findByAssessmentAndEnrollment(AdAssessment assessment, AdEnrollment enrollment);

    List<AdGradebook> find(AdEnrollment enrollment);

    List<AdGradebook> find(AdOffering offering);

    List<AdGradebook> find(AdOffering offering, Integer offset, Integer limit);

    List<AdGradebook> find(AdSection section);

    List<AdGradebook> find(AdSection section, AdAssessment assessment);

    List<AdGradebook> find(AdSection section, Integer offset, Integer limit);

    List<AdGradebook> find(AdSection section, AdAssessment assessment, Integer offset, Integer limit);

    List<AdGradebook> find(AdAssessment assessment);

    List<AdGradebook> find(AdAssessment assessment, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdOffering offering);

    Integer count(AdSection section, AdAssessment assessment);

    boolean isExists(AdAssessment assessment, AdEnrollment enrollment);

}
