package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.planner.vo.Course;
import my.edu.umk.pams.academic.web.module.planner.vo.Program;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicSession;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Offering extends MetaObject {

    private String code;
    private String titleMs;
    private String titleEn;
    private String canonicalCode;
    private Integer capacity;
    private Course course;
    private Program program;
    private AcademicSession session;

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
    
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getTitleMs() {
        return titleMs;
    }

    public void setTitleMs(String titleMs) {
        this.titleMs = titleMs;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
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
    
    public AcademicSession getAcademicSession() {
        return session;
    }

    public void setAcademicSession(AcademicSession session) {
        this.session = session;
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
