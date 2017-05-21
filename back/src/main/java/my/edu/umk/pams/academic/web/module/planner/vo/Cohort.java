package my.edu.umk.pams.academic.web.module.planner.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Cohort extends MetaObject{
    private String code;
    private String description;
   // private String classificton;

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
    
   /* public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }*/

    @JsonCreator
    public static Cohort create(String jsonString) {
        Cohort o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Cohort.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
