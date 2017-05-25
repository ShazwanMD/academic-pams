package my.edu.umk.pams.academic.web.module.profile.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class Guardian extends MetaObject{
    
	private Long id;
	private String identityNo;
    private String name;
    private GuardianType guardianType;
    
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
    
    
}
