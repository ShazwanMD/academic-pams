package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.GenericDao;

import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdEnrollmentApplicationDao extends GenericDao<Long, AdEnrollmentApplication> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdEnrollmentApplication findByReferenceNo(String referenceNo);

    AdEnrollmentApplicationItem findItemById(Long id);

    AdEnrollmentApplicationItem findItemBySection(AdSection section);

    List<AdEnrollmentApplication> find(AdAcademicSession session);

    List<AdEnrollmentApplication> find(AdAdmission admission);

    List<AdEnrollmentApplication> find(AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

    
    
    /*List<AdEnrollmentApplication> findByFlowState(AdFlowState flowState);

    List<AdEnrollmentApplication> findByFlowStates(AdFlowState... flowState);*/

   
    List<AdEnrollmentApplication> findByFlowState(AdFlowState flowState);

    List<AdEnrollmentApplication> findByFlowStates(AdFlowState... flowStates);
    
    
    List<AdEnrollmentApplicationItem> findItems(AdEnrollmentApplication intake);

    List<AdEnrollmentApplicationItem> findItems(AdEnrollmentApplication intake, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================


    Integer count(AdAcademicSession session);

    Integer count(String filter, AdAcademicSession session);

    Integer count(String filter, AdAcademicSession session, AdStudent student);

    Integer count(String filter, AdAcademicSession session, AdStaff advisor);
    
    Integer count(AdAdmission admission);
    
    boolean isExists(AdEnrollmentApplication application, AdSection section);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user);

    void updateItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user);

    void deleteItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user);

}
