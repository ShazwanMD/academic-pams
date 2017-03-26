package my.edu.umk.pams.academic.planner.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author PAMS
 */
public interface AdCourseMember extends AdMetaObject {

    AdCourse getCourse();

    void setCourse(AdCourse course);

    AdCourse getMember();

    void setMember(AdCourse course);
}
