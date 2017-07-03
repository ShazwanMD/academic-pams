package my.edu.umk.pams.academic.web.module.term.vo;

import my.edu.umk.pams.academic.planner.model.AdAcademicStanding;


import my.edu.umk.pams.academic.planner.model.AdAdmissionStatus;
import my.edu.umk.pams.academic.web.module.common.vo.StudyCenter;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.academic.web.module.planner.vo.Cohort;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author PAMS
 */
public class Admission extends MetaObject{

    private BigDecimal gpa;
    private BigDecimal cgpa;
    private Integer creditTaken;
    private Integer creditEarned;
    private Integer ordinal;
    private Student student;
    private AcademicSession academicSession;
    private Cohort cohort;
    private AdmissionStatus status;
    private AcademicStanding standing;
	private StudyCenter studyCenter;

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
    
    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
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
    
    public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }
    
    public AdmissionStatus getStatus() {
        return status;
    }

    public void setStatus(AdmissionStatus status) {
        this.status = status;
    }
    
    public AcademicStanding getStanding() {
        return standing;
    }

    public void setStanding(AcademicStanding standing) {
        this.standing = standing;
    }
    
    public StudyCenter getStudyCenter() {
 		return studyCenter;
 	}

 	public void setStudyCenter(StudyCenter studyCenter) {
 		this.studyCenter = studyCenter;
 	}


    
    @JsonCreator
    public static Admission create(String jsonString) {
        Admission o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Admission.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
    
}
