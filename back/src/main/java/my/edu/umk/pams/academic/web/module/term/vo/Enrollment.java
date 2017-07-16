package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.Course;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author PAMS
 */
public class Enrollment extends MetaObject {

    private Section section;
    private Admission admission;
    //private GradeCode gradeCode;
    private EnrollmentStanding standing;
    private EnrollmentStatus status;
    private BigDecimal totalScore;
    private AdGradeCode gradeCode;
    
   
    public AdGradeCode getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(AdGradeCode gradeCode) {
		this.gradeCode = gradeCode;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	// denormalize
    private Course course;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    
    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }
    
    public EnrollmentStanding getEnrollmentStanding() {
        return standing;
    }

    public void setEnrollmentStanding(EnrollmentStanding standing) {
        this.standing = standing;
    }
    
    public EnrollmentStatus getEnrollmentStatus() {
        return status;
    }

    public void setEnrollmentStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    /*public GradeCode getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(GradeCode gradeCode) {
        this.gradeCode = gradeCode;
    }*/


    @JsonCreator
    public static Enrollment create(String jsonString) {
        Enrollment o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Enrollment.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
