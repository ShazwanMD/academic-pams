package my.edu.umk.pams.academic.planner.model;

/**
 * @author PAMS
 */
public interface AdSingleSubject extends AdSubject {

    AdCourse getCourse();

    void setCourse(AdCourse course);
}
