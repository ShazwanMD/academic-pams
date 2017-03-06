package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdBundleSubjectPart")
@Table(name = "AD_BNDL_SBJT_PART")
public class AdBundleSubjectPartImpl implements AdBundleSubjectPart {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_BNDL_SBJT_PART")
    @SequenceGenerator(name = "SQ_AD_BNDL_SBJT_PART", sequenceName = "SQ_AD_BNDL_SBJT_PART", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = AdBundleSubjectImpl.class)
    @JoinColumn(name = "BUNDLE_ID")
    private AdBundleSubject bundle;

    @OneToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private AdCourse course;

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
    public AdBundleSubject getBundle() {
        return bundle;
    }

    @Override
    public void setBundle(AdBundleSubject bundle) {
        this.bundle = bundle;
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
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdBundleSubjectPart.class;
    }
}
