package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.term.model.AdEnrollmentApplicationItem;
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

    List<AdEnrollmentApplication> find(AdAcademicSession session);

    List<AdEnrollmentApplication> find(AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdEnrollmentApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

    List<AdEnrollmentApplicationItem> findItems(AdEnrollmentApplication intake);

    List<AdEnrollmentApplicationItem> findItems(AdEnrollmentApplication intake, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================


    Integer count(AdAcademicSession session);

    Integer count(String filter, AdAcademicSession session);

    Integer count(String filter, AdAcademicSession session, AdStudent student);

    Integer count(String filter, AdAcademicSession session, AdStaff advisor);


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    void addItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user);

    void updateItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user);

    void deleteItem(AdEnrollmentApplication application, AdEnrollmentApplicationItem item, AdUser user);

}
