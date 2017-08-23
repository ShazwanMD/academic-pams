package my.edu.umk.pams.academic.web.module.identity.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.identity.model.AdStaffType;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import my.edu.umk.pams.academic.web.module.planner.vo.Faculty;
import my.edu.umk.pams.academic.web.module.planner.vo.Program;

import java.io.IOException;


/**
 * @author PAMS
 */
public class Staff extends Actor {

	//private StaffType staffType;
	private Faculty faculty;
	private Program program;
	private String title;
	
	public Faculty getFaculty() {
	        return faculty;
	    }

	public void setFaculty(Faculty faculty) {
	        this.faculty = faculty;
	    }
	
	public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
	 
    @JsonCreator
    public static Staff create(String jsonString) {
        Staff o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Staff.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
