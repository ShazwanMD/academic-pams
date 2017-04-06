package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;

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

    AdStudent getStudent();

    void setStudent(AdStudent student);

    AdStaff getAdvisor();

    void setAdvisor(AdStaff advisor);

    AdProgram getProgram();

    void setProgram(AdProgram program);

    AdStudyCenter getStudyCenter();

    void setStudyCenter(AdStudyCenter studyCenter);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);
}
