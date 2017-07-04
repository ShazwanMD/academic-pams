package my.edu.umk.pams.academic.web.module.profile.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Guarantor extends MetaObject {

    private Long id;
    private String identityNo;
    private String name;
    private String phoneNo;
    private GuarantorType guarantorType;
    
    public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	//sini
    public Long getId() {
        return id;
    }

    //sini
    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuarantorType getGuarantorType() {
        return guarantorType;
    }

    public void setGuarantorType(GuarantorType guarantorType) {
        this.guarantorType = guarantorType;
    }

    @JsonCreator
    public static Guarantor create(String jsonString) {
        Guarantor o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Guarantor.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
