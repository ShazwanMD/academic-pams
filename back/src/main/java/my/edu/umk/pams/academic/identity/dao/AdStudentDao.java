package my.edu.umk.pams.academic.identity.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/30/14
 */
public interface AdStudentDao extends GenericDao<Long, AdStudent> {

    AdStudent findByStudentNo(String studentNo);

    AdAddress findAddressById(Long id);

    List<AdStudent> findAddresses(String filter, Integer offset, Integer limit);

    List<AdAddress> findAddresses(AdStudent student);

    Integer count(String filter);

    Integer countAddress(AdStudent student);

    void addAddress(AdStudent student, AdAddress address, AdUser user);

    void updateAddress(AdStudent student, AdAddress address, AdUser user);

    void removeAddress(AdStudent student, AdAddress address, AdUser user);

}
