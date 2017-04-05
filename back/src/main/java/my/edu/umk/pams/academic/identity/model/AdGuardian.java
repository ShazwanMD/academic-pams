package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

import java.math.BigDecimal;

public interface AdGuardian extends AdMetaObject {

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    BigDecimal getSalary();

    void setSalary(BigDecimal salary);

    AdGuardianType getType();

    void setType(AdGuardianType type);

    AdStudent getStudent();

    void setStudent(AdStudent student);

}
