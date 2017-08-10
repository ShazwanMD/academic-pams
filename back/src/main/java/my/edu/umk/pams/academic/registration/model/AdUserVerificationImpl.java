package my.edu.umk.pams.academic.registration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;

@Entity(name = "AdUserVerification")
@Table(name = "AD_USER_VRFN")
public class AdUserVerificationImpl implements AdUserVerification {
	
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_USER_VRFN")
    @SequenceGenerator(name = "SQ_AD_USER_VRFN", sequenceName = "SQ_AD_USER_VRFN", allocationSize = 1)
    private Long id;

    @Column(name = "TOKEN", unique = true, nullable = false)
    private String token;

    @Column(name = "EXPIRY_DATE", unique = true, nullable = false)
    private Date expiryDate;

    @OneToOne(targetEntity = AdUserImpl.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private AdUser user;

    @Embedded
    private AdMetadata metadata;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdMetadata getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMetadata(AdMetadata metadata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setToken(String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getExpiryDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdUser getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUser(AdUser user) {
		// TODO Auto-generated method stub
		
	}
	
    @Override
    public Class<?> getInterfaceClass() {
        return AdUserVerification.class;
    }
}


