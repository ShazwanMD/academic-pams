package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Program extends MetaObject{
    private String code;
    private String titleMs;
    private String titleEn;
    private String description;
    private ProgramStatus status;
    private Faculty faculty;
	private ProgramLevel programLevel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgramStatus getStatus() {
        return status;
    }

    public void setStatus(ProgramStatus status) {
        this.status = status;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public ProgramLevel getLevel() {
        return programLevel;
    }

    public void setLevel(ProgramLevel level) {
        this.programLevel = level;
    }
    
    @JsonCreator
    public static Program create(String jsonString) {
        Program o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Program.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

	
}
