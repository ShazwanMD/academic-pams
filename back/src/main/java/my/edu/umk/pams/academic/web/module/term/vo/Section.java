package my.edu.umk.pams.academic.web.module.term.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Section extends MetaObject {

    private String code;
    private Integer capacity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @JsonCreator
    public static Section create(String jsonString) {
        Section o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Section.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }

}
