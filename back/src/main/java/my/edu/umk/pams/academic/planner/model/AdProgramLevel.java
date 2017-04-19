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
    
    String getPrefix();

    void setPrefix(String prefix);
    
    AdProgramType getType();

    void setType(AdProgramType  type);


}
