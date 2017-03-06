package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdOffering extends AdMetaObject {

    // alias
    String getCode();

    void setCode(String code);

    String getCanonicalCode();

    void setCanonicalCode(String canonicalCode);

    // TODO: removed??
    String getTitle();

    void setTitle(String title);

    AdProgram getProgram();

    void setProgram(AdProgram program);

    AdCourse getCourse();

    void setCourse(AdCourse course);

    List<AdSection> getSections();

    void setSections(List<AdSection> sections);

    Integer getSectionCount();

    void setSectionCount(Integer sectionCount);

    Integer getAssessmentCount();

    void setAssessmentCount(Integer assessmentCount);
}
