package my.edu.umk.pams.academic.common.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import my.edu.umk.pams.academic.core.AdMetadata;

@Entity(name = "AdCampus")
@Table(name = "AD_CAMPUS")
public class AdCampusImpl implements AdCampus {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "SQ_AD_CAMPUS")
	@SequenceGenerator(name = "SQ_AD_CAMPUS", sequenceName = "SQ_AD_CAMPUS", allocationSize = 1)
	private Long id;

	@NotNull
	@Column(name = "CODE", nullable = true)
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
		return AdCampus.class;
	}


	
	

}
