package my.edu.umk.pams.academic.common.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author PAMS
 */
@Entity(name = "AdParliamentCode")
@Table(name = "AD_PLMT_CODE")
public class AdParliamentCodeImpl implements AdParliamentCode {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_AD_PLMT_CODE")
    @SequenceGenerator(name = "SQ_AD_PLMT_CODE", sequenceName = "SQ_AD_PLMT_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

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
        return AdParliamentCode.class;
    }
}
