package my.edu.umk.pams.academic.calendar.model;


import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSessionImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author PAMS
 */
@Entity(name = "AdProcessCalendar")
@Table(name = "AD_PRCS_CLDR")
public class AdProcessCalendarImpl implements AdProcessCalendar {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_PRCS_CLDR")
    @SequenceGenerator(name = "SQ_AD_PRCS_CLDR", sequenceName = "SQ_AD_PRCS_CLDR", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ADMISSION_START")
    private Date admissionStart;

    @Column(name = "ADMISSION_END")
    private Date admissionEnd;

    @Column(name = "PRE_ENROLLMENT_START")
    private Date preEnrollmentStart;

    @Column(name = "PRE_ENROLLMENT_END")
    private Date preEnrollmentEnd;

    @Column(name = "MANDATORY_ENROLLMENT_START")
    private Date mandatoryEnrollmentStart;

    @Column(name = "MANDATORY_ENROLLMENT_END")
    private Date mandatoryEnrollmentEnd;

    @Column(name = "PROVISION_ENROLLMENT_START")
    private Date provisionEnrollmentStart;

    @Column(name = "PROVISION_ENROLLMENT_END")
    private Date provisionEnrollmentEnd;

    @Column(name = "LATE_ENROLLMENT_START")
    private Date lateEnrollmentStart;

    @Column(name = "LATE_ENROLLMENT_END")
    private Date lateEnrollmentEnd;

    @Column(name = "GRADUATION_START")
    private Date graduationStart;

    @Column(name = "GRADUATION_END")
    private Date graduationEnd;

    @Column(name = "LATE_GRADUATION_START")
    private Date lateGraduationStart;

    @Column(name = "LATE_GRADUATION_END")
    private Date lateGraduationEnd;

    @Column(name = "FINAL_EXAM_START")
    private Date finalExamStart;

    @Column(name = "FINAL_EXAM_END")
    private Date finalExamEnd;

    @Column(name = "INPUT_FINAL_EXAM_START")
    private Date inputFinalExamStart;

    @Column(name = "INPUT_FINAL_EXAM_END")
    private Date inputFinalExamEnd;

    @Column(name = "APPEAL_FINAL_EXAM_START")
    private Date appealFinalExamStart;

    @Column(name = "APPEAL_FINAL_EXAM_END")
    private Date appealFinalExamEnd;

    @Column(name = "RELEASE_FINAL_EXAM_START")
    private Date releaseFinalExamStart;

    @Column(name = "RELEASE_FINAL_EXAM_END")
    private Date releaseFinalExamEnd;

    @Column(name = "SPECIAL_EXAM_START")
    private Date specialExamStart;

    @Column(name = "SPECIAL_EXAM_END")
    private Date specialExamEnd;

    @Column(name = "INPUT_SPECIAL_EXAM_START")
    private Date inputSpecialExamStart;

    @Column(name = "INPUT_SPECIAL_EXAM_END")
    private Date inputSpecialExamEnd;

    @Column(name = "APPEAL_SPECIAL_EXAM_START")
    private Date appealSpecialExamStart;

    @Column(name = "APPEAL_SPECIAL_EXAM_END")
    private Date appealSpecialExamEnd;

    @Column(name = "RELEASE_SPECIAL_EXAM_START")
    private Date releaseSpecialExamStart;

    @Column(name = "RELEASE_SPECIAL_EXAM_END")
    private Date releaseSpecialExamEnd;

    @Column(name = "PROCESS_TYPE")
    private AdProcessCalendarType processType;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getAdmissionStart() {
        return admissionStart;
    }

    @Override
    public void setAdmissionStart(Date admissionStart) {
        this.admissionStart = admissionStart;
    }

    @Override
    public Date getAdmissionEnd() {
        return admissionEnd;
    }

    @Override
    public void setAdmissionEnd(Date admissionEnd) {
        this.admissionEnd = admissionEnd;
    }

    @Override
    public Date getPreEnrollmentStart() {
        return preEnrollmentStart;
    }

    @Override
    public void setPreEnrollmentStart(Date preEnrollmentStart) {
        this.preEnrollmentStart = preEnrollmentStart;
    }

    @Override
    public Date getPreEnrollmentEnd() {
        return preEnrollmentEnd;
    }

    @Override
    public void setPreEnrollmentEnd(Date preEnrollmentEnd) {
        this.preEnrollmentEnd = preEnrollmentEnd;
    }

    @Override
    public Date getMandatoryEnrollmentStart() {
        return mandatoryEnrollmentStart;
    }

    @Override
    public void setMandatoryEnrollmentStart(Date mandatoryEnrollmentStart) {
        this.mandatoryEnrollmentStart = mandatoryEnrollmentStart;
    }

    @Override
    public Date getMandatoryEnrollmentEnd() {
        return mandatoryEnrollmentEnd;
    }

    @Override
    public void setMandatoryEnrollmentEnd(Date mandatoryEnrollmentEnd) {
        this.mandatoryEnrollmentEnd = mandatoryEnrollmentEnd;
    }

    public Date getProvisionEnrollmentStart() {
        return provisionEnrollmentStart;
    }

    public void setProvisionEnrollmentStart(Date provisionEnrollmentStart) {
        this.provisionEnrollmentStart = provisionEnrollmentStart;
    }

    public Date getProvisionEnrollmentEnd() {
        return provisionEnrollmentEnd;
    }

    public void setProvisionEnrollmentEnd(Date provisionEnrollmentEnd) {
        this.provisionEnrollmentEnd = provisionEnrollmentEnd;
    }

    @Override
    public Date getLateEnrollmentStart() {
        return lateEnrollmentStart;
    }

    @Override
    public void setLateEnrollmentStart(Date lateEnrollmentStart) {
        this.lateEnrollmentStart = lateEnrollmentStart;
    }

    @Override
    public Date getLateEnrollmentEnd() {
        return lateEnrollmentEnd;
    }

    @Override
    public void setLateEnrollmentEnd(Date lateEnrollmentEnd) {
        this.lateEnrollmentEnd = lateEnrollmentEnd;
    }

    @Override
    public Date getGraduationStart() {
        return graduationStart;
    }

    @Override
    public void setGraduationStart(Date graduationStart) {
        this.graduationStart = graduationStart;
    }

    @Override
    public Date getGraduationEnd() {
        return graduationEnd;
    }

    @Override
    public void setGraduationEnd(Date graduationEnd) {
        this.graduationEnd = graduationEnd;
    }

    @Override
    public Date getLateGraduationStart() {
        return lateGraduationStart;
    }

    @Override
    public void setLateGraduationStart(Date lateGraduationStart) {
        this.lateGraduationStart = lateGraduationStart;
    }

    @Override
    public Date getLateGraduationEnd() {
        return lateGraduationEnd;
    }

    @Override
    public void setLateGraduationEnd(Date lateGraduationEnd) {
        this.lateGraduationEnd = lateGraduationEnd;
    }

    @Override
    public Date getFinalExamStart() {
        return finalExamStart;
    }

    @Override
    public void setFinalExamStart(Date finalExamStart) {
        this.finalExamStart = finalExamStart;
    }

    @Override
    public Date getFinalExamEnd() {
        return finalExamEnd;
    }

    @Override
    public void setFinalExamEnd(Date finalExamEnd) {
        this.finalExamEnd = finalExamEnd;
    }

    @Override
    public Date getInputFinalExamStart() {
        return inputFinalExamStart;
    }

    @Override
    public void setInputFinalExamStart(Date inputFinalExamStart) {
        this.inputFinalExamStart = inputFinalExamStart;
    }

    @Override
    public Date getInputFinalExamEnd() {
        return inputFinalExamEnd;
    }

    @Override
    public void setInputFinalExamEnd(Date inputFinalExamEnd) {
        this.inputFinalExamEnd = inputFinalExamEnd;
    }

    @Override
    public Date getAppealFinalExamStart() {
        return appealFinalExamStart;
    }

    @Override
    public void setAppealFinalExamStart(Date appealFinalExamStart) {
        this.appealFinalExamStart = appealFinalExamStart;
    }

    @Override
    public Date getAppealFinalExamEnd() {
        return appealFinalExamEnd;
    }

    @Override
    public void setAppealFinalExamEnd(Date appealFinalExamEnd) {
        this.appealFinalExamEnd = appealFinalExamEnd;
    }

    @Override
    public Date getReleaseFinalExamStart() {
        return releaseFinalExamStart;
    }

    @Override
    public void setReleaseFinalExamStart(Date releaseFinalExamStart) {
        this.releaseFinalExamStart = releaseFinalExamStart;
    }

    @Override
    public Date getReleaseFinalExamEnd() {
        return releaseFinalExamEnd;
    }

    @Override
    public void setReleaseFinalExamEnd(Date releaseFinalExamEnd) {
        this.releaseFinalExamEnd = releaseFinalExamEnd;
    }

    public Date getSpecialExamStart() {
        return specialExamStart;
    }

    public void setSpecialExamStart(Date specialExamStart) {
        this.specialExamStart = specialExamStart;
    }

    public Date getSpecialExamEnd() {
        return specialExamEnd;
    }

    public void setSpecialExamEnd(Date specialExamEnd) {
        this.specialExamEnd = specialExamEnd;
    }

    public Date getInputSpecialExamStart() {
        return inputSpecialExamStart;
    }

    public void setInputSpecialExamStart(Date inputSpecialExamStart) {
        this.inputSpecialExamStart = inputSpecialExamStart;
    }

    public Date getInputSpecialExamEnd() {
        return inputSpecialExamEnd;
    }

    public void setInputSpecialExamEnd(Date inputSpecialExamEnd) {
        this.inputSpecialExamEnd = inputSpecialExamEnd;
    }

    public Date getAppealSpecialExamStart() {
        return appealSpecialExamStart;
    }

    public void setAppealSpecialExamStart(Date appealSpecialExamStart) {
        this.appealSpecialExamStart = appealSpecialExamStart;
    }

    public Date getAppealSpecialExamEnd() {
        return appealSpecialExamEnd;
    }

    public void setAppealSpecialExamEnd(Date appealSpecialExamEnd) {
        this.appealSpecialExamEnd = appealSpecialExamEnd;
    }

    @Override
    public Date getReleaseSpecialExamStart() {
        return releaseSpecialExamStart;
    }

    @Override
    public void setReleaseSpecialExamStart(Date releaseSpecialExamStart) {
        this.releaseSpecialExamStart = releaseSpecialExamStart;
    }

    @Override
    public Date getReleaseSpecialExamEnd() {
        return releaseSpecialExamEnd;
    }

    @Override
    public void setReleaseSpecialExamEnd(Date releaseSpecialExamEnd) {
        this.releaseSpecialExamEnd = releaseSpecialExamEnd;
    }

    @Override
    public AdProcessCalendarType getProcessType() {
        return processType;
    }

    @Override
    public void setProcessType(AdProcessCalendarType processType) {
        this.processType = processType;
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
        return AdProcessCalendar.class;
    }
}
