package my.edu.umk.pams.academic.web.module.profile.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class Guardian extends MetaObject{
    private String identityNo;
    private String name;
    private GuardianType guardianType;

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
