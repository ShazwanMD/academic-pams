package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

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
