package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * hierarchical
 *
 * @author PAMS
 */
public interface AdCohort extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    AdAcademicClassification getClassification();

    void setClassification(AdAcademicClassification classification);

    AdCurriculum getCurriculum();

    void setCurriculum(AdCurriculum curriculum);

    AdProgram getProgram();

    void setProgram(AdProgram program);
}
