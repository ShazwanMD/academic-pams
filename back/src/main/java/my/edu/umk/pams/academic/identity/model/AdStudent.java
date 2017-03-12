package my.edu.umk.pams.academic.identity.model;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/27/14
 */
public interface AdStudent extends AdActor {

    String getMatricNo();

    void setMatricNo(String matricNo);

    List<AdAddress> getAddresses();

    void setAddresses(List<AdAddress> addresses);
}
