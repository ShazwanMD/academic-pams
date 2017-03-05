package my.edu.umk.pams.academic.system.model;


import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Entity(name = "InSubModule")
@Table(name = "AD_SMDL")
public class AdSubModuleImpl implements AdSubModule, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_SMDL")
    @SequenceGenerator(name = "SQ_AD_SMDL", sequenceName = "SQ_AD_SMDL", allocationSize = 1)
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ORDINAL")
    private Integer ordinal = 0;

    @Column(name = "ENABLED")
    private boolean enabled = true;

    @OneToOne(targetEntity = AdModuleImpl.class)
    @JoinColumn(name = "MODULE_ID")
    private AdModule module;

    @Embedded
    private AdMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Integer getOrdinal() {
        return ordinal;
    }

    @Override
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AdModule getModule() {
        return module;
    }

    public void setModule(AdModule module) {
        this.module = module;
    }

    public AdMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdSubModule.class;
    }

}
