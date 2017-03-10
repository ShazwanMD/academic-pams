package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdInvolvementLevelCode")
@Table(name = "AD_INVT_LEVL_CODE")
public class AdInvolvementLevelCodeImpl implements AdInvolvementLevelCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_INVT_LEVL_CODE")
    @SequenceGenerator(name = "SQ_AD_INVT_LEVL_CODE", sequenceName = "SQ_AD_INVT_LEVL_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(targetEntity = AdInvolvementTypeCodeImpl.class)
    @JoinColumn(name = "TYPE_CODE_ID")
    private AdInvolvementTypeCode typeCode;

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

    public AdInvolvementTypeCode getTypeCode() {
        return typeCode;
    }

    @Override
    public void setTypeCode(AdInvolvementTypeCode typeCode) {
        this.typeCode = typeCode;
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
        return AdInvolvementLevelCode.class;
    }
}
