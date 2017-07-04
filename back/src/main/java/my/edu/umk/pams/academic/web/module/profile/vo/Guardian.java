package my.edu.umk.pams.academic.web.module.profile.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

import java.io.IOException;

/**
 * @author PAMS
 */
public class Guardian extends MetaObject{
    
	private Long id;
	private String identityNo;
    private String name;
    private String phone;
    private GuardianType guardianType;
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GuardianType getGuardianType() {
		return guardianType;
	}

	public void setGuardianType(GuardianType guardianType) {
		this.guardianType = guardianType;
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

    @JsonCreator
    public static Guardian create(String jsonString) {
        Guardian o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Guardian.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
