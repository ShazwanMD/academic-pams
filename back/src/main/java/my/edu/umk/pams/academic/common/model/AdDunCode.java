package my.edu.umk.pams.academic.common.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdDunCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);
}
