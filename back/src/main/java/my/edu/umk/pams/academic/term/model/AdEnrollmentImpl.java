package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdStudentImpl;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdEnrollment")
@Table(name = "AD_ENMT")
public class AdEnrollmentImpl implements AdEnrollment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ENMT")
    @SequenceGenerator(name = "SQ_AD_ENMT", sequenceName = "SQ_AD_ENMT", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS", nullable = false)
    private AdEnrollmentStatus status = AdEnrollmentStatus.NEW;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STANDING", nullable = false)
    private AdEnrollmentStanding standing = AdEnrollmentStanding.HW;

    @ManyToOne(targetEntity = AdGradeCodeImpl.class)
    @JoinColumn(name = "GRADE_CODE_ID")
    private AdGradeCode gradeCode;

    @ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private AdStudent student;

    @ManyToOne(targetEntity = AdSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private AdSection section;

    @ManyToOne(targetEntity = AdAdmissionImpl.class)
    @JoinColumn(name = "ADMISSION_ID")
    private AdAdmission admission;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public AdEnrollmentStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(AdEnrollmentStatus status) {
        this.status = status;
    }

    @Override
    public AdEnrollmentStanding getStanding() {
        return standing;
    }

    @Override
    public void setStanding(AdEnrollmentStanding standing) {
        this.standing = standing;
    }

    @Override
    public AdAdmission getAdmission() {
        return admission;
    }

    @Override
    public void setAdmission(AdAdmission admission) {
        this.admission = admission;
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
    public AdSection getSection() {
        return section;
    }

    @Override
    public void setSection(AdSection section) {
        this.section = section;
    }

    @Override
    public AdGradeCode getGradeCode() {
        return gradeCode;
    }

    @Override
    public void setGradeCode(AdGradeCode gradeCode) {
        this.gradeCode = gradeCode;
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
        return AdEnrollment.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdEnrollmentImpl that = (AdEnrollmentImpl) o;

        if (!id.equals(that.id)) return false;
        if (!section.equals(that.section)) return false;
        return student.equals(that.student);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + student.hashCode();
        result = 31 * result + section.hashCode();
        return result;
    }
}
