package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.term.model.AdOffering;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdProgram extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getTitleEn();

    void setTitleEn(String titleEn);

    String getTitleMs();

    void setTitleMs(String titleMs);
    
    AdProgramStatus getStatus();

    void setStatus(AdProgramStatus status);

    AdProgramLevel getLevel();

    void setLevel(AdProgramLevel level);

    AdFaculty getFaculty();

    void setFaculty(AdFaculty faculty);

    List<AdOffering> getOfferings();

    void setOfferings(List<AdOffering> offerings);



}
