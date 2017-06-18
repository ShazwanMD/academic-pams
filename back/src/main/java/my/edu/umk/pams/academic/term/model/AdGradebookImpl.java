package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
@Entity(name = "AdGradebook")
@Table(name = "AD_GRBK")
public class AdGradebookImpl implements AdGradebook {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_GRBK")
    @SequenceGenerator(name = "SQ_AD_GRBK", sequenceName = "SQ_AD_GRBK", allocationSize = 1)
    private Long id;

    @Column(name = "SCORE", nullable = false)
    private BigDecimal score = BigDecimal.ZERO;

    @ManyToOne(targetEntity = AdSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private AdSection section;

    @ManyToOne(targetEntity = AdAssessmentImpl.class)
    @JoinColumn(name = "ASSESSMENT_ID")
    private AdAssessment assessment;

    @ManyToOne(targetEntity = AdEnrollmentImpl.class)
    @JoinColumn(name = "ENROLLMENT_ID")
    private AdEnrollment enrollment;

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
    public BigDecimal getScore() {
        return score;
    }

    @Override
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public AdSection getSection() {
        return section;
    }

    @Override
    public void setSection(AdSection section) {
        this.section = section;
    }

    @Override
    public AdAssessment getAssessment() {
        return assessment;
    }

    @Override
    public void setAssessment(AdAssessment assessment) {
        this.assessment = assessment;
    }

    @Override
    public AdEnrollment getEnrollment() {
        return enrollment;
    }

    @Override
    public void setEnrollment(AdEnrollment enrollment) {
        this.enrollment = enrollment;
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
        return AdGradebook.class;
    }
}
