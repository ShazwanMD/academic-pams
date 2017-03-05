package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "InCollegeCode")
@Table(name = "AD_CLGE_CODE")
public class AdCollegeCodeImpl implements AdCollegeCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_CLGE_CODE")
    @SequenceGenerator(name = "SQ_AD_CLGE_CODE", sequenceName = "SQ_AD_CLGE_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE", unique = true, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne(targetEntity = AdCampusCodeImpl.class)
    @JoinColumn(name = "CAMPUS_ID", nullable = false)
    private AdCampusCode campusCode;

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
    public AdCampusCode getCampusCode() {
        return campusCode;
    }

    @Override
    public void setCampusCode(AdCampusCode campusCode) {
        this.campusCode = campusCode;
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
        return AdCollegeCode.class;
    }
}
