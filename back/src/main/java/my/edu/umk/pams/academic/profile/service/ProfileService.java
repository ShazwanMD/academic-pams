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
    
    AdAddress findAddress(AdStudent student);

    void updateStudent(AdStudent student);

    void addAddress(AdStudent student, AdAddress address);

    void updateAddress(AdStudent student, AdAddress address);

    void removeAddress(AdStudent student, AdAddress address);

}
