package my.edu.umk.pams.academic.identity.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import my.edu.umk.pams.academic.core.AdMetadata;

@Entity(name = "AdSponsorship")
@Table(name = "AD_SPONSORSHIP")
public class AdSponsorshipImpl implements AdSponsorship {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_SPONSORSHIP")
    @SequenceGenerator(name = "SQ_AD_SPONSORSHIP", sequenceName = "SQ_AD_SPONSORSHIP", allocationSize = 1)
    private Long id;
    
	@NotNull
	@Column(name = "REFERENCE_NO", nullable = false)
	private String referenceNo;

	@ManyToOne(targetEntity = AdSponsorImpl.class)
    @JoinColumn(name = "SPONSOR_ID")
    private AdSponsor sponsor;
	
	@ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private AdStudent student;

	@NotNull
    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(name = "START_DATE")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    
    @Column(name = "END_DATE")
    private Date endDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    
    @Column(name = "ACTIVE")
    private Boolean active;
    
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
    public String getReferenceNo() {
        return referenceNo;
    }

    @Override
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
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
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    @Override
    public Date getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Override
    public Boolean getActive() {
		return active;
	}

    @Override
    public void setActive(Boolean active) {
		this.active = active;
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
    public AdSponsor getSponsor() {
		return sponsor;
	}

    @Override
	public void setSponsor(AdSponsor sponsor) {
		this.sponsor = sponsor;
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
    public Class<?> getInterfaceClass() {
        return AdSponsorship.class;
    }

}
