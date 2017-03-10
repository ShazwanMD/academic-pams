package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdStateCode")
@Table(name = "AD_STTE_CODE")
public class AdStateCodeImpl implements AdStateCode {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_AD_STTE_CODE")
    @SequenceGenerator(name = "SQ_AD_STTE_CODE", sequenceName = "SQ_AD_STTE_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(targetEntity = AdCountryCodeImpl.class)
    @JoinColumn(name = "COUNTRY_CODE_ID")
    private AdCountryCode countryCode;

    @Embedded
    private AdMetadata metadata;

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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
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
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdStateCode.class;
    }
}
