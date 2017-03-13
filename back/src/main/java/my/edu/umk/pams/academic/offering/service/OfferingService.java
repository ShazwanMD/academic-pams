package my.edu.umk.pams.academic.offering.service;

import my.edu.umk.pams.academic.offering.model.AdOffering;
import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdCourse;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;
import my.edu.umk.pams.academic.studyplan.model.AdSection;

import java.util.List;

/**
 * @author PAMS
 */
public interface OfferingService {

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
