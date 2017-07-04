package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdGuarantor")
@Table(name = "AD_GRTR")
public class AdGuarantorImpl implements AdGuarantor {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_GRTR")
    @SequenceGenerator(name = "SQ_AD_GRTR", sequenceName = "SQ_AD_GRTR", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "IDENTITY_NO", nullable = false)
    private String identityNo;
    
    @NotNull
    @Column(name = "PHONE", nullable = true)
    private String phone;

    @NotNull
    @Column(name = "GUARANTOR_TYPE")
    private AdGuarantorType type;

    @ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private AdStudent student;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getIdentityNo() {
        return identityNo;
    }

    @Override
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    @Override
    public AdGuarantorType getType() {
        return type;
    }

    @Override
    public void setType(AdGuarantorType type) {
        this.type = type;
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
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdGuarantor.class;
    }
}
