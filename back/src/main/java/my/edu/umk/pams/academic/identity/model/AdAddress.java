package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.model.AdDunCode;
import my.edu.umk.pams.academic.common.model.AdParliamentCode;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.core.AdMetaObject;

public interface AdAddress extends AdMetaObject {

    AdAddressType getType();

    void setType(AdAddressType type);

    String getAddress1();

    void setAddress1(String address1);

    String getAddress2();

    void setAddress2(String address2);

    String getAddress3();

    void setAddress3(String address3);

    String getPostCode();

    void setPostCode(String postCode);

    AdCountryCode getCountryCode();

    void setCountryCode(AdCountryCode countryCode);

    AdStateCode getStateCode();

    void setStateCode(AdStateCode stateCode);

    AdDunCode getDunCode();

    void setDunCode(AdDunCode dunCode);

    AdParliamentCode getParliamentCode();

    void setParliamentCode(AdParliamentCode parliamentCode);

    AdStudent getStudent();

    void setStudent(AdStudent student);
}
