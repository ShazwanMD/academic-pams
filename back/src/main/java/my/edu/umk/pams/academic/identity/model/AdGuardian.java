package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdGuardian extends AdMetaObject {

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    AdGuardianType getType();

    void setType(AdGuardianType type);

    AdStudent getStudent();

    void setStudent(AdStudent student);

}
