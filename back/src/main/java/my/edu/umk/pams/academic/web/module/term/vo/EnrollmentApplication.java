package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class EnrollmentApplication extends MetaObject {


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
