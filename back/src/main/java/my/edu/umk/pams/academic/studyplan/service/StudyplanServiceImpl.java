package my.edu.umk.pams.academic.studyplan.service;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.studyplan.dao.*;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author PAMS
 */
@Service
public class StudyplanServiceImpl implements StudyplanService {

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

    //====================================================================================================
    // ACADEMIC SESSION
    //====================================================================================================

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
    public void saveAcademicSession(AdAcademicSession academicSession) {
        academicSessionDao.save(academicSession, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
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

    //====================================================================================================
    // COHORT
    //====================================================================================================

    @Override
    public AdCohort findCohortByCode(String code) {
        return cohortDao.findByCode(code);
    }

    @Override
    public AdCohort findByParent(AdCohort parent) {
        return cohortDao.findByParent(parent);
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
    public List<AdCohort> findCohorts(AdCohort parent, Integer offset, Integer limit) {
        return cohortDao.find(parent, offset, limit);
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

    //====================================================================================================
    // FACULTY
    //====================================================================================================

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

    
    @Override
    public void addCourse(AdFaculty faculty, AdCourse course) {
        facultyDao.addCourse(faculty, course, securityService.getCurrentUser());
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

    //====================================================================================================
    // PROGRAM
    //====================================================================================================

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
    public List<AdProgram> findPrograms(String filter, AdProgramType type, AdFaculty faculty, Integer offset, Integer limit) {
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



    //====================================================================================================
    // COURSE
    //====================================================================================================

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

    //====================================================================================================
    // OFFERING
    //====================================================================================================

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
    public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, Integer offset, Integer limit) {
        return offeringDao.find(filter, offset, limit);
    }

    @Override
    public List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, AdProgram program, Integer offset, Integer limit) {
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

    //====================================================================================================
    // SECTION
    //====================================================================================================

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
    public List<AdSection> findSections(String filter, AdAcademicSession academicSession, Integer offset, Integer limit) {
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
    public List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        return sectionDao.find(academicSession, offering, offset, limit);
    }

    @Override
    public List<AdSection> findSections(String filter, AdAcademicSession academicSession, AdAdmission admission, Integer offset, Integer limit) {
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
