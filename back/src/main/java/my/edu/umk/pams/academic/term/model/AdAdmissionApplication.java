package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.web.module.identity.vo.Actor;

/**
 *
 * TODO: type DAFTAR, TANGGUH, BATAL, SUSPEND
 * TODO: reason: sakit, cuti etc etc
 *
 * TODO: isProxied
 *
 * @author PAMS
 */
public interface AdAdmissionApplication extends AdDocument {

    String getReferenceNo ();
    
    void setReferenceNo(String referenceNo);

    String getSourceNo ();
    
    void setSourceNo(String sourceNo);

    String getAuditNo ();
    
    void setAuditNo(String auditNo);

    String getDescription ();

    void setDescription(String description);
    
    String getRemoveComment ();

    void setRemoveComment(String removeComment);
    
    String getCancelComment ();
    
    void setCancelComment(String cancelComment);
    
	AdStudent getStudent();

    void setStudent(AdStudent student);

//    AdStaff getAdvisor();
//
//    void setAdvisor(AdStaff advisor);
    
    AdActor getActor();

	void setActor(AdActor advisor); 

    AdProgram getProgram();

    void setProgram(AdProgram program);

    AdStudyCenter getStudyCenter();

    void setStudyCenter(AdStudyCenter studyCenter);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);
}
