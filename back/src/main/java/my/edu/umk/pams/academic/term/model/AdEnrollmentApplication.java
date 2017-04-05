package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdEnrollmentApplication extends AdDocument {

    /**
     *
     * @return
     */
    AdEnrollmentApplicationType getType();

    void setType(AdEnrollmentApplicationType type);

    /**
     *
     * @return
     */
    AdStudent getStudent();

    void setStudent(AdStudent student);

    /**
     *
     * @return
     */
    AdAdmission getAdmission();

    void setAdmission(AdAdmission admission);

    /**
     * todo:removed, for UG only
     * @return
     */
    AdStaff getAdvisor();

    void setAdvisor(AdStaff advisor);

    /**
     *
     * @return
     */
    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);

    /**
     *
     * @return
     */
    List<AdEnrollmentApplicationItem> getItems();

    void setItems(List<AdEnrollmentApplicationItem> items);

}
