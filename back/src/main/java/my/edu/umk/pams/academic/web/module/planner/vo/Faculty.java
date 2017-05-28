package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.planner.model.AdCourse;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;
import java.util.List;

/**
 * @author PAMS
 */
public class Faculty extends MetaObject{
    private String code;
    private String prefix;
    private String name;
    private String description;
	private FacultyStatus status;
	private  List<AdCourse> courses;
	private  List<AdProgram> programs;
	
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyStatus getStatus() {
        return status;
    }

    public void setStatus(FacultyStatus status) {
        this.status = status;
    }
    

    public List<AdProgram> getPrograms() {
    	return programs;
    }

    public void setPrograms(List<AdProgram> programs) {
    	this.programs = programs;
    }

    public List<AdCourse> getCourses(){
    	return courses;
    }

    public void setCourses(List<AdCourse> courses){
    	this.courses = courses;
    }
    
    @JsonCreator
    public static Faculty create(String jsonString) {
        Faculty o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Faculty.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
