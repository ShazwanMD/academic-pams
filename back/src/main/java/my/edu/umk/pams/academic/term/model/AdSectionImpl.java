package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.util.List;

/**
 * @author PAMS
 */
@Entity(name = "AdSection")
@Table(name = "AD_SCTN")
public class AdSectionImpl implements AdSection {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_SCTN")
    @SequenceGenerator(name = "SQ_AD_SCTN", sequenceName = "SQ_AD_SCTN", allocationSize = 1)
    private Long id;

    // academicSession.code/ordinal
    @Column(name = "CODE", nullable = false)
    private String code;

    // term.canonicalCode/academicSession.code/ordinal
    @Column(name = "CANONICAL_CODE", nullable = false, unique = true)
    private String canonicalCode;

    @Column(name = "ORDINAL", nullable = false)
    private Integer ordinal;

    @Column(name = "CAPACITY", nullable = false)
    private Integer capacity;

    @ManyToOne(targetEntity = AdOfferingImpl.class)
    @JoinColumn(name = "OFFERING_ID", nullable = false)
    private AdOffering offering;

    @OneToMany(targetEntity = AdSectionPolicyImpl.class, mappedBy = "section", fetch = FetchType.LAZY)
    private List<AdSectionPolicy> policies;

    @OneToMany(targetEntity = AdEnrollmentImpl.class, mappedBy = "section", fetch = FetchType.LAZY)
    private List<AdEnrollment> enrollments;

    @OneToMany(targetEntity = AdAppointmentImpl.class, mappedBy = "section", fetch = FetchType.LAZY)
    private List<AdAppointment> appointments;

    @Embedded
    private AdMetadata metadata;

    // transient
    @Transient
    private Integer enrollmentCount = 0;

    @Transient
    private Integer appointmentCount = 0;


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
    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
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
    public AdOffering getOffering() {
        return offering;
    }

    @Override
    public void setOffering(AdOffering offering) {
        this.offering = offering;
    }

    @Override
    public List<AdSectionPolicy> getPolicies() {
        return policies;
    }

    @Override
    public void setPolicies(List<AdSectionPolicy> policies) {
        this.policies = policies;
    }

    @Override
    public List<AdEnrollment> getEnrollments() {
        return enrollments;
    }

    @Override
    public void setEnrollments(List<AdEnrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @Override
    public List<AdAppointment> getAppointments() {
        return appointments;
    }

    @Override
    public void setAppointments(List<AdAppointment> appointments) {
        this.appointments = appointments;
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
        return AdSection.class;
    }

    // transient

    @Override
    public Integer getEnrollmentCount() {
        return enrollmentCount;
    }

    @Override
    public void setEnrollmentCount(Integer enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }

    @Override
    public Integer getAppointmentCount() {
        return appointmentCount;
    }

    @Override
    public void setAppointmentCount(Integer appointmentCount) {
        this.appointmentCount = appointmentCount;
    }
}
