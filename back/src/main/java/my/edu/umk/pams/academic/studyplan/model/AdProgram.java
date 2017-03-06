package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdProgram extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getUpuCode();

    void setUpuCode(String upuCode);

    String getTitle();

    void setTitle(String title);

    String getTitleEn();

    void setTitleEn(String titleEn);

    String getTitleMs();

    void setTitleMs(String titleMs);

    AdProgramType getProgramType();

    void setProgramType(AdProgramType programType);

    AdFaculty getFaculty();

    void setFaculty(AdFaculty faculty);

    List<AdOffering> getOfferings();

    void setOfferings(List<AdOffering> offerings);

}
