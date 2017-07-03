package my.edu.umk.pams.academic.planner.service;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.*;
import my.edu.umk.pams.academic.web.module.planner.vo.AcademicYear;

import java.util.List;

/**
 * @author PAMS
 */
public interface PlannerService {

    //====================================================================================================
    // ACADEMIC SESSION
    //====================================================================================================

    AdAcademicSession findAcademicSessionById(Long id);

    AdAcademicSession findAcademicSessionByCode(String code);

    AdAcademicSession findCurrentAcademicSession();

    List<AdAcademicSession> findAcademicSessions(Integer offset, Integer limit);

    List<AdAcademicSession> findAcademicSessions(String filter, Integer offset, Integer limit);

	AdAcademicYear findByCode(String code);
    
    Integer countAcademicSession();

    Integer countAcademicSession(String filter);

    boolean isAcademicSessionCodeExists(String code);

    void saveAcademicSession(AdAcademicSession academicSession);

    void updateAcademicSession(AdAcademicSession academicSession);

    void removeAcademicSession(AdAcademicSession academicSession);

    //====================================================================================================
    // CURRICULUM
    //====================================================================================================

    AdCurriculum findCurriculumById(Long id);

    AdCurriculum findCurriculumByCode(String code);

    AdSubject findSubjectById(Long id);
    
    AdSubject findSubjectByCurriculum(AdCurriculum curriculum);

    AdSubject findSubjectByCurriculumAndCourse(AdCurriculum curriculum, AdCourse course);

    List<AdCurriculum> findCurriculums(Integer offset, Integer limit);

    List<AdCurriculum> findCurriculums(String filter, Integer offset, Integer limit);

    List<AdCurriculum> findCurriculums(AdProgram program);

    List<AdCurriculum> findCurriculums(AdProgram program, Integer offset, Integer limit);

    List<AdSubject> findSubjects(AdCurriculum curriculum);

    List<AdSubject> findSubjects(String filter, AdCurriculum curriculum);

    List<AdSubject> findSubjectByCourse(AdCourse course);

    Integer countCurriculum();

    Integer countCurriculum(String filter);

    Integer countSubject(AdCurriculum curriculum);

    boolean isCurriculumExists(String code);

    boolean isSubjectExists(AdCourse course, AdCurriculum curriculum);

    boolean hasCurriculum(AdProgram program);

    void saveCurriculum(AdCurriculum curriculum);

    void updateCurriculum(AdCurriculum curriculum);

    void removeCurriculum(AdCurriculum curriculum);

    void addSubject(AdCurriculum curriculum, AdSubject subject);

    void updateSubject(AdCurriculum curriculum, AdSubject subject);

    void deleteSubject(AdCurriculum curriculum, AdSubject subject);

    void addSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part);

    void deleteSubjectPart(AdBundleSubject subject, AdBundleSubjectPart part);

    void addPrerequisites(AdCourse course, AdCourse... prerequisites);
    
    void updatePrerequisite(AdCourse course, AdCourse... prerequisites);
    
    void removePrerequisite(AdCourse course, AdCourse... prerequisites);

    //====================================================================================================
    // COHORT
    //====================================================================================================

    AdCohort findCohortByCode(String code);

    @Deprecated
    AdCohort findByParent(AdCohort parent);

    AdCohort findCohortById(Long id);

    List<AdCohort> findCohortRoots();

    List<AdCohort> findCohorts(String filter, Integer offset, Integer limit);

    List<AdCohort> findCohorts(AdCurriculum curriculum, Integer offset, Integer limit);

    List<AdCohort> findCohorts(AdProgram program, Integer offset, Integer limit);

    List<AdStudent> findStudents(AdCohort cohort);

    List<AdStudent> findStudents(AdCohort cohort, Integer offset, Integer limit);

    List<AdStudent> findStudents(String filter, AdCohort cohort, Integer offset, Integer limit);

    Integer countCohort(String filter);

    Integer countCohort(AdCohort parent);

    Integer countStudent(AdCohort cohort);

    Integer countCohort(AdProgram program);

    Integer countStudent(String filter, AdCohort cohort);

    boolean isCohortExists(String code);

    void saveCohort(AdCohort cohort);

    void updateCohort(AdCohort cohort);

    void removeCohort(AdCohort cohort);
    
    

    //====================================================================================================
    // FACULTY
    //====================================================================================================

    AdFaculty findFacultyById(Long id);

    AdFaculty findFacultyByCode(String code);

    List<AdFaculty> findFaculties();

    List<AdFaculty> findFaculties(Integer offset, Integer limit);

    List<AdFaculty> findFaculties(String filter, Integer offset, Integer limit);

    List<AdFaculty> findFaculties(boolean authorized, String filter, Integer offset, Integer limit);

    Integer countFaculty();

    Integer countFaculty(String filter);

    Integer countFaculty(boolean authorized, String filter);

    boolean isFacultyExists(String code);

    void saveFaculty(AdFaculty faculty);

    void updateFaculty(AdFaculty faculty);

    void removeFaculty(AdFaculty faculty);

    void addProgram(AdFaculty faculty, AdProgram program);

    void updateProgram(AdFaculty faculty, AdProgram program);

    void removeProgram(AdFaculty faculty, AdProgram program);

    void addCourse(AdFaculty faculty, AdCourse course);

    void updateCourse(AdFaculty faculty, AdCourse course);

    void removeCourse(AdFaculty faculty, AdCourse course);

    //====================================================================================================
    // INTAKE LEVEL
    //====================================================================================================

    AdProgramLevel findProgramLevelById(Long id);

    List<AdProgramLevel> findProgramLevels();

    List<AdProgramLevel> findProgramLevels(Integer offset, Integer limit);

    List<AdProgramLevel> findProgramLevels(String filter, Integer offset, Integer limit);

    Integer countProgramLevel();

    Integer countProgramLevel(String filter);

    void saveProgramLevel(AdProgramLevel level);

    void updateProgramLevel(AdProgramLevel level);

    void removeProgramLevel(AdProgramLevel level);

    
    //====================================================================================================
    // PROGRAM
    //====================================================================================================

    AdProgram findProgramById(Long id);

    AdProgram findProgramByCode(String code);

    AdProgram findProgramByCodeAndFaculty(String code, AdFaculty faculty);
    
    AdProgramLevel findProgramLevelByCode(String code);

    List<AdProgram> findPrograms(String filter);

    List<AdProgram> findPrograms(Integer offset, Integer limit);

    List<AdProgram> findPrograms(String filter, Integer offset, Integer limit);

    List<AdProgram> findPrograms(AdFaculty faculty);

    List<AdProgram> findPrograms(AdProgramType type, AdFaculty faculty);

    List<AdProgram> findPrograms(AdFaculty faculty, Integer offset, Integer limit);

    List<AdProgram> findPrograms(AdProgramType type, AdFaculty faculty, Integer offset, Integer limit);

    List<AdProgram> findPrograms(String filter, AdFaculty faculty, Integer offset, Integer limit);

    List<AdProgram> findPrograms(String filter, AdProgramType type, AdFaculty faculty, Integer offset, Integer limit);

    Integer countProgram();

    Integer countProgram(String filter);

    Integer countProgram(String filter, AdFaculty faculty);

    Integer countProgram(String filter, AdProgramType type, AdFaculty faculty);

    Integer countProgram(AdFaculty faculty);

    Integer countProgram(AdProgramType type, AdFaculty faculty);

    boolean isProgramExists(String code, AdFaculty faculty);
    
    void saveProgram(AdProgram program);

    void updateProgram(AdProgram program);

    void removeProgram(AdProgram program);

    //====================================================================================================
    // COURSE
    //====================================================================================================
    AdCourse findCourseById(Long id);

    AdCourse findCourseByCode(String code);

    AdCourse findCourseByCodeAndFaculty(String code, AdFaculty faculty);

    List<AdCourse> findAvailableCourses(AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdCourse> findCourses(Integer offset, Integer limit);

    List<AdCourse> findCourses(String filter, Integer offset, Integer limit);

    List<AdCourse> findCourses(AdFaculty faculty);

    List<AdCourse> findCourses(String filter, AdFaculty faculty, Integer offset, Integer limit);

    Integer countCourse();

    Integer countCourse(String filter);

    Integer countCourse(AdFaculty faculty);

    Integer countCourse(String filter, AdFaculty faculty);

    Integer countCourse(boolean authorized, String filter);

    Integer countAvailableCourse(AdAcademicSession academicSession);

    boolean isCourseExists(String code, AdFaculty faculty);
    
    void saveCourse(AdCourse course , AdFaculty faculty);

    void updateCourse(AdCourse course);

    void removeCourse(AdCourse course);

 
  //====================================================================================================
    // ACADEMIC YEAR
    //====================================================================================================
    List<AdAcademicYear> findAcademicYears(Integer offset, Integer limit);

    List<AdAcademicYear> findAcademicYears(String filter, Integer offset, Integer limit);
    
    void saveAcademicYear(AdAcademicYear year);

}
