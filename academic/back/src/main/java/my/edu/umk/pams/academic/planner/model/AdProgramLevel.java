package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * DIPLOMA
 * FOUNDATION
 * DEGREE
 * MASTER
 * PHD
 * OTHERS
 *
 * @author PAMS
 */
public interface AdProgramLevel extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);
    
    AdProgramType getType();

    void setType(AdProgramType  type);


}
