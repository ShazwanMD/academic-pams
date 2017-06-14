package my.edu.umk.pams.academic.web.module.identity.vo;

import com.fasterxml.jackson.annotation.JsonCreator;

import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.web.module.planner.vo.Faculty;
import my.edu.umk.pams.academic.web.module.planner.vo.Program;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Staff extends Actor {

    private Long id;
    private StaffType staffType;
    private Faculty faculty;
    private Program program;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public StaffType getStaffType() {
		return staffType;
	}

	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
	}

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
