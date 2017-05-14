package my.edu.umk.pams.academic.web.module.term.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import my.edu.umk.pams.academic.web.module.identity.vo.Staff;


/**
 * @author PAMS
 */
public class Appointment extends MetaObject {
	
	//private AppointmentStatus status;
	private Staff staff;
	private Section section;
	
	/*public AppointmentStatus getAppointmentStatus() {
        return status;
    }

    public void setAppointmentStatus(AppointmentStatus status) {
        this.status = status;
    }*/
    
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    
    @JsonCreator
    public static Appointment create(String jsonString) {
    	Appointment o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Appointment.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
    
}
