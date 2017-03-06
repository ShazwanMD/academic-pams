package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
@Entity(name = "AdAssessment")
@Table(name = "AD_ASMT")
public class AdAssessmentImpl implements AdAssessment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ASMT")
    @SequenceGenerator(name = "SQ_AD_ASMT", sequenceName = "SQ_AD_ASMT", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "CANONICAL_CODE", nullable = false, unique = true)
    private String canonicalCode;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "TOTAL_SCORE", nullable = false)
    private BigDecimal totalScore = BigDecimal.ZERO;

    @Column(name = "WEIGHT", nullable = false)
    private BigDecimal weight = BigDecimal.ZERO;

    @Column(name = "ORDINAL", nullable = false)
    private Integer ordinal = 0;

    @Column(name = "TYPE", nullable = false)
    private AdAssessmentType type;

    @Column(name = "CATEGORY", nullable = false)
    private AdAssessmentCategory category;

    @ManyToOne(targetEntity = AdOfferingImpl.class)
    @JoinColumn(name = "OFFERING_ID")
    private AdOffering offering;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

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
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getCanonicalCode() {
        return canonicalCode;
    }

    @Override
    public void setCanonicalCode(String canonicalCode) {
        this.canonicalCode = canonicalCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BigDecimal getTotalScore() {
        return totalScore;
    }

    @Override
    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public Integer getOrdinal() {
        return ordinal;
    }

    @Override
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public AdAssessmentType getType() {
        return type;
    }

    @Override
    public void setType(AdAssessmentType type) {
        this.type = type;
    }

    @Override
    public AdAssessmentCategory getCategory() {
        return category;
    }

    @Override
    public void setCategory(AdAssessmentCategory category) {
        this.category = category;
    }

    @Override
    public AdOffering getOffering() {
        return offering;
    }

    @Override
    public void setOffering(AdOffering offering) {
        this.offering = offering;
    }

    @Override
    public AdAcademicSession getSession() {
        return session;
    }

    @Override
    public void setSession(AdAcademicSession session) {
        this.session = session;
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
        return AdAssessment.class;
    }
}
