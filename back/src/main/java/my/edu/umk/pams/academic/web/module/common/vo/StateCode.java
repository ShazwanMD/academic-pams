package my.edu.umk.pams.academic.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class StateCode extends MetaObject {
    private String code;
    private String description;
    private CountryCode countryCode;
    

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
    
    
    public CountryCode getCountryCode() {
        return countryCode;
    }

    
    public void setCountryCode(CountryCode countryCode) {
        this.countryCode = countryCode;
    }


    @JsonCreator
    public static StateCode create(String jsonString) {
    StateCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, StateCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
