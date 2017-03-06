package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdCourseMember")
@Table(name = "AD_CRSE_MMBR")
public class AdCourseMemberImpl implements AdCourseMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CRSE_MMBR")
    @SequenceGenerator(name = "SQ_AD_CRSE_MMBR", sequenceName = "SQ_AD_CRSE_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "COURSE_ID")
    private AdCourse course;

    @OneToOne(targetEntity = AdCourseImpl.class)
    @JoinColumn(name = "MEMBER_ID")
    private AdCourse member;

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
    public AdCourse getMember() {
        return member;
    }

    @Override
    public void setMember(AdCourse member) {
        this.member = member;
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
        return AdCourseMember.class;
    }
}
