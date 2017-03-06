package my.edu.umk.pams.academic.offering.model;


import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.studyplan.model.AdEnrollmentStatus;
import my.edu.umk.pams.academic.studyplan.model.AdSection;

/**
 *
 * @author PAMS
 */
public interface AdEnrollment extends AdMetaObject {

    AdAdmission getAdmission();

    void setAdmission(AdAdmission admission);

    AdStudent getStudent();

    void setStudent(AdStudent student);

    AdSection getSection();

    void setSection(AdSection section);

    AdGradeCode getGradeCode();

    void setGradeCode(AdGradeCode gradeCode);

    AdEnrollmentStatus getStatus();

    void setStatus(AdEnrollmentStatus status);

    AdEnrollmentStanding getStanding();

    void setStanding(AdEnrollmentStanding level);
}
