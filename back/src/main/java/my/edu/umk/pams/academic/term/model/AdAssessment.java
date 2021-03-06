package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public interface AdAssessment extends AdMetaObject {

	String getCode();

	void setCode(String code);

	String getCanonicalCode();

	void setCanonicalCode(String canonicalCode);

	String getDescription();

	void setDescription(String description);

	Integer getOrdinal();

	void setOrdinal(Integer ordinal);

	BigDecimal getWeight();

	void setWeight(BigDecimal weight);

	BigDecimal getTotalScore();

	void setTotalScore(BigDecimal totalScore);

	AdAssessmentType getType();

	void setType(AdAssessmentType type);

	AdAssessmentCategory getCategory();

	void setCategory(AdAssessmentCategory category);

	AdOffering getOffering();

	void setOffering(AdOffering offering);
}
