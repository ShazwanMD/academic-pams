package my.edu.umk.pams.academic.calendar.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.util.Date;

/**
 * TYPE: SELF SERVICE / BACK OFFICE
 * <p/>
 * daftar program buka ADMISSION_START
 * tutup program tutup ADMISSION_END
 * <p/>
 * daftar pra buka  PRE_ENROLLMENT_START
 * daftar pra tutup  PRE_ENROLLMENT_END
 * <p/>
 * daftar wajib buka   MANDATORY_ENROLLMENT_START
 * daftar wajib tutup  MANDATORY_ENROLLMENT_END
 * <p/>
 * daftar pembetulan buka PROVISION_ENROLLMENT_START
 * daftar pembetulan tutup PROVISION_ENROLLMENT_END
 * <p/>
 * daftar berdenda buka LATE_ENROLLMENT_START
 * dafar berdenda tutup LATE_ENROLLMENT_END
 * <p/>
 * daftar penganugerahan buka GRADUATION_START
 * daftar penganugerahan tutup GRADUATION_END
 * <p/>
 * daftar denda penganugerahan buka LATE_GRADUATION_START
 * daftar denda penganugerahan tutup LATE_GRADUATION_END
 * <p/>
 * peperiksaan khas buka            FINAL_EXAM_START
 * peperiksaan khas tutup           FINAL_EXAM_END
 * <p/>
 * exam result keyin start lecturer INPUT_FINAL_EXAM_START
 * exam result keyin end lecturer   INPUT_FINAL_EXAM_END
 * <p/>
 * rayuan result buka               APPEAL_FINAL_EXAM_START
 * rayuan result tutup              APPEAL_FINAL_EXAM_END
 * <p/>
 * exam result edar start           RELEASE_FINAL_EXAM_START
 * exam result edar end             RELEASE_FINAL_EXAM_END
 * <p/>
 * peperiksaan khas buka            SPECIAL_EXAM_START
 * peperiksaan khas tutup           SPECIAL_EXAM_END
 * <p/>
 * slip PK edar buka                RELEASE_SPECIAL_EXAM_START
 * slip PK edar tutup               RELEASE_SPECIAL_EXAM_END
 *
 * @author PAMS
 */
public interface AdProcessCalendar extends AdMetaObject {

    AdProcessCalendarType getProcessType();

    void setProcessType(AdProcessCalendarType processType);

    String getDescription();

    void setDescription(String description);

    Date getAdmissionStart();

    void setAdmissionStart(Date admissionStart);

    Date getAdmissionEnd();

    void setAdmissionEnd(Date admissionEnd);

    Date getPreEnrollmentStart();

    void setPreEnrollmentStart(Date preEnrollmentStart);

    Date getPreEnrollmentEnd();

    void setPreEnrollmentEnd(Date preEnrollmentEnd);

    Date getMandatoryEnrollmentStart();

    void setMandatoryEnrollmentStart(Date mandatoryEnrollmentStart);

    Date getMandatoryEnrollmentEnd();

    void setMandatoryEnrollmentEnd(Date mandatoryEnrollmentEnd);

    Date getProvisionEnrollmentStart();

    void setProvisionEnrollmentStart(Date provisionEnrollmentStart);

    Date getProvisionEnrollmentEnd();

    void setProvisionEnrollmentEnd(Date provisionEnrollmentEnd);

    Date getLateEnrollmentStart();

    void setLateEnrollmentStart(Date lateEnrollmentStart);

    Date getLateEnrollmentEnd();

    void setLateEnrollmentEnd(Date lateEnrollmentEnd);

    Date getGraduationStart();

    void setGraduationStart(Date graduationStart);

    Date getGraduationEnd();

    void setGraduationEnd(Date graduationEnd);

    Date getLateGraduationStart();

    void setLateGraduationStart(Date lateGraduationStart);

    Date getLateGraduationEnd();

    void setLateGraduationEnd(Date lateGraduationEnd);

    Date getFinalExamStart();

    void setFinalExamStart(Date finalExamStart);

    Date getFinalExamEnd();

    void setFinalExamEnd(Date finalExamEnd);

    Date getInputFinalExamStart();

    void setInputFinalExamStart(Date inputFinalExamStart);

    Date getInputFinalExamEnd();

    void setInputFinalExamEnd(Date inputFinalExamEnd);

    Date getAppealFinalExamStart();

    void setAppealFinalExamStart(Date appealFinalExamStart);

    Date getAppealFinalExamEnd();

    void setAppealFinalExamEnd(Date appealFinalExamEnd);

    Date getReleaseFinalExamStart();

    void setReleaseFinalExamStart(Date releaseFinalExamStart);

    Date getReleaseFinalExamEnd();

    void setReleaseFinalExamEnd(Date releaseFinalExamEnd);

    Date getSpecialExamStart();

    void setSpecialExamStart(Date specialExamStart);

    Date getSpecialExamEnd();

    void setSpecialExamEnd(Date specialExamEnd);

    Date getInputSpecialExamStart();

    void setInputSpecialExamStart(Date inputSpecialExamStart);

    Date getInputSpecialExamEnd();

    void setInputSpecialExamEnd(Date inputSpecialExamEnd);

    Date getAppealSpecialExamStart();

    void setAppealSpecialExamStart(Date appealSpecialExamStart);

    Date getAppealSpecialExamEnd();

    void setAppealSpecialExamEnd(Date appealSpecialExamEnd);

    Date getReleaseSpecialExamStart();

    void setReleaseSpecialExamStart(Date releaseSpecialExamStart);

    Date getReleaseSpecialExamEnd();

    void setReleaseSpecialExamEnd(Date releaseSpecialExamEnd);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);

    AdStudyCenter getStudyCenter();

    void setStudyCenter(AdStudyCenter studyCenter);
}

