package my.edu.umk.pams.academic.offering.service;

import my.edu.umk.pams.academic.offering.dao.AdOfferingDao;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.studyplan.dao.*;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdSection;
import my.edu.umk.pams.academic.studyplan.service.StudyplanServiceImpl;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PAMS
 */
@Service("offeringServie")
public class OfferingServiceImpl implements OfferingService {

	private static final Logger LOG = LoggerFactory.getLogger(StudyplanServiceImpl.class);

	@Autowired
	private AdAcademicSessionDao academicSessionDao;

	@Autowired
	private AdIntakeCodeDao intakeCodeDao;

	@Autowired
	private AdFacultyDao facultyDao;

	@Autowired
	private AdProgramDao programDao;

	@Autowired
	private AdCourseDao courseDao;

	@Autowired
	private AdOfferingDao offeringDao;

	@Autowired
	private AdCohortDao cohortDao;

	@Autowired
	private AdSectionDao sectionDao;

	@Autowired
	private AdAssessmentDao assessmentDao;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SessionFactory sessionFactory;

	// ====================================================================================================
	// OFFERING
	// ====================================================================================================

	@Override
	public AdOffering findOfferingById(Long id) {
		return offeringDao.findById(id);
	}

	@Override
	public AdOffering findOfferingByCanonicalCode(String canonicalCode) {
		return offeringDao.findByCanonicalCode(canonicalCode);
	}

	@Override
	public AdOffering findOfferingByProgramAndCourse(AdProgram program, AdCourse course) {
		return offeringDao.findByProgramAndCourse(program, course);
	}

	@Override
	public AdAcademicSession findLastOfferedOffering(AdAcademicSession current, AdCourse course) {
		return null;
	}

	@Override
	public List<AdOffering> findOfferings(Integer offset, Integer limit) {
		return offeringDao.find(offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, Integer offset, Integer limit) {
		return offeringDao.find(filter, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(AdProgram program) {
		return offeringDao.find(program);
	}

	@Override
	public List<AdOffering> findOfferings(AdProgram program, Integer offset, Integer limit) {
		return offeringDao.find(program, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		return offeringDao.find(filter, offset, limit);
	}

	@Override
	public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, AdProgram program,
			Integer offset, Integer limit) {
		return offeringDao.find(filter, academicSession, program, offset, limit);
	}

	@Override
	public List<AdOffering> findRunningOfferings(AdAcademicSession session) {
		return null; // TODO;
	}

	@Override
	public Integer countOffering(String filter) {
		return offeringDao.count(filter);
	}

	@Override
	public Integer countOffering(AdProgram program) {
		return offeringDao.count(program);
	}

	@Override
	public Integer countOffering(AdCourse course) {
		return offeringDao.count(course);
	}

	@Override
	public Integer countOffering(boolean authorized, String filter) {
		return offeringDao.count(filter); // TODO:
	}

	@Override
	public Integer countOffering(boolean authorized, String filter, AdProgram program) {
		return offeringDao.count(filter, program); // TODO:
	}

	@Override
	public Integer countOfferingWithSection(boolean authorized, String filter) {
		return offeringDao.countWithSection(filter); // TODO:
	}

	@Override
	public Integer countOfferingWithSection(boolean authorized, String filter, AdAcademicSession academicSession) {
		return offeringDao.countWithSection(filter, academicSession); // TODO:
	}

	@Override
	public boolean isOfferingExists(AdProgram program, AdCourse course) {
		return offeringDao.isExists(program, course);
	}
	

	@Override
	public void saveOffering(AdOffering offering) {
		offeringDao.save(offering, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	// ====================================================================================================
	// SECTION
	// ====================================================================================================

	@Override
	public AdSection findSectionById(Long id) {
		return sectionDao.findById(id);
	}

	@Override
	public AdSection findSectionByCanonicalCode(String canonicalCode) {
		return sectionDao.findByCanonicalCode(canonicalCode);
	}

	@Override
	public List<AdSection> findSections(Integer offset, Integer limit) {
		return sectionDao.find(offset, limit);
	}

	// todo: decorate
	@Override
	public List<AdSection> findSections(String filter, AdAcademicSession academicSession, Integer offset,
			Integer limit) {
		return sectionDao.find(filter, academicSession, offset, limit);
	}

	@Override
	public List<AdSection> findSections(AdOffering offering) {
		return sectionDao.find(offering);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession) {
		return sectionDao.find(academicSession);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, Integer offset, Integer limit) {
		return sectionDao.find(academicSession, offset, limit);
	}

	// todo: decorate
	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.find(academicSession, offering);
	}

	@Override
	public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering, Integer offset,
			Integer limit) {
		return sectionDao.find(academicSession, offering, offset, limit);
	}

	@Override
	public List<AdSection> findSections(String filter, AdAcademicSession academicSession, AdAdmission admission,
			Integer offset, Integer limit) {
		return sectionDao.find(filter, academicSession, admission, offset, limit);
	}

	@Override
	public Integer countSection() {
		return sectionDao.count();
	}

	@Override
	public Integer countSection(String filter, AdAcademicSession academicSession) {
		return sectionDao.count(filter, academicSession);
	}

	@Override
	public Integer countSection(AdOffering offering) {
		return sectionDao.count(offering);
	}

	@Override
	public Integer countSection(AdAcademicSession academicSession) {
		return sectionDao.count(academicSession);
	}

	@Override
	public Integer countSection(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.count(academicSession, offering);
	}

	@Override
	public Integer countSection(String filter, AdAcademicSession academicSession, AdAdmission admission) {
		return sectionDao.count(filter, academicSession, admission);
	}

	@Override
	public Integer countAvailableStaff(AdOffering offering) {
		return sectionDao.countAvailableStaff(offering);
	}

	@Override
	public Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.countAvailableStaff(academicSession, offering);
	}

	@Override
	public boolean hasSection(AdAcademicSession academicSession) {
		return sectionDao.hasSection(academicSession);
	}

	@Override
	public boolean hasSection(AdAcademicSession academicSession, AdOffering offering) {
		return sectionDao.hasSection(academicSession, offering);
	}

	@Override
	public boolean isSectionExists(String canonicalCode) {
		return sectionDao.isExists(canonicalCode);
	}

}
