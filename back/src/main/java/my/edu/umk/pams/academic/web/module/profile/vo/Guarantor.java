package my.edu.umk.pams.academic.web.module.profile.vo;

import my.edu.umk.pams.academic.web.module.core.vo.MetaObject;

/**
 * @author PAMS
 */
public class Guarantor extends MetaObject {
    private String identityNo;
    private String name;
    private GuarantorType guarantorType;

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
}
