package my.edu.umk.pams.academic.studyplan.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdAcademicYear extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
