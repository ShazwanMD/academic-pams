package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * @author canang.technologies
 * @since 31/10/2014
 */
public interface AdActor extends AdMetaObject {

    String getIdentityNo();

    void setIdentityNo(String identityNo);   

    String getName();

    void setName(String firstName);

    String getPhone();

    void setPhone(String phone);

    String getMobile();

    void setMobile(String mobile);

    String getFax();

    void setFax(String fax);

    String getEmail();

    void setEmail(String email);

    AdActorType getActorType();

    void setActorType(AdActorType actorType);


}
