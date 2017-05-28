package my.edu.umk.pams.academic.web.module.graduation.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.Task;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;

import java.io.IOException;

/**
 * @author PAMS
 */
public class GraduationApplicationTask extends Task {

    private Student student;
    private GraduationApplication application;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public GraduationApplication getApplication() {
        return application;
    }

    public void setApplication(GraduationApplication application) {
        this.application = application;
    }

    @JsonCreator
    public static GraduationApplicationTask create(String jsonString) {
        GraduationApplicationTask o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, GraduationApplicationTask.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}

