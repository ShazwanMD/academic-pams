package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdAddressType;

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
