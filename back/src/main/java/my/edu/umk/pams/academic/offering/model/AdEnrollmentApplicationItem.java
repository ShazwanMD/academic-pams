package my.edu.umk.pams.academic.offering.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.studyplan.model.AdSection;

/**
 * @author PAMS
 */
public interface AdEnrollmentApplicationItem extends AdMetaObject {

    AdEnrollmentApplicationAction getAction();

    void setAction(AdEnrollmentApplicationAction action);

    AdSection getSection();

    void setSection(AdSection section);

    AdEnrollmentApplication getApplication();

    void setApplication(AdEnrollmentApplication application);
}
