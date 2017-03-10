package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdCityCode")
@Table(name = "AD_CITY_CODE")
public class AdCityCodeImpl implements AdCityCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CITY_CODE")
    @SequenceGenerator(name = "SQ_AD_CITY_CODE", sequenceName = "SQ_AD_CITY_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(targetEntity = AdStateCodeImpl.class)
    @JoinColumn(name = "STATE_CODE_ID")
    private AdStateCode stateCode;

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
    public AdStateCode getStateCode() {
        return stateCode;
    }

    @Override
    public void setStateCode(AdStateCode stateCode) {
        this.stateCode = stateCode;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdCityCode.class;
    }
}
