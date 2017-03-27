package my.edu.umk.pams.academic.planner.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "AdProgramLevel")
@Table(name = "AD_PRGM_LEVL")
public class AdProgramLevelImpl implements AdProgramLevel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SQ_AD_PRGM_LEVL")
    @SequenceGenerator(name = "SQ_AD_PRGM_LEVL", sequenceName = "SQ_AD_PRGM_LEVL", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ADPROGRAM_TYPE")
    private AdProgramType type;

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
    public AdMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(AdMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public Class<?> getInterfaceClass() {
        return AdProgramLevel.class;
    }

    @Override
    public AdProgramType getType() {
        return type;
    }

    public void setType(AdProgramType type) {
        this.type = type;
	}
}
