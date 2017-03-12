package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;

import java.util.List;

/**
 * @author PAMS
 */
public interface ProfileService {

    AdAddress findById(Long id);

    List<AdAddress> findAddresses(AdStudent student);

    void updateStudent(AdStudent student);

    void updateAddress(AdStudent student, AdAddress adAddress);

    void removeAddress(AdStudent student, AdAddress adAddress);

}
