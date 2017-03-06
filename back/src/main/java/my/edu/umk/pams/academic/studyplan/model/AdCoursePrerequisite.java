package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdCoursePrerequisite extends AdMetaObject {

    AdCourse getCourse();

    void setCourse(AdCourse course);

    AdCourse getPrerequisite();

    void setPrerequisite(AdCourse prerequisite);
}
