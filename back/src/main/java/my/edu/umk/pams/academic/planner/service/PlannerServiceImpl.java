package my.edu.umk.pams.academic.planner.service;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGraduateCenter;
import my.edu.umk.pams.academic.common.model.AdStudyMode;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.dao.*;
import my.edu.umk.pams.academic.planner.event.AcademicSessionAddedEvent;
import my.edu.umk.pams.academic.planner.event.CohortAddedEvent;
import my.edu.umk.pams.academic.planner.event.CohortRemovedEvent;
import my.edu.umk.pams.academic.planner.event.FacultyAddedEvent;
import my.edu.umk.pams.academic.planner.event.ProgramAddedEvent;
import my.edu.umk.pams.academic.planner.event.ProgramEvent;
import my.edu.umk.pams.academic.planner.event.ProgramRemovedEvent;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.dao.AdAssessmentDao;
import my.edu.umk.pams.academic.term.dao.AdOfferingDao;
import my.edu.umk.pams.academic.term.dao.AdSectionDao;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.term.service.TermService;
import my.edu.umk.pams.academic.web.module.planner.vo.Faculty;
import my.edu.umk.pams.connector.payload.AcademicSessionCodePayload;
import my.edu.umk.pams.connector.payload.CohortCodePayload;
import my.edu.umk.pams.connector.payload.FacultyCodePayload;
import my.edu.umk.pams.connector.payload.ProgramCodePayload;
import my.edu.umk.pams.connector.payload.ProgramLevelPayload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static java.math.RoundingMode.HALF_UP;

/**
 * @author PAMS
 */
@Transactional
@Service("plannerService")
public class PlannerServiceImpl implements PlannerService {

	private static final Logger LOG = LoggerFactory.getLogger(PlannerServiceImpl.class);

	@Autowired
	private AdAcademicSessionDao academicSessionDao;

	@Autowired
	private AdAcademicYearDao academicYearDao;

	@Autowired
	private AdIntakeCodeDao intakeCodeDao;

	@Autowired
	private AdFacultyDao facultyDao;

	@Autowired
	private AdSubjectDao subjectDao;

	@Autowired
	private AdProgramLevelDao programLevelDao;

	@Autowired
	private AdProgramDao programDao;

	@Autowired
	private AdCourseDao courseDao;

	@Autowired
	private AdAcademicYearDao yearDao;

	@Autowired
	private AdOfferingDao offeringDao;

	@Autowired
	private AdCohortDao cohortDao;

	@Autowired
	private AdCurriculumDao curriculumDao;

	@Autowired
	private AdSectionDao sectionDao;

	@Autowired
	private AdAssessmentDao assessmentDao;

	@Autowired
	private TermService termService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ApplicationContext applicationContext;

	// ====================================================================================================
	// ACADEMIC SESSION
	// ====================================================================================================

	@Override
	public AdAcademicSession findCurrentAcademicSession() {
		return academicSessionDao.findCurrentSession();
	}

	@Override
	public AdAcademicSession findAcademicSessionById(Long id) {
		return academicSessionDao.findById(id);
	}

	@Override
	public AdAcademicSession findAcademicSessionByCode(String code) {
		return academicSessionDao.findByCode(code);
	}

	@Override
	public List<AdAcademicSession> findAcademicSessions(Integer offset, Integer limit) {
		return academicSessionDao.find(offset, limit);
	}

	@Override
	public List<AdAcademicSession> findAcademicSessions(String filter, Integer offset, Integer limit) {
		return academicSessionDao.find(filter, offset, limit);
	}

	@Override
	public Integer countAcademicSession() {
		return academicSessionDao.count();
	}

	@Override
	public Integer countAcademicSession(String filter) {
		return academicSessionDao.count(filter);
	}

	@Override
	public boolean isAcademicSessionCodeExists(String code) {
		return academicSessionDao.isCodeExists(code);
	}

	@Override
	public boolean isCurrent(boolean b) {
		return academicSessionDao.isCurrent(b);
	}

	@Override
	public AdAcademicYear findByCode(String code) {
		return academicYearDao.findByCode(code);
	}

	@Override
	public void saveAcademicSession(AdAcademicSession academicSession) {
		academicSessionDao.save(academicSession, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
		LOG.info("saving academicSession");

		LOG.info("Start Broadcasting Academic Session Payload");
		
		AcademicSessionCodePayload payload = new AcademicSessionCodePayload();
		payload.setCode(academicSession.getCode());
		payload.setDescription(academicSession.getDescription());
		payload.setStartDate(academicSession.getStartDate());
		payload.setEndDate(academicSession.getEndDate());
		applicationContext.publishEvent(new AcademicSessionAddedEvent(payload));
		LOG.debug("Academic Session Code:{}",payload.getCode());
		LOG.info("Finish Broadcasting Academic Session Payload");
		
		
		
		
	}

	@Override
	public void updateAcademicSession(AdAcademicSession academicSession) {
		academicSessionDao.update(academicSession, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeAcademicSession(AdAcademicSession academicSession) {
		academicSessionDao.remove(academicSession, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	static int TWO = 2;

	public void calculateGpa(AdAdmission admission, AdEnrollmentStatus status) {
		LOG.debug("admission:{}", admission.getSession().getCode());
		LOG.debug("admission:{}", admission.getStudent().getName());

		BigDecimal hoursPerSemester = getHoursPerSemester(admission);
		BigDecimal pointHoursPerSemester = getPointHoursPerSemester(admission);

		BigDecimal hoursPerStudent = getHoursPerStudent(admission.getStudent());
		BigDecimal pointHoursPerStudent = getPointHoursPerStudent(admission.getStudent());

		BigDecimal gpa = pointHoursPerSemester.divide(hoursPerSemester, TWO, HALF_UP).setScale(TWO, HALF_UP);
		LOG.debug("GPA:{}", gpa);

		BigDecimal cgpa = pointHoursPerStudent.divide(hoursPerStudent, TWO, HALF_UP).setScale(TWO, HALF_UP);
		LOG.debug("CGPA:{}", cgpa);

		int creditEarned = hoursPerStudent.toBigInteger().intValue();
		int creditTaken = hoursPerStudent.toBigInteger().intValue();
		admission.setGpa(gpa);
		admission.setCgpa(cgpa);
		admission.setCreditEarned(creditEarned);
		admission.setCreditTaken(creditTaken);
		LOG.debug("creditEarned:{}", creditEarned);
		LOG.debug("creditTaken:{}", creditTaken);

		// Condition To Check Standing
		if (cgpa.doubleValue() >= 0.00 && cgpa.doubleValue() <= 2.99) {
			admission.setStanding(AdAcademicStanding.KG);
		} else if (cgpa.doubleValue() >= 3.00 && cgpa.doubleValue() <= 4.00) {
			admission.setStanding(AdAcademicStanding.KB);
		}

		termService.updateAdmission(admission);
		LOG.debug("Admission CGPA:{}", admission.getCgpa());
		LOG.debug("Admission Standing:{}", admission.getStanding().name());
	}

	private BigDecimal getCreditHour(AdEnrollment enrollment) {
		if (enrollment.getStatus().equals(AdEnrollmentStatus.CONFIRMED))
			LOG.debug("Enrollment:{}", enrollment.getGradeCode().getCode());
		LOG.debug("Enrollment:{}", enrollment.getSection().getCode());
		LOG.debug("Enrollment:{}", enrollment.getSection().getOffering().getTitleEn());

		LOG.debug("Enrollment Status:{}", enrollment.getStatus().name());
		// Offering
		AdOffering offering = enrollment.getSection().getOffering();
		LOG.debug("offering:{}", offering.getCanonicalCode());

		// Course
		AdCourse course = offering.getCourse();
		LOG.debug("Course:{}", course);

		// CreditHour
		Integer credit = course.getCredit();
		LOG.debug("credit:{}", credit);

		BigDecimal creditHour = new BigDecimal(credit);
		LOG.debug("CreditHour:{}", creditHour);

		return creditHour;
	}

	private BigDecimal getHoursPerSemester(AdAdmission admission) {
		BigDecimal hoursPerSemester = BigDecimal.ZERO;

		for (AdEnrollment enrollment : termService.findEnrollments(admission, AdEnrollmentStatus.CONFIRMED)) {
			hoursPerSemester = hoursPerSemester.add(getCreditHour(enrollment));
			LOG.debug("hoursPerSemester:{}", hoursPerSemester);
		}
		return hoursPerSemester;
	}

	private BigDecimal getPointHoursPerSemester(AdAdmission admission) {
		BigDecimal pointHoursPerSemester = BigDecimal.ZERO;

		for (AdEnrollment enrollment : termService.findEnrollments(admission, AdEnrollmentStatus.CONFIRMED)) {

			BigDecimal creditHour = getCreditHour(enrollment);

			AdGradeCode gradeCode = enrollment.getGradeCode();
			LOG.debug("gradeCode:{}", gradeCode.getCode());

			BigDecimal point = gradeCode.getPoint();
			BigDecimal pointHoursPerEnrollment = point.multiply(creditHour);

			pointHoursPerSemester = pointHoursPerSemester.add(pointHoursPerEnrollment);
			LOG.debug("pointHoursPerSemester:{}", pointHoursPerSemester);
		}
		return pointHoursPerSemester;
	}

	private BigDecimal getHoursPerStudent(AdStudent student) {
		BigDecimal hoursPerStudent = BigDecimal.ZERO;
		List<AdAdmission> admissions = findAdmissions(student);
		for (AdAdmission admission : admissions) {
			hoursPerStudent = hoursPerStudent.add(getHoursPerSemester(admission));
		}
		return hoursPerStudent;
	}

	private BigDecimal getPointHoursPerStudent(AdStudent student) {
		BigDecimal pointHoursPerStudent = BigDecimal.ZERO;
		for (AdAdmission admission : findAdmissions(student)) {
			pointHoursPerStudent = pointHoursPerStudent.add(getPointHoursPerSemester(admission));
		}
		return pointHoursPerStudent;
	}

	// todo(sam) Fix 2nd & 3rd params
	public List<AdAdmission> findAdmissions(AdStudent student) {
		return termService.findAdmissions(student);
	}

	// ====================================================================================================
	// CURRICULUM
	// ====================================================================================================

	@Override
	public AdCurriculum findCurriculumById(Long id) {
		return curriculumDao.findById(id);
	}

	@Override
	public AdCurriculum findCurriculumByCode(String code) {
		return curriculumDao.findByCode(code);
	}

	@Override
	public AdSubject findSubjectById(Long id) {
		return curriculumDao.findSubjectById(id);
	}

	@Override
	public AdBundleSubjectPart findBundleSubjectPartById(Long id) {
		return curriculumDao.findBundleSubjectPartById(id);
	}

	@Override
	public AdSubject findSubjects() {
		return curriculumDao.findSubjects();
	}

	@Override
	public AdSubject findSubjectByCurriculumAndCourse(AdCurriculum curriculum, AdCourse course) {
		return curriculumDao.findSubjectById(0L); // todo: dummy
	}

	@Override
	public AdSubject findSubject(AdCurriculum curriculum, AdSubjectType subjectType, Integer ordinal) {
		return curriculumDao.findSubject(curriculum, subjectType, ordinal);
	}

	@Override
	public List<AdCurriculum> findCurriculums(Integer offset, Integer limit) {
		return curriculumDao.find(offset, limit);
	}

	@Override
	public List<AdCurriculum> findCurriculums(String filter, Integer offset, Integer limit) {
		return curriculumDao.find(filter, offset, limit);
	}

	@Override
	public List<AdCurriculum> findCurriculums(AdProgram program) {
		return curriculumDao.find(program);
	}

	@Override
	public List<AdBundleSubject> findBundleSubjects(AdCurriculum curriculum, AdSubject subject) {
		return curriculumDao.findBundleSubjects(curriculum, subject);
	}

	@Override
	public AdBundleSubject findBundleSubjectById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (AdBundleSubject) session.get(AdBundleSubjectImpl.class, id);
	}

	@Override
	public List<AdBundleSubjectPart> findBundleSubjectPartByBundleSubject(AdBundleSubject bundle) {
		return curriculumDao.findBundleSubjectPartByBundleSubject(bundle);
	}

	@Override
	public List<AdCurriculum> findCurriculums(AdProgram program, Integer offset, Integer limit) {
		return curriculumDao.find(program, offset, limit);
	}

	@Override
	public List<AdSubject> findSubjects(AdCurriculum curriculum) {
		return subjectDao.find(curriculum);
	}

	@Override
	public List<AdSubject> findSubjectsBySubjectType(AdCurriculum curriculum, AdSubjectType subjectType) {
		return subjectDao.find(curriculum, subjectType);
	}

	// core elective
	@Override
	public List<AdSubject> findSubjectsByCurriculumAndSubjectTypeCoreElective(AdCurriculum curriculum,
			AdSubjectType subjectType) {
		return subjectDao.find(curriculum, subjectType);
	}

	@Override
	public List<AdSubject> findSubjectsByCurriculumAndSubjectTypeCore(AdCurriculum curriculum,
			AdSubjectType subjectType) {
		return subjectDao.find(curriculum, subjectType);
	}

	@Override
	public List<AdSubject> findSubjectsByCurriculumAndSubjectTypeElective(AdCurriculum curriculum,
			AdSubjectType subjectType) {
		return subjectDao.find(curriculum, subjectType);
	}

	@Override
	public List<AdSubject> findSubjects(String filter, AdCurriculum curriculum) {
		return null;
	}

	@Override
	public List<AdSubject> findSubjectByCourse(AdCourse course) {
		return null;
	}

	@Override
	public Integer countCurriculum() {
		return null;
	}

	@Override
	public Integer countCurriculum(String filter) {
		return null;
	}

	@Override
	public Integer countSubject(AdCurriculum curriculum) {
		return null;
	}

	@Override
	public boolean isCurriculumExists(String code) {
		return false;
	}

	@Override
	public boolean isSubjectExists(AdCourse course, AdCurriculum curriculum) {
		return false;
	}

	@Override
	public boolean hasCurriculum(AdProgram program) {
		return false;
	}

	@Override
	public void saveCurriculum(AdCurriculum curriculum) {
		curriculumDao.save(curriculum, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateCurriculum(AdCurriculum curriculum) {
		curriculumDao.update(curriculum, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeCurriculum(AdCurriculum curriculum) {
		curriculumDao.remove(curriculum, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addSubject(AdCurriculum curriculum, AdSubject subject) {
		curriculumDao.addSubject(curriculum, subject, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addSingleSubject(AdCurriculum curriculum, AdSubject subject) {
		curriculumDao.addSingleSubject(curriculum, subject, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addBundleSubject(AdCurriculum curriculum, AdSubject subject) {
		curriculumDao.addBundleSubject(curriculum, subject, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateSubject(AdCurriculum curriculum, AdSubject subject) {
		curriculumDao.updateSubject(curriculum, subject, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteSubject(AdCurriculum curriculum, AdSubject subject) {
		curriculumDao.deleteSubject(curriculum, subject, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part) {
		curriculumDao.addSubjectPart(subject, part, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part) {
		curriculumDao.deleteSubjectPart(subject, part, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addPrerequisites(AdCourse course, AdCourse... prereqCourses) {
		courseDao.addPrerequisites(course, securityService.getCurrentUser(), prereqCourses);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void updatePrerequisite(AdCourse course, AdCourse... prerequisites) {
		courseDao.updatePrerequisites(course, securityService.getCurrentUser(), prerequisites);
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void removePrerequisite(AdCourse course, AdCourse... prerequisites) {
		courseDao.removePrerequisites(course, securityService.getCurrentUser(), prerequisites);
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// COHORT
	// ====================================================================================================

	@Override
	public AdCohort findCohortByCode(String code) {
		return cohortDao.findByCode(code);
	}

	@Override
	public AdCohort findByParent(AdCohort parent) {
		return cohortDao.findByParent(parent);
	}

	@Override
	public AdCohort findCohortById(Long id) {
		return cohortDao.findById(id);
	}

	@Override
	public List<AdCohort> findCohortRoots() {
		return cohortDao.findRoots();
	}

	@Override
	public List<AdCohort> findCohorts(String filter, Integer offset, Integer limit) {
		return cohortDao.find(filter, offset, limit);
	}
	
	@Override
	public List<AdCohort> findCohorts(AdGraduateCenter graduateCenter) {
		return cohortDao.find(graduateCenter);
	}

	@Override
	public List<AdCohort> findCohorts(AdCurriculum curriculum, Integer offset, Integer limit) {
		return cohortDao.find(curriculum, offset, limit);
	}

	@Override
	public List<AdCohort> findCohorts(AdProgram program, Integer offset, Integer limit) {
		return cohortDao.find(program, offset, limit);
	}

	@Override
	public List<AdStudent> findStudents(AdCohort cohort) {
		return cohortDao.findStudents(cohort);
	}

	@Override
	public List<AdStudent> findStudents(AdCohort cohort, Integer offset, Integer limit) {
		return cohortDao.findStudents(cohort, offset, limit);
	}

	@Override
	public List<AdStudent> findStudents(String filter, AdCohort cohort, Integer offset, Integer limit) {
		return cohortDao.findStudents(filter, cohort, offset, limit);
	}

	@Override
	public Integer countCohort(String filter) {
		return cohortDao.count(filter);
	}

	@Override
	public Integer countCohort(AdCohort parent) {
		return cohortDao.count(parent);
	}

	@Override
	public Integer countStudent(AdCohort cohort) {
		return cohortDao.countStudent(cohort);
	}

	@Override
	public Integer countCohort(AdProgram program) {
		return cohortDao.count(program);
	}

	@Override
	public Integer countStudent(String filter, AdCohort cohort) {
		return cohortDao.countStudent(filter, cohort);
	}

	@Override
	public boolean isCohortExists(String code) {
		return cohortDao.isExists(code);
	}

	@Override
	public void saveCohort(AdCohort cohort) {
		cohortDao.save(cohort, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateCohort(AdCohort cohort) {
		cohortDao.update(cohort, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	@Override
	public void removeCohort(AdCohort cohort) {
		cohortDao.remove(cohort, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	// ====================================================================================================
	// FACULTY
	// ====================================================================================================

	@Override
	public AdFaculty findFacultyById(Long id) {
		return facultyDao.findById(id);
	}

	@Override
	public AdFaculty findFacultyByCode(String code) {
		return facultyDao.findByCode(code);
	}

	@Override
	public List<AdFaculty> findFaculties() {
		return facultyDao.find();
	}

	@Override
	public List<AdFaculty> findFaculties(Integer offset, Integer limit) {
		return facultyDao.find(offset, limit);
	}

	@Override
	public List<AdFaculty> findFaculties(String filter, Integer offset, Integer limit) {
		return facultyDao.find(filter, offset, limit);
	}

	@Override
	public List<AdFaculty> findFaculties(boolean authorized, String filter, Integer offset, Integer limit) {
		return facultyDao.find(filter, offset, limit); // TODO: authorized
	}

	@Override
	public Integer countFaculty() {
		return facultyDao.count();
	}

	@Override
	public Integer countFaculty(String filter) {
		return facultyDao.count(filter);
	}

	@Override
	public Integer countFaculty(boolean authorized, String filter) {
		return facultyDao.count(filter); // TODO: authorized
	}

	@Override
	public boolean isFacultyExists(String code) {
		return facultyDao.isExists(code);
	}

	@Override
	public void saveFaculty(AdFaculty faculty) {
		LOG.info("saving faculty");
		facultyDao.save(faculty, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateFaculty(AdFaculty faculty) {
		facultyDao.update(faculty, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeFaculty(AdFaculty faculty) {
		facultyDao.remove(faculty, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addProgram(AdFaculty faculty, AdProgram program) {
		LOG.debug("adding a program to faculty");
		facultyDao.addProgram(faculty, program, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateProgram(AdFaculty faculty, AdProgram program) {
		facultyDao.updateProgram(faculty, program, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeProgram(AdFaculty faculty, AdProgram program) {
		facultyDao.removeProgram(faculty, program, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	// ====================================================================================================
	// PROGRAM LEVEL
	// ====================================================================================================

	@Override
	public AdProgramLevel findProgramLevelById(Long id) {
		return programLevelDao.findById(id);
	}

	@Override
	public AdProgramLevel findProgramLevelByCode(String code) {
		return programLevelDao.findByCode(code);
	}

	@Override
	public List<AdProgramLevel> findProgramLevels() {
		return programLevelDao.find();
	}

	@Override
	public List<AdProgramLevel> findProgramLevels(Integer offset, Integer limit) {
		return programLevelDao.find(offset, limit);
	}

	@Override
	public List<AdProgramLevel> findProgramLevels(String filter, Integer offset, Integer limit) {
		return programLevelDao.find(filter, offset, limit);
	}

	@Override
	public Integer countProgramLevel() {
		return programLevelDao.count();
	}

	@Override
	public Integer countProgramLevel(String filter) {
		return programLevelDao.count(filter);
	}

	@Override
	public void saveProgramLevel(AdProgramLevel level) {
		programLevelDao.save(level, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateProgramLevel(AdProgramLevel level) {
		programLevelDao.update(level, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeProgramLevel(AdProgramLevel level) {
		programLevelDao.remove(level, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// PROGRAM
	// ====================================================================================================

	@Override
	public AdProgram findProgramById(Long id) {
		return programDao.findById(id);
	}

	@Override
	public AdProgram findProgramByCode(String code) {
		return programDao.findByCode(code);
	}

	@Override
	public AdProgram findProgramByCodeAndFaculty(String code, AdFaculty faculty) {
		return programDao.findByCodeAndFaculty(code, faculty);
	}

	@Override
	public List<AdProgram> findPrograms(String filter) {
		return programDao.find(filter);
	}

	@Override
	public List<AdProgram> findPrograms(Integer offset, Integer limit) {
		return programDao.find(offset, limit);
	}

	@Override
	public List<AdProgram> findPrograms(String filter, Integer offset, Integer limit) {
		return programDao.find(filter, offset, limit);
	}

	@Override
	public List<AdProgram> findPrograms(AdFaculty faculty) {
		return programDao.find(faculty);
	}
	
	@Override
	public List<AdProgram> findPrograms(AdGraduateCenter graduateCenter) {
		return programDao.find(graduateCenter);
	}

	@Override
	public List<AdProgram> findPrograms(AdProgramType type, AdFaculty faculty) {
		return programDao.find(type, faculty);
	}

	@Override
	public List<AdProgram> findPrograms(AdFaculty faculty, Integer offset, Integer limit) {
		return programDao.find(faculty, offset, limit);
	}

	@Override
	public List<AdProgram> findPrograms(AdProgramType type, AdFaculty faculty, Integer offset, Integer limit) {
		return programDao.find(type, faculty, offset, limit);
	}

	@Override
	public List<AdProgram> findPrograms(String filter, AdFaculty faculty, Integer offset, Integer limit) {
		return programDao.find(filter, faculty, offset, limit);
	}

	@Override
	public List<AdProgram> findPrograms(String filter, AdProgramType type, AdFaculty faculty, Integer offset,
			Integer limit) {
		return programDao.find(filter, type, faculty, offset, limit);
	}

	@Override
	public Integer countProgram() {
		return programDao.count();
	}

	@Override
	public Integer countProgram(String filter) {
		return programDao.count(filter);
	}

	@Override
	public Integer countProgram(String filter, AdFaculty faculty) {
		return programDao.count(filter, faculty);
	}

	@Override
	public Integer countProgram(String filter, AdProgramType type, AdFaculty faculty) {
		return programDao.count(filter, type, faculty);
	}

	@Override
	public Integer countProgram(AdFaculty faculty) {
		return programDao.count(faculty);
	}

	@Override
	public Integer countProgram(AdProgramType type, AdFaculty faculty) {
		return programDao.count(type, faculty);
	}

	@Override
	public boolean isProgramExists(String code, AdFaculty faculty) {
		return programDao.isExists(code, faculty);
	}

	@Override
	public void saveProgram(AdProgram program) {
		programDao.save(program, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

//		AdFaculty faculty = facultyDao.findByCode(program.getFaculty().getCode());
//
//		LOG.debug("Start Broadcast Program");
//		// Prepare Faculty Payload
//		LOG.debug("prepare payload");
//		FacultyCodePayload f = new FacultyCodePayload();
//		f.setCode(faculty.getCode());
//		f.setDescription(faculty.getDescription());
//		// Prepare Program Level Payload
//		ProgramLevelPayload l = new ProgramLevelPayload();
//		l.setCode(program.getLevel().getCode());
//		l.setDescription(program.getLevel().getDescription());
//		// Prepare Program Payload
//		ProgramCodePayload p = new ProgramCodePayload();
//		p.setCode(program.getCode());
//		p.setDescriptionMs(program.getTitleMs());
//		p.setDescriptionEn(program.getTitleEn());
//		p.setFacultyCode(f);
//		p.setProgramLevel(l);
//
//		ProgramAddedEvent event = new ProgramAddedEvent(p);
//		applicationContext.publishEvent(event);
//		LOG.debug("Finsh Broadcast Program");
	}

	@Override
	public void updateProgram(AdProgram program) {
		programDao.update(program, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeProgram(AdProgram program) {
		programDao.remove(program, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// COURSE
	// ====================================================================================================

	@Override
	public AdCourse findCourseById(Long id) {
		return courseDao.findById(id);
	}

	@Override
	public AdCourse findCourseByCode(String code) {
		return courseDao.findByCode(code);
	}

	@Override
	public AdCourse findCourseByCodeAndFaculty(String code, AdFaculty faculty) {
		return courseDao.findByCodeAndFaculty(code, faculty);
	}

	@Override
	public List<AdCourse> findAvailableCourses(AdAcademicSession academicSession, Integer offset, Integer limit) {
		return courseDao.findAvailable(academicSession, offset, limit);
	}

	@Override
	public List<AdCourse> findCourses(Integer offset, Integer limit) {
		return courseDao.find(offset, limit);
	}

	@Override
	public List<AdCourse> findCourses(String filter, Integer offset, Integer limit) {
		return courseDao.find(filter, offset, limit);
	}

	@Override
	public List<AdCourse> findCourses(AdFaculty faculty) {
		return courseDao.find(faculty);
	}
	
	@Override
	public List<AdCourse> findCourses(AdGraduateCenter graduateCenter) {
		return courseDao.find(graduateCenter);
	}

	@Override
	public List<AdCourse> findCourses(String filter, AdFaculty faculty, Integer offset, Integer limit) {
		return courseDao.find(filter, faculty, offset, limit);
	}

	@Override
	public Integer countCourse() {
		return courseDao.count();
	}

	@Override
	public Integer countCourse(String filter) {
		return courseDao.count(filter);
	}

	@Override
	public Integer countCourse(AdFaculty faculty) {
		return courseDao.count(faculty);
	}

	@Override
	public Integer countCourse(String filter, AdFaculty faculty) {
		return courseDao.count(filter, faculty);
	}

	@Override
	public Integer countCourse(boolean authorized, String filter) {
		return courseDao.count(filter);
	}

	@Override
	public Integer countAvailableCourse(AdAcademicSession academicSession) {
		return courseDao.count();// TODO:
	}

	@Override
	public boolean isCourseExists(String code, AdFaculty faculty) {
		return courseDao.isExists(code, faculty);
	}

	/*
	 * @Override public void saveCourse(AdCourse course, AdFaculty faculty) {
	 * courseDao.save(course, securityService.getCurrentUser());
	 * sessionFactory.getCurrentSession().flush(); }
	 */

	@Override
	public void updateCourse(AdCourse course) {
		courseDao.update(course, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeCourse(AdCourse course) {
		courseDao.remove(course, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateCourse(AdFaculty faculty, AdCourse course) {
		facultyDao.updateCourse(faculty, course, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void removeCourse(AdFaculty faculty, AdCourse course) {
		facultyDao.removeCourse(faculty, course, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	// ====================================================================================================
	// ACADEMIC YEAR
	// ====================================================================================================

	@Override
	public AdAcademicYear findAcademicYearByCode(String code) {
		return academicYearDao.findByCode(code);
	}

	@Override
	public void saveAcademicYear(AdAcademicYear year) {
		yearDao.save(year, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void updateAcademicYear(AdAcademicYear academicYear) {
		academicYearDao.update(academicYear, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

	// remove academicYear
	@Override
	public void removeAcademicYear(AdAcademicYear academicYear) {
		academicYearDao.delete(academicYear, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public boolean isAcademicYearExists(String code) {
		return academicYearDao.isExists(code);
	}

	@Override
	public List<AdAcademicYear> findAcademicYears(Integer offset, Integer limit) {
		return academicYearDao.find(offset, limit);
	}

	@Override
	public List<AdAcademicYear> findAcademicYears(String filter, Integer offset, Integer limit) {
		return academicYearDao.find(filter, offset, limit);
	}

	@Override
	public void saveCourse(AdCourse course) {
		courseDao.save(course, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addCourse(AdFaculty faculty, AdCourse course) {
		facultyDao.addCourse(faculty, course, securityService.getCurrentUser());
		sessionFactory.getCurrentSession().flush();

	}

}
