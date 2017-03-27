package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public interface AdGradebook extends AdMetaObject {

    BigDecimal getScore();

    void setScore(BigDecimal score);

    AdSection getSection();

    void setSection(AdSection section);

    AdAssessment getAssessment();

    void setAssessment(AdAssessment assessment);

    AdEnrollment getEnrollment();

    void setEnrollment(AdEnrollment enrollment);
}
