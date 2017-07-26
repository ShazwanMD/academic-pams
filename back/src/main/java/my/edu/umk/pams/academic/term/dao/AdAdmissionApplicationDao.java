package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAdmissionApplicationDao extends GenericDao<Long, AdAdmissionApplication> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAdmissionApplication findByReferenceNo(String referenceNo);

    AdAdmissionApplication findByProgramAndStudent(AdProgram program, AdStudent student);

    List<AdAdmissionApplication> find(AdAcademicSession session);

    List<AdAdmissionApplication> find(AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit);

    List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStudent student, Integer offset,
                                      Integer limit);

    List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset,
                                      Integer limit);

    List<AdAdmissionApplication> findByFlowState(AdFlowState flowState);

    List<AdAdmissionApplication> findByFlowStates(AdFlowState... flowStates);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdAcademicSession session);

    Integer count(String filter, AdAcademicSession session);

    Integer count(String filter, AdAcademicSession session, AdStudent student);
    
    Integer count(AdAcademicSession session, AdStudent student);

    Integer count(String filter, AdAcademicSession session, AdStaff staff);

    // ====================================================================================================
    // CRUD
    // ====================================================================================================

}
