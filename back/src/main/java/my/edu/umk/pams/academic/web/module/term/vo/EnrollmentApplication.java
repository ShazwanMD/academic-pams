package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.Document;

import java.io.IOException;

/**
 * @author PAMS
 */
public class EnrollmentApplication extends Document {

    private Admission admission;

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @JsonCreator
    public static EnrollmentApplication create(String jsonString) {
        EnrollmentApplication o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, EnrollmentApplication.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
