package my.edu.umk.pams.academic.planner.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdSubject extends AdMetaObject {

    AdSubjectType getSubjectType();

    void setSubjectType(AdSubjectType subjectType);

    Integer getOrdinal();

    void setOrdinal(Integer ordinal);

    AdCurriculum getCurriculum();

    void setCurriculum(AdCurriculum curriculum);

}
