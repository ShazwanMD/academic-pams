package my.edu.umk.pams.academic.graduation.model;

import my.edu.umk.pams.academic.core.model.AdDocument;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.math.BigDecimal;

/*
**/
public interface AdGraduation extends AdDocument {

    String getMemo();

    void setMemo(String memo);
    
    Integer getCreditHour();

    void setCreditHour(Integer creditHour);

    BigDecimal getCgpa();

    void setCgpa(BigDecimal cgpa);

    AdStudent getStudent();

    void setStudent(AdStudent student);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);
}
