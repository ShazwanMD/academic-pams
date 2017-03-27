package my.edu.umk.pams.academic.planner.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdCoursePrerequisite")
@Table(name = "AD_CRSE_PQST")
public class AdCoursePrerequisiteImpl implements AdCoursePrerequisite {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CRSE_PQST")
    @SequenceGenerator(name = "SQ_AD_CRSE_PQST", sequenceName = "SQ_AD_CRSE_PQST", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private AdCourse course;

    @ManyToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "PREREQUISITE_ID")
    private AdCourse prerequisite;

    @Embedded
    private AdMetadata metadata;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public AdCourse getCourse() {
        return course;
    }

    @Override
    public void setCourse(AdCourse course) {
        this.course = course;
    }

    @Override
    public AdCourse getPrerequisite() {
        return prerequisite;
    }

    @Override
    public void setPrerequisite(AdCourse prerequisite) {
        this.prerequisite = prerequisite;
    }

    @Override
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdCoursePrerequisite.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdCoursePrerequisiteImpl cngCourse = (AdCoursePrerequisiteImpl) o;

        if (!id.equals(cngCourse.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AdCoursePrerequisiteImpl{" +
                "id=" + id +
                '}';
    }
}