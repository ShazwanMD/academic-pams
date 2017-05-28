package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdContact;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdAssessmentType;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAssessmentDao extends GenericDao<Long, AdAssessment> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    AdAssessment findAssessmentById(Long id);
	
	AdAssessment findByCanonicalCode(String canonicalCode);

    AdAssessment findByCodeAndOffering(String code, AdOffering offering);

    List<AdAssessment> find(AdOffering offering);

    List<AdAssessment> find(AdOffering offering, Integer offset, Integer limit);

    List<AdAssessment> find(String filter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(String filter);

    Integer count(AdOffering offering);

    Integer count(AdOffering offering, AdAssessmentType type);

    boolean isExists(String code, AdOffering offering);

    boolean isExists(String canonicalCode);

    boolean hasAssessment(AdOffering offering);

    boolean hasGradebook(AdSection section, AdAssessment assessment);
    
    // ====================================================================================================
    // CRUD
    // ====================================================================================================
    
    void addAssessment(AdOffering offering, AdAssessment assessment, AdUser user);

    void updateAssessment(AdOffering offering, AdAssessment assessment, AdUser user);

    void deleteAssessment(AdOffering offering, AdAssessment assessment, AdUser user);

}
