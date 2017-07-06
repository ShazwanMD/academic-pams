package my.edu.umk.pams.academic.common.model;

import my.edu.umk.pams.academic.core.AdMetadata;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name = "AdGradeCode")
@Table(name = "AD_GRDE_CODE")
public class AdGradeCodeImpl implements AdGradeCode {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SQ_AD_GRDE_CODE")
    @SequenceGenerator(name = "SQ_AD_GRDE_CODE", sequenceName = "SQ_AD_GRDE_CODE", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "ORDINAL", unique = false, nullable = false)
    private Integer ordinal;

    @NotNull
    @Column(name = "CODE", unique = false, nullable = false)
    private String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    
    @Column(name = "POINT", nullable = true)
    private BigDecimal point;

    @Embedded
    private AdMetadata metadata;
    

    public BigDecimal getPoint() {
		return point;
	}

	public void setPoint(BigDecimal point) {
		this.point = point;
	}

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
    public Integer getOrdinal() {
        return ordinal;
    }

    @Override
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
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
        return AdGradeCode.class;
    }
}
