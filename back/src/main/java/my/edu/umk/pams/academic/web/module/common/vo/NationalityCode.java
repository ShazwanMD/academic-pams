package my.edu.umk.pams.academic.web.module.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class NationalityCode extends MetaObject {
    private String code;
    private String descriptionMs;
    private String descriptionEn;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    
    public String getDescriptionMs() {
        return descriptionMs;
    }

    public void setDescriptionMs(String descriptionMs) {
        this.descriptionMs = descriptionMs;
    }

    @JsonCreator
    public static NationalityCode create(String jsonString) {
    NationalityCode o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, NationalityCode.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
