package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * EXAMPLE: KEJURUTERAAN, SAINS SOSIAL, PERAKAUNAN
 **/
public interface AdFieldCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);
}
