package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdFaculty;

public interface AdGraduateCenter extends AdMetaObject {
	
    String getCode();

    void setCode(String code);

    String getDescriptionMs();

    void setDescriptionMs(String descriptionMs);

    String getDescriptionEn();

    void setDescriptionEn(String descriptionEn);

}
