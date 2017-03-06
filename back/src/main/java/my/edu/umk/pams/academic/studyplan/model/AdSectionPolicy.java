package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdSectionPolicy extends AdMetaObject {

    AdSection getSection();

    void setSection(AdSection section);

    AdFaculty getFaculty();

    void setFaculty(AdFaculty faculty);
}
