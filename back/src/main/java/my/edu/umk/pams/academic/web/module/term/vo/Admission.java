package my.edu.umk.pams.academic.web.module.term.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class Admission extends MetaObject{

    private BigDecimal gpa;
    private BigDecimal cgpa;
    private Integer creditTaken;
    private Integer creditEarned;
    private Student student;
    private AcademicSession academicSession;

    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getCreditTaken() {
        return creditTaken;
    }

    public void setCreditTaken(Integer creditTaken) {
        this.creditTaken = creditTaken;
    }

    public Integer getCreditEarned() {
        return creditEarned;
    }

    public void setCreditEarned(Integer creditEarned) {
        this.creditEarned = creditEarned;
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
}
