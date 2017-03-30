package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.Document;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.io.IOException;

/**
 * @author PAMS
 */
public class AdmissionApplication extends Document {

    private Student student;
    private AcademicSession academicSession;

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
    public static AdmissionApplication create(String jsonString) {
        AdmissionApplication o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, AdmissionApplication.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
