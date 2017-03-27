package my.edu.umk.pams.academic.planner.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author PAMS
 */
@Entity(name = "AdSingleSubject")
@Table(name = "AD_SNGL_SBJT")
public class AdSingleSubjectImpl extends AdSubjectImpl implements AdSingleSubject {

    @ManyToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    private AdCourse course;

    @Override
    public AdCourse getCourse() {
        return course;
    }

    @Override
    public void setCourse(AdCourse course) {
        this.course = course;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdSingleSubject.class;
    }
}
