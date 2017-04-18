package my.edu.umk.pams.academic.profile.service;

import my.edu.umk.pams.academic.AcademicConstants;
import my.edu.umk.pams.academic.identity.dao.AdStudentDao;
import my.edu.umk.pams.academic.identity.event.StudentActivatedEvent;
import my.edu.umk.pams.academic.identity.event.StudentBarredEvent;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.identity.service.IdentityService;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.system.service.SystemService;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.HashMap;
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
    private IdentityService identityService;

    @Autowired
    private SystemService systemService;
    
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    //====================================================================================================
    // STUDENT
    //====================================================================================================

    @Override
    public AdStudent findStudentById(Long id) {
        return studentDao.findById(id);
    }

    @Override
    public AdGuarantor findGuarantorById(Long id) {
        return studentDao.findGuarantorById(id);
    }

    @Override
    public AdAddress findAddressById(Long id) {
        return studentDao.findAddressById(id);
    }

    @Override
    public AdGuardian findGuardianById(Long id) {
        return studentDao.findGuardianById(id);
    }

    @Override
    public AdContact findContactById(Long id) {
        return studentDao.findContactById(id);
    }

    @Override
    public AdStudent findStudentByMatricNo(String matricNo) {
        return identityService.findStudentByMatricNo(matricNo);
    }

    @Override
    public List<AdStudent> findStudents(Integer offset, Integer limit) {
        return identityService.findStudents(offset, limit);
    }

    @Override
    public List<AdStudent> findStudents(String filter, Integer offset, Integer limit) {
        return identityService.findStudents(offset, limit);
    }

    @Override
    public List<AdAddress> findAddresses(AdStudent student) {
        return studentDao.findAddresses(student);
    }

    @Override
    public List<AdGuarantor> findGuarantors(AdStudent student) {
        return studentDao.findGuarantors(student);
    }

    @Override
    public List<AdGuardian> findGuardians(AdStudent student) {
        return studentDao.findGuardians(student);
    }

    @Override
    public List<AdContact> findContacts(AdStudent student) {
        return studentDao.findContacts(student);
    }

    @Override
    public void updateStudent(AdStudent student) {
        studentDao.update(student, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addAddress(AdStudent student, AdAddress address) {
        studentDao.addAddress(student, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void updateAddress(AdStudent student, AdAddress address) {
        studentDao.updateAddress(student, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteAddress(AdStudent student, AdAddress address) {
        studentDao.deleteAddress(student, address, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGuarantor(AdStudent student, AdGuarantor guarantor) {
        studentDao.addGuarantor(student, guarantor, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGuarantor(AdStudent student, AdGuarantor guarantor) {
        studentDao.deleteGuarantor(student, guarantor, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addGuardian(AdStudent student, AdGuardian guardian) {
        studentDao.addGuardian(student, guardian, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteGuardian(AdStudent student, AdGuardian guardian) {
        studentDao.deleteGuardian(student, guardian, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void addContact(AdStudent student, AdContact contact) {
        studentDao.addContact(student, contact, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public void deleteContact(AdStudent student, AdContact contact) {
        studentDao.deleteContact(student, contact, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }


    // business

    @Override
    public void activateStudent(AdStudent student) {
        student.setStudentStatus(AdStudentStatus.ACTIVE);
        updateStudent(student);

        // trigger event
        applicationContext.publishEvent(new StudentActivatedEvent(student));
    }

    @Override
    public void deactivateStudent(AdStudent student) {
        student.setStudentStatus(AdStudentStatus.INACTIVE);
        updateStudent(student);

        // trigger event
        applicationContext.publishEvent(new StudentActivatedEvent(student));
    }

    @Override
    public void barStudent(AdStudent student) {
        student.setStudentStatus(AdStudentStatus.BARRED);
        updateStudent(student);

        // trigger event
        applicationContext.publishEvent(new StudentBarredEvent(student));
    }

	@Override
	public void transferFaculty(AdStudent student, AdAcademicSession session, AdFaculty fromFaculty,AdFaculty toFaculty) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		student.getMatricNo();
		map.put("StudentMatricNo", student.getMatricNo());
		//Faculty
		AdFaculty facultyCode = student.getCohort().getProgram().getFaculty();		
		Assert.notNull(facultyCode, "FacultyCode Must Not Null");
		map.put("Faculty", facultyCode.getPrefix());
		//Session
		AdAcademicSession sessionYear = student.getCohort().getSession();
		Assert.notNull(sessionYear, "Year Must Not Null");
		map.put("Session", sessionYear.getYear());
		//Level
		AdProgramLevel level = student.getCohort().getProgram().getProgramLevel();
		Assert.notNull(level,"Level Must Not Null");
		map.put("ProgramLevel",level.getPrefix());

		String transferFaculty = systemService.generateFormattedReferenceNo(AcademicConstants.STUDENT_MATRIC_NO, map);
		student.setMatricNo(transferFaculty);
		studentDao.update(student, securityService.getCurrentUser());
		
		
	}



}
