package my.edu.umk.pams.academic.planner.service;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.dao.*;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.security.service.SecurityService;
import my.edu.umk.pams.academic.term.dao.AdAssessmentDao;
import my.edu.umk.pams.academic.term.dao.AdOfferingDao;
import my.edu.umk.pams.academic.term.dao.AdSectionDao;
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
	public AdAcademicYear findByCode(String code) {
		return academicYearDao.findByCode(code);
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
    // CURRICULUM
    //====================================================================================================

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
    public AdSubject findSubjectByCurriculumAndCourse(AdCurriculum curriculum, AdCourse course) {
        return null;
    }

    @Override
    public List<AdCurriculum> findCurriculums(Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<AdCurriculum> findCurriculums(String filter, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<AdCurriculum> findCurriculums(AdProgram program) {
    	 return curriculumDao.find(program);
    }

    @Override
    public List<AdCurriculum> findCurriculums(AdProgram program, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<AdSubject> findSubjects(AdCurriculum curriculum) {
        return null;
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

    
    

    //====================================================================================================
    // PROGRAM LEVEL
    //====================================================================================================

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
    
    @Override
    public void saveCourse(AdCourse course, AdFaculty faculty) {
    	courseDao.save(course, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
    }
    
    
//	@Override
//	public void addCourse(AdCourse course) {
//		courseDao.save(course, securityService.getCurrentUser());
//        sessionFactory.getCurrentSession().flush();
//	}

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
    
    
//    @Override
//    public void addCourse(AdFaculty faculty, AdCourse course) {
//        facultyDao.addCourse(faculty, course, securityService.getCurrentUser());
//        sessionFactory.getCurrentSession().flush();
//    }

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
    // ACADEMIC YEAR
    //====================================================================================================

    @Override
    public void saveAcademicYear(AdAcademicYear year) {
    	yearDao.save(year, securityService.getCurrentUser());
        sessionFactory.getCurrentSession().flush();
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
	public void addCourse(AdFaculty faculty, AdCourse course) {
		// TODO Auto-generated method stub
		
	}


}
