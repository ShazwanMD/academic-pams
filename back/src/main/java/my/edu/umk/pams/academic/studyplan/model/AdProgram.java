package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.offering.model.AdOffering;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdProgram extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getTitle();

    void setTitle(String title);

    String getTitleEn();

    void setTitleEn(String titleEn);

    String getTitleMs();

    void setTitleMs(String titleMs);

    AdProgramLevel getProgramLevel();

    void setProgramLevel(AdProgramLevel programLevel);

    AdFaculty getFaculty();

    void setFaculty(AdFaculty faculty);

    List<AdOffering> getOfferings();

    void setOfferings(List<AdOffering> offerings);

}
