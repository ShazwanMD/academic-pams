package my.edu.umk.pams.academic.web.module.term.vo;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.term.model.AdEnrollmentApplication;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class EnrollmentApplicationItem extends MetaObject {

    private EnrollmentApplicationAction action;
    private Section section;
    private EnrollmentApplication application;

    
    public EnrollmentApplication getApplication() {
        return application;
    }

    public void setApplication(EnrollmentApplication application) {
        this.application = application;
    }
    
    public EnrollmentApplicationAction getAction() {
        return action;
    }

    public void setAction(EnrollmentApplicationAction action) {
        this.action = action;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
    
    @JsonCreator
	public static EnrollmentApplicationItem create(String jsonString) {
    	EnrollmentApplicationItem o = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			o = mapper.readValue(jsonString, EnrollmentApplicationItem.class);
		} catch (IOException e) {
			// handle
		}
		return o;
	}

}
