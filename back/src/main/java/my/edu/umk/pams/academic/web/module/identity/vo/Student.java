package my.edu.umk.pams.academic.web.module.identity.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.common.vo.StudyMode;
import my.edu.umk.pams.academic.web.module.planner.vo.Cohort;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Student extends Actor {

    private Cohort cohort;
    private StudyMode studyMode;
    private StudentStatus studentStatus;
    private String memo;
    

    public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Cohort getCohort() {
        return cohort;
    }

    public void setCohort(Cohort cohort) {
        this.cohort = cohort;
    }

    public StudyMode getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(StudyMode studyMode) {
        this.studyMode = studyMode;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    @JsonCreator
    public static Student create(String jsonString) {
        Student o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Student.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
