package my.edu.umk.pams.academic.term.model;


import java.math.BigDecimal;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStanding;
import my.edu.umk.pams.academic.planner.model.AdEnrollmentStatus;

/**
 *
 * @author PAMS
 */
public interface AdEnrollment extends AdMetaObject {

    AdEnrollmentStatus getStatus();

    void setStatus(AdEnrollmentStatus status);

    AdEnrollmentStanding getStanding();

    void setStanding(AdEnrollmentStanding level);

    AdAdmission getAdmission();

    void setAdmission(AdAdmission admission);

    AdSection getSection();

    void setSection(AdSection section);

    AdGradeCode getGradeCode();

    void setGradeCode(AdGradeCode gradeCode);
    
    //totalScore

	BigDecimal getTotalScore();

	void setTotalScore(BigDecimal totalScore);
    
}
