package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.model.AdCountryCodeImpl;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.common.model.AdStateCodeImpl;
import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdAddress")
@Table(name = "AD_ADDR")
public class AdAddressImpl implements AdAddress {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_ADDR")
    @SequenceGenerator(name = "SQ_AD_ADDR", sequenceName = "SQ_AD_ADDR", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "ADDRESS1", nullable = false)
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @NotNull
    @Column(name = "POSTCODE")
    private String postCode;
    
    @Column (name="DUN")
    private String dun;
    
    @Column (name="PARLIMEN")
    private String parlimen;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ADDRESS_TYPE")
    private AdAddressType type;

    @OneToOne(targetEntity = AdStateCodeImpl.class)
    @JoinColumn(name = "STATE_CODE_ID")
    private AdStateCode stateCode;

    @OneToOne(targetEntity = AdCountryCodeImpl.class)
    @JoinColumn(name = "COUNTRY_CODE_ID")
    private AdCountryCode countryCode;

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
    public String getAddress1() {
        return address1;
    }

    @Override
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Override
    public String getAddress2() {
        return address2;
    }

    @Override
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public String getAddress3() {
        return address3;
    }

    @Override
    public void setAddress3(String address3) {
        this.address3 = address3;
    }


    @Override
    public String getDun() {
        return dun;
    }

    @Override
    public void setDun(String dun) {
        this.dun = dun;
    }

    @Override
    public String getParlimen() {
        return parlimen;
    }

    @Override
    public void setParlimen(String parlimen) {
        this.parlimen = parlimen;
    }

    @Override
    public AdAddressType getType() {
        return type;
    }

    public void setType(AdAddressType type) {
        this.type = type;
    }

    @Override
    public String getPostCode() {
        return postCode;
    }

    @Override
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public AdStateCode getStateCode() {
        return stateCode;
    }

    @Override
    public void setStateCode(AdStateCode stateCode) {
        this.stateCode = stateCode;
    }

    @Override
    public AdCountryCode getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCountryCode(AdCountryCode countryCode) {
        this.countryCode = countryCode;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdAddress.class;
    }

}
