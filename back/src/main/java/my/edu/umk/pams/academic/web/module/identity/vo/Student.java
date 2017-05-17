package my.edu.umk.pams.academic.web.module.identity.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Student extends Actor {
	
	private StudentStatus studentStatus;

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
