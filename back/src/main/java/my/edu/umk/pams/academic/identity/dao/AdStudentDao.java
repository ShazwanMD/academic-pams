package my.edu.umk.pams.academic.identity.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdStudentDao extends GenericDao<Long, AdStudent> {

    AdStudent findByStudentNo(String studentNo);

    AdAddress findAddressById(Long id);

    AdGuarantor findGuarantorById(Long id);

    AdGuardian findGuardianById(Long id);

    AdContact findContactById(Long id);

    AdGuarantor findGuarantorByType(AdGuarantorType type, AdStudent student);

    AdGuardian findGuardianByType(AdGuardianType guardianType, AdStudent student);

    AdContact findContactByType(AdContactType type, AdStudent student);

    AdAddress findAddressByType(AdAddressType type, AdStudent student);

    List<AdGuarantor> findGuarantors(AdStudent student);

    List<AdGuardian> findGuardians(AdStudent student);

    List<AdContact> findContacts(AdStudent student);

    List<AdAddress> findAddresses(AdStudent student);


    // helper
    Integer count(String filter);

    Integer countAddress(AdStudent student);

    void addGuardian(AdStudent student, AdGuardian guardian, AdUser user);

    void deleteGuardian(AdStudent student, AdGuardian guardian, AdUser user);

    void addGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user);

    void deleteGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user);

    void addContact(AdStudent student, AdContact contact, AdUser user);

    void deleteContact(AdStudent student, AdContact contact, AdUser user);

    void addAddress(AdStudent student, AdAddress address, AdUser user);

    void updateAddress(AdStudent student, AdAddress address, AdUser user);

    void deleteAddress(AdStudent student, AdAddress address, AdUser user);

}
