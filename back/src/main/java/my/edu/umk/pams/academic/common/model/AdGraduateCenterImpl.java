package my.edu.umk.pams.academic.common.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.planner.model.AdAcademicYear;
import my.edu.umk.pams.academic.planner.model.AdAcademicYearImpl;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdFacultyImpl;

@Entity(name = "AdGraduateCenter")
@Table(name = "AD_GRDT_CNTR")
public class AdGraduateCenterImpl implements AdGraduateCenter {


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_GRDT_CNTR")
    @SequenceGenerator(name = "SQ_AD_GRDT_CNTR", sequenceName = "SQ_AD_GRDT_CNTR", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "CODE",nullable = true)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION_MS", nullable = true)
    private String descriptionMs;

    @NotNull
    @Column(name = "DESCRIPTION_EN", nullable = true)
    private String descriptionEn;
    
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

	public String getDescriptionMs() {
		return descriptionMs;
	}

	public void setDescriptionMs(String descriptionMs) {
		this.descriptionMs = descriptionMs;
	}

	public String getDescriptionEn() {
		return descriptionEn;
	}

	public void setDescriptionEn(String descriptionEn) {
		this.descriptionEn = descriptionEn;
	}

	public AdMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(AdMetadata metadata) {
		this.metadata = metadata;
	}

	@Override
	public Class<?> getInterfaceClass() {
		return AdGraduateCenter.class;
	}

    
    
}
