package my.edu.umk.pams.academic.offering.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.offering.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAdmissionApplicationDao extends GenericDao<Long, AdAdmissionApplication> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAdmissionApplication findByReferenceNo(String referenceNo);

    List<AdAdmissionApplication> find(AdAcademicSession session);

    List<AdAdmissionApplication> find(AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit);

    List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit);

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
}
