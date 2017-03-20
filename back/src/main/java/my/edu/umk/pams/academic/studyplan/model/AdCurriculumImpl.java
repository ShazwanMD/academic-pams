package my.edu.umk.pams.academic.studyplan.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdCurriculum")
@Table(name = "AD_CRLM")
public class AdCurriculumImpl implements AdCurriculum {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CRLM")
    @SequenceGenerator(name = "SQ_AD_CRLM", sequenceName = "SQ_AD_CRLM", allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "ORDINAL", nullable = false)
    private Integer ordinal;

    // teras fakulti
    @Column(name = "CORE", nullable = false)
    private Integer coreCredit;

    // Teras program/pengkhususan
    @Column(name = "REQUIRED", nullable = false)
    private Integer requiredCredit;

    // elektif/Opsyen
    @Column(name = "ELECTIVE", nullable = false)
    private Integer electiveCredit;

    //Umum Universiti
    @Column(name = "GENERAL", nullable = false)
    private Integer generalCredit;

    // english
    @Column(name = "LANGUAGE", nullable = false)
    private Integer languageCredit;

    // kokurikulum
    @Column(name = "CURRICULUM", nullable = false)
    private Integer curriculumCredit;

    // kredit2 lain
    @Column(name = "OTHERS", nullable = false)
    private Integer othersCredit;

    @Column(name = "TOTAL_CREDIT", nullable = false)
    private Integer totalCredit;

    @Column(name = "PERIOD", nullable = false)
    private Integer period;

    @Column(name = "MAX_PERIOD", nullable = false)
    private Integer maxPeriod;

    @ManyToOne(targetEntity = AdProgramImpl.class)
    @JoinColumn(name = "PROGRAM_ID")
    private AdProgram program;

    @OneToMany(targetEntity = AdCohortImpl.class, mappedBy = "curriculum", fetch = FetchType.LAZY)
    private List<AdCohort> cohorts;

    @OneToMany(targetEntity = AdSubjectImpl.class, mappedBy = "curriculum", fetch = FetchType.LAZY)
    private List<AdSubject> subjects;

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

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Integer getCoreCredit() {
        return coreCredit;
    }

    @Override
    public void setCoreCredit(Integer coreCredit) {
        this.coreCredit = coreCredit;
    }

    @Override
    public Integer getRequiredCredit() {
        return requiredCredit;
    }

    @Override
    public void setRequiredCredit(Integer requiredCredit) {
        this.requiredCredit = requiredCredit;
    }

    @Override
    public Integer getElectiveCredit() {
        return electiveCredit;
    }

    @Override
    public void setElectiveCredit(Integer electiveCredit) {
        this.electiveCredit = electiveCredit;
    }

    @Override
    public Integer getGeneralCredit() {
        return generalCredit;
    }

    @Override
    public void setGeneralCredit(Integer generalCredit) {
        this.generalCredit = generalCredit;
    }

    @Override
    public Integer getLanguageCredit() {
        return languageCredit;
    }

    @Override
    public void setLanguageCredit(Integer languageCredit) {
        this.languageCredit = languageCredit;
    }

    @Override
    public Integer getCurriculumCredit() {
        return curriculumCredit;
    }

    @Override
    public void setCurriculumCredit(Integer curriculumCredit) {
        this.curriculumCredit = curriculumCredit;
    }

    @Override
    public Integer getOthersCredit() {
        return othersCredit;
    }

    @Override
    public void setOthersCredit(Integer othersCredit) {
        this.othersCredit = othersCredit;
    }

    @Override
    public Integer getPeriod() {
        return period;
    }

    @Override
    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public Integer getMaxPeriod() {
        return maxPeriod;
    }

    @Override
    public void setMaxPeriod(Integer maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    @Override
    public Integer getTotalCredit() {
        return totalCredit;
    }

    @Override
    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
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
    public List<AdCohort> getCohorts() {
        return cohorts;
    }

    @Override
    public void setCohorts(List<AdCohort> cohorts) {
        this.cohorts = cohorts;
    }

    @Override
    public List<AdSubject> getSubjects() {
        return subjects;
    }

    @Override
    public void setSubjects(List<AdSubject> subjects) {
        this.subjects = subjects;
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
        return AdCurriculum.class;
    }
}