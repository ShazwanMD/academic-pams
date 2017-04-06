package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;

import java.util.List;

/**
 * @author PAMS
 */
public interface ProfileService {

    //====================================================================================================
    // STUDENT
    //====================================================================================================

    void activateStudent(AdStudent student);

    void deactivateStudent(AdStudent student);

    void updateStudent(AdStudent student);

    //====================================================================================================
    // ADDRESS
    //====================================================================================================

    AdAddress findAddressById(Long id);

    List<AdAddress> findAddresses(AdStudent student);

    void addAddress(AdStudent student, AdAddress address);

    void updateAddress(AdStudent student, AdAddress address);

     void removeAddress(AdStudent student, AdAddress address);

}
