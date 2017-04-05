package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdGuarantor extends AdMetaObject {

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    AdGuarantorType getType();

    void setType(AdGuarantorType type);

    AdStudent getStudent();

    void setStudent(AdStudent student);

}
