package my.edu.umk.pams.academic.calendar.dao;


import my.edu.umk.pams.academic.calendar.model.AdProcessCalendar;
import my.edu.umk.pams.academic.calendar.model.AdProcessCalendarType;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdProcessCalendarDao extends GenericDao<Long, AdProcessCalendar> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdProcessCalendar findByProcessTypeSessionAndCampus(AdProcessCalendarType processType, AdAcademicSession academicSession, AdStudyCenter studyCenter);

    List<AdProcessCalendar> find(Integer offset, Integer limit);

    List<AdProcessCalendar> find(AdAcademicSession academicSession, AdStudyCenter studyCenter, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    boolean isExist(AdProcessCalendarType processType, AdAcademicSession academicSession, AdStudyCenter studyCenter);

}
