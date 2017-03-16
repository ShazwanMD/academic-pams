package my.edu.umk.pams.academic.offering.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.offering.model.AdSection;
import my.edu.umk.pams.academic.studyplan.model.AdFaculty;

/**
 * @author PAMS
 */
public interface AdSectionPolicy extends AdMetaObject {

    AdSection getSection();

    void setSection(AdSection section);

    AdFaculty getFaculty();

    void setFaculty(AdFaculty faculty);
}
