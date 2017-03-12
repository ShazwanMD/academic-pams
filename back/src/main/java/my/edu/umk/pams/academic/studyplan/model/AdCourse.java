package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.offering.model.AdOffering;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdCourse extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getTitle();

    void setTitle(String title);

    String getTitleEn();

    void setTitleEn(String titleEn);

    String getTitleMs();

    void setTitleMs(String titleMs);

    Integer getCredit();

    void setCredit(Integer credit);

    AdAcademicClassification getClassification();

    void setClassification(AdAcademicClassification classification);

    AdFaculty getFaculty();

    void setFaculty(AdFaculty faculty);

    List<AdCoursePrerequisite> getPrerequisites();

    void setPrerequisites(List<AdCoursePrerequisite> prerequisites);

    List<AdOffering> getOfferings();

    void setOfferings(List<AdOffering> offerings);

}
