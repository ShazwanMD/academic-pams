package my.edu.umk.pams.academic.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class CityCode extends MetaObject {
    private String code;
    private String description;
    private AdStateCode stateCode;

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

    
    public AdStateCode getStateCode() {
        return stateCode;
    }

    
    public void setStateCode(AdStateCode stateCode) {
        this.stateCode = stateCode;
    }


    @JsonCreator
    public static CityCode create(String jsonString) {
    CityCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, CityCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
