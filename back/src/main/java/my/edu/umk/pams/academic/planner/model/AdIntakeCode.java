package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdIntakeCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

}
