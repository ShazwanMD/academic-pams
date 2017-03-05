package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdInvolvementLevelCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    AdInvolvementTypeCode getTypeCode();

    void setTypeCode(AdInvolvementTypeCode typeCode);
}
