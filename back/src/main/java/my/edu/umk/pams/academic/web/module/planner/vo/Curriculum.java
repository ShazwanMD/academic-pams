package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.subject.Subject;

import java.io.IOException;
import java.util.List;

/**
 * @author PAMS
 */
public class Curriculum extends MetaObject{
    private String code;
    private String description;
    private List<Subject> subjects;
    private Program program;

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static Curriculum create(String jsonString) {
        Curriculum o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Curriculum.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
