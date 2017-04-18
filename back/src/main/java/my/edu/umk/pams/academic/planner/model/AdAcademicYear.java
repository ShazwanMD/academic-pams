package my.edu.umk.pams.academic.planner.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdAcademicYear extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    String getYear();

    void setYear(String year);
}
