package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdBundleSubjectPart extends AdMetaObject {

    AdBundleSubject getBundle();

    void setBundle(AdBundleSubject bundle);

    AdCourse getCourse();

    void setCourse(AdCourse course);
}
