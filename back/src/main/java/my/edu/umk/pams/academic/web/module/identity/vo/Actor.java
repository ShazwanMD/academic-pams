package my.edu.umk.pams.academic.web.module.identity.vo;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;
import java.io.IOException;

/**
 * @author PAMS
 */
public class Actor extends MetaObject {

    private Long id;
    private String identityNo;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private ActorType actorType;
    private StudentStatus studentStatus;

	
    public StudentStatus getStudentStatus() {
		return studentStatus;
	}


	public void setStudentStatus(StudentStatus studentStatus) {
		this.studentStatus = studentStatus;
	}


	public Long getId() {
        return id;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public ActorType getActorType() {
        return actorType;
    }

    public void setActorType(ActorType actorType) {
        this.actorType = actorType;
    }


    @JsonCreator
    public static Actor create(String jsonString) {
        Actor o = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            o = mapper.readValue(jsonString, Actor.class);
        } catch (IOException e) {
            // handle
        }
        return o;
    }
}
