package my.edu.umk.pams.academic.studyplan.service;

import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.studyplan.model.*;

import java.util.List;

/**
 * @author PAMS
 */
public interface StudyplanService {

    //====================================================================================================
    // ACADEMIC SESSION
    //====================================================================================================

    AdAcademicSession findAcademicSessionById(Long id);

    AdAcademicSession findAcademicSessionByCode(String code);

    AdAcademicSession findCurrentAcademicSession();

    List<AdAcademicSession> findAcademicSessions(Integer offset, Integer limit);

    List<AdAcademicSession> findAcademicSessions(String filter, Integer offset, Integer limit);

    Integer countAcademicSession();

    Integer countAcademicSession(String filter);

    boolean isAcademicSessionCodeExists(String code);

    void saveAcademicSession(AdAcademicSession academicSession);

    void updateAcademicSession(AdAcademicSession academicSession);

    void removeAcademicSession(AdAcademicSession academicSession);


    //====================================================================================================
    // COHORT
    //====================================================================================================

    AdCohort findCohortByCode(String code);

    AdCohort findByParent(AdCohort parent);

    List<AdCohort> findCohortRoots();

    List<AdCohort> findCohorts(String filter, Integer offset, Integer limit);

    List<AdCohort> findCohorts(AdCohort parent, Integer offset, Integer limit);

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
    // PROGRAM
    //====================================================================================================

    AdProgram findProgramById(Long id);

    AdProgram findProgramByCode(String code);

    AdProgram findProgramByCodeAndFaculty(String code, AdFaculty faculty);

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

    //====================================================================================================
    // OFFERING
    //====================================================================================================

    AdOffering findOfferingById(Long id);

    AdOffering findOfferingByCanonicalCode(String canonicalCode);

    AdOffering findOfferingByProgramAndCourse(AdProgram program, AdCourse course);

    AdAcademicSession findLastOfferedOffering(AdAcademicSession current, AdCourse course);

    List<AdOffering> findOfferings(Integer offset, Integer limit);

    List<AdOffering> findOfferings(String filter, Integer offset, Integer limit);

    List<AdOffering> findOfferings(AdProgram program);

    List<AdOffering> findOfferings(AdProgram program, Integer offset, Integer limit);

    List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdOffering> findOfferings(String filter, AdAcademicSession academicSession, AdProgram program, Integer offset, Integer limit);

    List<AdOffering> findRunningOfferings(AdAcademicSession session);

    Integer countOffering(String filter);

    Integer countOffering(AdProgram program);

    Integer countOffering(AdCourse course);

    Integer countOffering(boolean authorized, String filter);

    Integer countOffering(boolean authorized, String filter, AdProgram program);

    Integer countOfferingWithSection(boolean authorized, String filter);

    Integer countOfferingWithSection(boolean authorized, String filter, AdAcademicSession session);

    boolean isOfferingExists(AdProgram program, AdCourse course);

    //====================================================================================================
    // SECTION
    //====================================================================================================

    AdSection findSectionById(Long id);

    AdSection findSectionByCanonicalCode(String canonicalCode);

    List<AdSection> findSections(Integer offset, Integer limit);

    List<AdSection> findSections(String filter, AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdSection> findSections(AdOffering offering);

    List<AdSection> findSections(AdAcademicSession academicSession);

    List<AdSection> findSections(AdAcademicSession academicSession, Integer offset, Integer limit);

    List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering);

    List<AdSection> findSections(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdSection> findSections(String filter, AdAcademicSession academicSession, AdAdmission admission, Integer offset, Integer limit);

    Integer countSection();

    Integer countSection(String filter, AdAcademicSession academicSession);

    Integer countSection(AdOffering offering);

    Integer countSection(AdAcademicSession academicSession);

    Integer countSection(AdAcademicSession academicSession, AdOffering offering);

    Integer countSection(String filter, AdAcademicSession academicSession, AdAdmission admission);

    Integer countAvailableStaff(AdOffering offering);

    Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering);

    boolean hasSection(AdAcademicSession academicSession);

    boolean hasSection(AdAcademicSession academicSession, AdOffering offering);

    boolean isSectionExists(String canonicalCode);



}
