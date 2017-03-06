package my.edu.umk.pams.academic.offering.model;

import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdEnrollmentApplication extends AdDocument {

    // TODO: removed
    AdEnrollmentApplicationType getType();

    void setType(AdEnrollmentApplicationType type);

    AdStudent getStudent();

    void setStudent(AdStudent student);

    AdAdmission getAdmission();

    void setAdmission(AdAdmission admission);

    AdStaff getAdvisor();

    void setAdvisor(AdStaff advisor);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);

    List<AdEnrollmentApplicationItem> getItems();

    void setItems(List<AdEnrollmentApplicationItem> items);

}
