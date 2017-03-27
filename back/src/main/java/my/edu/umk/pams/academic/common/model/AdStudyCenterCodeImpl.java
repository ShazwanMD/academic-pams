package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdStudyCenterCode")
@Table(name = "AD_STDY_CNTR_CODE")
public class AdStudyCenterCodeImpl implements AdStudyCenterCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_STDY_CNTR_CODE")
    @SequenceGenerator(name = "SQ_AD_STDY_CNTR_CODE", sequenceName = "SQ_AD_STDY_CNTR_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

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

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdStudyCenterCode.class;
    }
}
