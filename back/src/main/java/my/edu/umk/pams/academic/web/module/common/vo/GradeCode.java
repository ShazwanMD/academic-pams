package my.edu.umk.pams.academic.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class GradeCode {

    private Long id;
    private String code;
    private String description;
    private Integer ordinal;
    private BigDecimal point;
    private BigDecimal min;
    private BigDecimal max;   

    public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public Integer getOrdinal() {
        return ordinal;
    }

    
    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static GradeCode create(String jsonString) {
        GradeCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, GradeCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
