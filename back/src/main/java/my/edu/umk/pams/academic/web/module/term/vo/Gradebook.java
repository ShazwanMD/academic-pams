package my.edu.umk.pams.academic.web.module.term.vo;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class Gradebook {
    private BigDecimal score;
    private Assessment assessment;

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }
}

