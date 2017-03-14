package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdSubject")
@Table(name = "AD_SBJT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AdSubjectImpl implements AdSubject {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_CNG_SBJT")
    @SequenceGenerator(name = "SQ_CNG_SBJT", sequenceName = "SQ_CNG_SBJT", allocationSize = 1)
    private Long id;

    @Column(name = "SUBJECT_TYPE", nullable = false)
    private AdSubjectType subjectType;

    @Column(name = "PERIOD", nullable = false)
    private AdAcademicPeriod period;

    @ManyToOne(targetEntity = AdCurriculumImpl.class)
    @JoinColumn(name = "CURRICULUM_ID", nullable = false)
    private AdCurriculum curriculum;

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
    public AdSubjectType getSubjectType() {
        return subjectType;
    }

    @Override
    public void setSubjectType(AdSubjectType subjectType) {
        this.subjectType = subjectType;
    }

    @Override
    public AdAcademicPeriod getPeriod() {
        return period;
    }

    @Override
    public void setPeriod(AdAcademicPeriod period) {
        this.period = period;
    }

    @Override
    public AdCurriculum getCurriculum() {
        return curriculum;
    }

    @Override
    public void setCurriculum(AdCurriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }
}
