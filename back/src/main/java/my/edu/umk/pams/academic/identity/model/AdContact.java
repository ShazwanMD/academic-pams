package my.edu.umk.pams.academic.identity.model;


import my.edu.umk.pams.academic.core.AdMetaObject;

/**
 * Contact or Next of Kin
 */
public interface AdContact extends AdMetaObject {

    AdContactType getType();

    void setType(AdContactType type);

    String getIdentityNo();

    void setIdentityNo(String noIc);

    String getName();

    void setName(String name);

    String getSomething();

    void setSomething(String something);

    AdStudent getStudent();

    void setStudent(AdStudent student);

}
