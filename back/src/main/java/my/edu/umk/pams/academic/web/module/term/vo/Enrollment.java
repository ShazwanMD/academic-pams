package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.identity.vo.Student;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Enrollment extends MetaObject {

    private Student student;
    private Offering offering;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }


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
