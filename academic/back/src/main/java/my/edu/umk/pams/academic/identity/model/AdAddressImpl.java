package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.common.model.*;
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

    @OneToOne(targetEntity = AdDunCodeImpl.class)
    @JoinColumn(name = "DUN_CODE_ID")
    private AdDunCode dunCode;

    @OneToOne(targetEntity = AdParliamentCodeImpl.class)
    @JoinColumn(name = "PARLIAMENT_CODE_ID")
    private AdParliamentCode parliamentCode;

    @ManyToOne(targetEntity = AdStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private AdStudent student;

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

    @Override
    public AdDunCode getDunCode() {
        return dunCode;
    }

    @Override
    public void setDunCode(AdDunCode dunCode) {
        this.dunCode = dunCode;
    }

    @Override
    public AdParliamentCode getParliamentCode() {
        return parliamentCode;
    }

    @Override
    public void setParliamentCode(AdParliamentCode parliamentCode) {
        this.parliamentCode = parliamentCode;
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
        return AdAddress.class;
    }

}
