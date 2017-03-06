package my.edu.umk.pams.academic.studyplan.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdSubject extends AdMetaObject {

    AdSubjectType getSubjectType();

    void setSubjectType(AdSubjectType subjectType);

    AdAcademicPeriod getPeriod();

    void setPeriod(AdAcademicPeriod period);

    AdCurriculum getCurriculum();

    void setCurriculum(AdCurriculum curriculum);

}
