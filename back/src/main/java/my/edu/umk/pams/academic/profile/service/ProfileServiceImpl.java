package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.identity.dao.AdStudentDao;
import my.edu.umk.pams.academic.identity.model.AdAddress;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.security.service.SecurityService;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author PAMS
 */
@Transactional
@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileServiceImpl.class);

    @Autowired
    private AdStudentDao studentDao;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SessionFactory sessionFactory;

    //====================================================================================================
    // STUDENT
    //====================================================================================================

    @Override
    public void activateStudent(AdStudent student) {

    }

    @Override
    public void deactivateStudent(AdStudent student) {

    }

    @Override
    public void updateStudent(AdStudent student) {
        studentDao.update(student, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    //====================================================================================================
    // STUDENT
    //====================================================================================================

    @Override
    public void addAddress(AdStudent student, AdAddress address) {
        studentDao.addAddress(student, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateAddress(AdStudent student, AdAddress address) {
        // todo(uda): xxx
//        studentDao.updateAddress(student, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void removeAddress(AdStudent student, AdAddress address) {
        // todo(uda): xxx
//        studentDao.removeAddress(student, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public AdAddress findAddressById(Long id) {
        return studentDao.findAddressById(id);
    }

    @Override
    public List<AdAddress> findAddresses(AdStudent student) {
        return studentDao.findAddresses(student);
    }

}
