package my.edu.umk.pams.academic.web.module.graduation.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.Document;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class GraduationApplication extends Document {

    private String memo;
    private BigDecimal cgpa;
    private Integer creditHour;
    private Student student;
    private AcademicSession academicSession;


    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(Integer creditHour) {
        this.creditHour = creditHour;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AcademicSession getAcademicSession() {
        return academicSession;
    }

    public void setAcademicSession(AcademicSession academicSession) {
        this.academicSession = academicSession;
    }

    @JsonCreator
    public static GraduationApplication create(String jsonString) {
        GraduationApplication o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, GraduationApplication.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
