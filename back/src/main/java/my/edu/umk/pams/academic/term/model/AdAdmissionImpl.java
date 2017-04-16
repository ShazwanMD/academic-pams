package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.common.model.AdStudyCenterImpl;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.planner.model.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
@Entity(name = "AdAdmission")
@Table(name = "AD_ADMN")
public class AdAdmissionImpl implements AdAdmission {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ADMN")
    @SequenceGenerator(name = "SQ_AD_ADMN", sequenceName = "SQ_AD_ADMN", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "GPA", unique = true)
    private BigDecimal gpa = BigDecimal.ZERO;

    @NotNull
    @Column(name = "CGPA", unique = true)
    private BigDecimal cgpa = BigDecimal.ZERO;

    @Column(name = "CREDIT_EARNED")
    private Integer creditEarned = 0;

    @Column(name = "CREDIT_TAKEN")
    private Integer creditTaken = 0;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS", nullable = false)
    private AdAdmissionStatus status = AdAdmissionStatus.ADMITTED;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STANDING", nullable = false)
    private AdAcademicStanding standing = AdAcademicStanding.KB;

    @ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private AdStudent student;

    @ManyToOne(targetEntity = AdCohortImpl.class)
    @JoinColumn(name = "COHORT_ID")
    private AdCohort cohort;

    @ManyToOne(targetEntity = AdStudyCenterImpl.class)
    @JoinColumn(name = "STUDY_CENTER_ID")
    private AdStudyCenter studyCenter;

    @ManyToOne(targetEntity = AdAcademicSessionImpl.class)
    @JoinColumn(name = "SESSION_ID")
    private AdAcademicSession session;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public BigDecimal getGpa() {
        return gpa;
    }

    @Override
    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    @Override
    public BigDecimal getCgpa() {
        return cgpa;
    }

    @Override
    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public Integer getCreditEarned() {
        return creditEarned;
    }

    @Override
    public void setCreditEarned(Integer creditEarned) {
        this.creditEarned = creditEarned;
    }

    @Override
    public Integer getCreditTaken() {
        return creditTaken;
    }

    @Override
    public void setCreditTaken(Integer creditTaken) {
        this.creditTaken = creditTaken;
    }

    @Override
    public AdAdmissionStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(AdAdmissionStatus status) {
        this.status = status;
    }

    @Override
    public AdAcademicStanding getStanding() {
        return standing;
    }

    @Override
    public void setStanding(AdAcademicStanding standing) {
        this.standing = standing;
    }

    @Override
    public AdStudent getStudent() {
        return student;
    }

    @Override
    public void setStudent(AdStudent student) {
        this.student = student;
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
    public AdStudyCenter getStudyCenter() {
        return studyCenter;
    }

    @Override
    public void setStudyCenter(AdStudyCenter studyCenter) {
        this.studyCenter = studyCenter;
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
        return AdAdmission.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdAdmissionImpl that = (AdAdmissionImpl) o;

        if (!id.equals(that.id)) return false;
        if (!cohort.equals(that.cohort)) return false;
        return student.equals(that.student);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + student.hashCode();
        result = 31 * result + cohort.hashCode();
        return result;
    }
}
