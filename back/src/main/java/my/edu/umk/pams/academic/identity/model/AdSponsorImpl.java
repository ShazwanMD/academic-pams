package my.edu.umk.pams.academic.identity.model;

import javax.persistence.*;

@Entity(name = "AdSponsor")
@Table(name = "AD_SPONSOR")
public class AdSponsorImpl extends AdActorImpl implements AdSponsor {
	
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "SPONSOR_TYPE")
    private AdSponsorType sponsorType = AdSponsorType.NONE;
    
    public AdSponsorImpl() {
        setActorType(AdActorType.SPONSOR);
    }

    @Override
    public String getSponsorNo() {
        return getIdentityNo();
    }

    @Override
    public void setSponsorNo(String sponsorNo) {
        setIdentityNo(sponsorNo);
    }

    @Override
    public AdSponsorType getSponsorType() {
        return sponsorType;
    }

    @Override
    public void setSponsorType(AdSponsorType sponsorType) {
        this.sponsorType = sponsorType;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdSponsor.class;
    }
    
    

}
