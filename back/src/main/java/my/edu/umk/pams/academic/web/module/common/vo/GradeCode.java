package my.edu.umk.pams.academic.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author PAMS
 */
public class GradeCode {

    private Long id;
    private String code;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @JsonCreator
    public static GradeCode create(String jsonString) {
        GradeCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, GradeCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
