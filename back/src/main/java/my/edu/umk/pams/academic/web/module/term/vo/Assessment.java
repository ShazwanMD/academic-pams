package my.edu.umk.pams.academic.web.module.term.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.math.BigDecimal;

public class Assessment extends MetaObject {
    private Long id;
    private String code;
    private String canonicalCode;
    private String description;
    private Integer ordinal;
    private BigDecimal weight;
    private BigDecimal totalScore;
    private AssessmentType assessmentType;
    private AssessmentCategory assessmentCategory;
    private AcademicSession session;
    private Offering offering;

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

    public String getCanonicalCode() {
        return canonicalCode;
    }

    public void setCanonicalCode(String canonicalCode) {
        this.canonicalCode = canonicalCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }

    public AssessmentCategory getAssessmentCategory() {
        return assessmentCategory;
    }

    public void setAssessmentCategory(AssessmentCategory assessmentCategory) {
        this.assessmentCategory = assessmentCategory;
    }

    public AcademicSession getSession() {
        return session;
    }

    public void setSession(AcademicSession session) {
        this.session = session;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }


//    @JsonCreator
//    public static Assessment create(String jsonString) {
//        Assessment o = null;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            o = mapper.readValue(jsonString, Assessment.class);
//        } catch (IOException e) {
//            // handle
//        }
//        return o;
//    }


}
