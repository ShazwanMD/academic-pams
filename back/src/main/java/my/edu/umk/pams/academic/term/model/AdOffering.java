package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdProgram;

import java.util.List;

/**
 * Offering canonical Code
 * <PROGRAM>/<COURSE>/<ACADMIC_SESSION>
 * @author PAMS
 */
public interface AdOffering extends AdMetaObject {

    // alias
    String getCode();

    void setCode(String code);

    String getCanonicalCode();

    void setCanonicalCode(String canonicalCode);

    String getTitleMs();

    void setTitleMs(String titleMs);

    String getTitleEn();

    void setTitleEn(String titleEn);

    Integer getCapacity();

    void setCapacity(Integer capacity);

    AdProgram getProgram();

    void setProgram(AdProgram program);

    AdCourse getCourse();

    void setCourse(AdCourse course);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);

    List<AdSection> getSections();

    void setSections(List<AdSection> sections);

    // transient

    Integer getSectionCount();

    void setSectionCount(Integer sectionCount);

    Integer getAssessmentCount();

    void setAssessmentCount(Integer assessmentCount);
}
