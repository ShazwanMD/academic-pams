package my.edu.umk.pams.academic.studyplan.service;

import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

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

}
