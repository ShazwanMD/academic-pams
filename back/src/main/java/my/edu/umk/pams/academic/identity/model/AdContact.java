package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * todo(sam): add phone , email
 * Contact or Next of Kin
 */
public interface AdContact extends AdMetaObject {

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    AdContactType getType();

    void setType(AdContactType type);

    AdStudent getStudent();

    void setStudent(AdStudent student);

}
