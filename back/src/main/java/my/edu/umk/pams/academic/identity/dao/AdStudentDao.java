package my.edu.umk.pams.academic.identity.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdStudentDao extends GenericDao<Long, AdStudent> {

    AdStudent findByStudentNo(String studentNo);
    
    /*Find By ID*/
    AdAddress findAddressById(Long id);
    AdGuarantor findGuarantorById(Long id);
    AdGuardian findGuardianById(Long id);
    AdContact findContactById(Long id);

    /*Find By Type*/
    AdGuarantor findGuarantorByType(AdGuarantorType type, AdStudent student);
    AdGuardian findGuardianByType(AdGuardianType guardianType, AdStudent student);
    AdContact findContactByType(AdContactType type, AdStudent student);
    AdAddress findAddressByType(AdAddressType type, AdStudent student);

    /*Listing All*/
    List<AdGuarantor> findGuarantors(AdStudent student);
    List<AdGuardian> findGuardians(AdStudent student);
    List<AdContact> findContacts(AdStudent student);
    List<AdAddress> findAddresses(AdStudent student);


    /*HELPER*/
    Integer count(String filter);
    Integer countAddress(AdStudent student);
    

    /*Guardian*/
    void addGuardian(AdStudent student, AdGuardian guardian, AdUser user);
    void updateGuardian(AdStudent student, AdGuardian guardian, AdUser user);
    void deleteGuardian(AdStudent student, AdGuardian guardian, AdUser user);

    /*Guarantor*/
    void addGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user);
    void updateGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user);
    void deleteGuarantor(AdStudent student, AdGuarantor guarantor, AdUser user);

    /*Contact*/
    void addContact(AdStudent student, AdContact contact, AdUser user);
    void updateContact(AdStudent student, AdContact contact, AdUser user);
    void deleteContact(AdStudent student, AdContact contact, AdUser user);

    /*Address*/
    void addAddress(AdStudent student, AdAddress address, AdUser user);
    void updateAddress(AdStudent student, AdAddress address, AdUser user);
    void deleteAddress(AdStudent student, AdAddress address, AdUser user);

}
