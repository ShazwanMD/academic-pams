package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.Course;
import my.edu.umk.pams.academic.web.module.planner.vo.Program;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Offering extends MetaObject {

    private String code;
    private String canonicalCode;
    private Course course;
    private Program program;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCanonicalCode() {
        return canonicalCode;
    }

    public void setCanonicalCode(String canonicalCode) {
        this.canonicalCode = canonicalCode;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    @JsonCreator
    public static Offering create(String jsonString) {
        Offering o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Offering.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
