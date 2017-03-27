package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.planner.model.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
@Entity(name = "AdChargeSchedule")
@Table(name = "AD_CHRG_SCDL")
public class AdChargeScheduleImpl implements AdChargeSchedule {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CHRG_SCDL")
    @SequenceGenerator(name = "SQ_AD_CHRG_SCDL", sequenceName = "SQ_AD_CHRG_SCDL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "PERIOD", nullable = false)
    private AdAcademicPeriod period = AdAcademicPeriod.I;

    @ManyToOne(targetEntity = AdCohortImpl.class)
    @JoinColumn(name = "COHORT_ID")
    private AdCohort cohort;

    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID")
    private AdProgram program;

    @ManyToOne(targetEntity = AdStudyCenterImpl.class)
    @JoinColumn(name = "STUDY_CENTER_ID")
    private AdStudyCenter studyCenter;

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
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
    public AdCohort getCohort() {
        return cohort;
    }

    @Override
    public void setCohort(AdCohort cohort) {
        this.cohort = cohort;
    }

    @Override
    public AdProgram getProgram() {
        return program;
    }

    @Override
    public void setProgram(AdProgram program) {
        this.program = program;
    }

    @Override
    public AdStudyCenter getStudyCenter() {
        return studyCenter;
    }

    @Override
    public void setStudyCenter(AdStudyCenter studyCenter) {
        this.studyCenter = studyCenter;
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
        return AdChargeSchedule.class;
    }
}
