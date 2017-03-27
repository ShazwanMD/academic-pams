package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStaffImpl;
import my.edu.umk.pams.academic.planner.model.AdAppointmentStatus;

import javax.persistence.*;

/**
 * @author PAMS
 */
@Entity(name = "AdAppointment")
@Table(name = "AD_APMT")
public class AdAppointmentImpl implements AdAppointment {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_APMT")
    @SequenceGenerator(name = "SQ_AD_APMT", sequenceName = "SQ_AD_APMT", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "STATUS", nullable = false)
    private AdAppointmentStatus status = AdAppointmentStatus.NEW;

    @ManyToOne(targetEntity = AdStaffImpl.class)
    @JoinColumn(name = "STAFF_ID")
    private AdStaff staff;

    @ManyToOne(targetEntity = AdSectionImpl.class)
    @JoinColumn(name = "SECTION_ID")
    private AdSection section;

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
    public AdAppointmentStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(AdAppointmentStatus status) {
        this.status = status;
    }

    @Override
    public AdStaff getStaff() {
        return staff;
    }

    @Override
    public void setStaff(AdStaff staff) {
        this.staff = staff;
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
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdAppointment.class;
    }
}
