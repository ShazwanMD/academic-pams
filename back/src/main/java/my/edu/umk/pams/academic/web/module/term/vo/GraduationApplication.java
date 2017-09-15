package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;
import my.edu.umk.pams.academic.web.module.planner.vo.Course;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Statement;

/**
 * @author PAMS
 */
public class GraduationApplication extends MetaObject {

    private String memo;
    private Integer creditHour;
    private BigDecimal cgpa;
    private Student student;
    private AcademicSession session;
  
    public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
		return session;
	}

	public void setAcademicSession(AcademicSession session) {
		this.session = session;
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
