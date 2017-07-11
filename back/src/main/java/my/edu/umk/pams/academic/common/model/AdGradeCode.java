package my.edu.umk.pams.academic.common.model;

import java.math.BigDecimal;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * A+,A,A-,B+,B,B-,C+,C,C-,
 */
public interface AdGradeCode extends AdMetaObject {

	Integer getOrdinal();

	void setOrdinal(Integer ordinal);

	String getCode();

	void setCode(String code);

	String getDescription();

	void setDescription(String description);

	BigDecimal getPoint();

	void setPoint(BigDecimal point);

	BigDecimal getMin();

	void setMin(BigDecimal min);

	BigDecimal getMax();

	void setMax(BigDecimal max);

}
