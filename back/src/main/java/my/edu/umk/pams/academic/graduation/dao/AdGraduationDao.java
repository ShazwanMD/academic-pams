package my.edu.umk.pams.academic.graduation.dao;


import my.edu.umk.pams.academic.core.AdFlowState;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.graduation.model.AdGraduation;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.identity.model.AdGuarantor;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.term.model.AdAdmissionApplication;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdGraduationDao extends GenericDao<Long, AdGraduation> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

	List<AdGraduation> find(AdStudent student);
	
	List<AdGraduation> find(AdAcademicSession academicSession);
	
    /*AdGraduationApplication findByReferenceNo(String referenceNo);
    
    List<AdGraduationApplication> findGraduationApplications(AdStudent student);

    List<AdGraduationApplication> find(AdAcademicSession academicSession, Integer offset, Integer limit);
    
    List<AdGraduationApplication> find(AdStudent student);

    List<AdGraduationApplication> findByFlowStates(AdFlowState... flowStates);*/
    // ====================================================================================================
    // HELPER
    // ====================================================================================================

	Integer count(AdAcademicSession session, AdStudent student);
      
  

}
