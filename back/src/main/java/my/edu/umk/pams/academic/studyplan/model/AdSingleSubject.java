package my.edu.umk.pams.academic.studyplan.model;

/**
 * @author rafizan.baharum@canang.com.my
 */
public interface AdSingleSubject extends AdSubject {

    AdCourse getCourse();

    void setCourse(AdCourse course);
}
