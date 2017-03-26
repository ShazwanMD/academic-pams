package my.edu.umk.pams.academic.term.model;


import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.planner.model.AdAcademicPeriod;
import my.edu.umk.pams.academic.planner.model.AdCohort;
import my.edu.umk.pams.academic.planner.model.AdProgram;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public interface AdChargeSchedule extends AdMetaObject {

    String getCode();

    void setCode(String code);

    BigDecimal getAmount();

    void setAmount(BigDecimal amount);

    AdCohort getCohort();

    void setCohort(AdCohort cohort);

    AdProgram getProgram();

    void setProgram(AdProgram program);

    AdStudyCenter getStudyCenter();

    void setStudyCenter(AdStudyCenter studyCenter);

    AdAcademicPeriod getPeriod();

    void setPeriod(AdAcademicPeriod period);

}
