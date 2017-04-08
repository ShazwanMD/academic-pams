package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.identity.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface ProfileService {

    //====================================================================================================
    // STUDENT
    //====================================================================================================

    // note: thin wrapper
    AdStudent findStudentById(Long id);

    AdStudent findStudentByMatricNo(String matricNo);

    AdAddress findAddressById(Long id);

    AdGuarantor findGuarantorById(Long id);

    AdGuardian findGuardianById(Long id);

    AdContact findContactById(Long id);

    List<AdStudent> findStudents(Integer offset, Integer limit);

    List<AdStudent> findStudents(String filter, Integer offset, Integer limit);

    List<AdAddress> findAddresses(AdStudent student);

    List<AdGuarantor> findGuarantors(AdStudent student);

    List<AdGuardian> findGuardians(AdStudent student);

    List<AdContact> findContacts(AdStudent student);

    void updateStudent(AdStudent student);

    void addAddress(AdStudent student, AdAddress address);

    void updateAddress(AdStudent student, AdAddress address);

    void deleteAddress(AdStudent student, AdAddress address);

    void addGuarantor(AdStudent student, AdGuarantor guarantor);

    void deleteGuarantor(AdStudent student, AdGuarantor guarantor);

    void addGuardian(AdStudent student, AdGuardian guardian);

    void deleteGuardian(AdStudent student, AdGuardian guardian);

    void addContact(AdStudent student, AdContact contact);

    void deleteContact(AdStudent student, AdContact contact);


    // business

    void activateStudent(AdStudent student);

    void deactivateStudent(AdStudent student);

    void barStudent(AdStudent student);


}
