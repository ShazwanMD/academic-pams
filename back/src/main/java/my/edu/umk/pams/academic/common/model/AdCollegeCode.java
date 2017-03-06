package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdCollegeCode extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    AdStudyCenter getCampusCode();

    void setCampusCode(AdStudyCenter campusCode);

    void setDescription(String description);

}
