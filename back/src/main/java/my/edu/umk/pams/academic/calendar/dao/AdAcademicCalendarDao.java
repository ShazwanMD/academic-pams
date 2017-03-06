package my.edu.umk.pams.academic.calendar.dao;


import my.edu.umk.pams.academic.calendar.model.AdAcademicCalendar;
import my.edu.umk.pams.academic.calendar.model.AdAcademicCalendarType;
import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

import java.util.Date;
import java.util.List;

/**
 * @author PAMS
 */
public interface AdAcademicCalendarDao extends GenericDao<Long, AdAcademicCalendar> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAcademicCalendar find(Date date, AdAcademicSession academicSession, AdStudyCenter studyCenter);

    List<AdAcademicCalendar> find(AdAcademicSession academicSession, AdStudyCenter studyCenter);

    List<AdAcademicCalendar> find(AdAcademicSession academicSession, AdStudyCenter studyCenter, Integer offset, Integer limit);

    List<AdAcademicCalendar> find(Date date);

    List<AdAcademicCalendar> find();

    List<AdAcademicCalendar> findByType(AdAcademicCalendarType type);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer countDate(AdAcademicCalendar academicDate);

    Integer countWeekday(Date startDate, Date endDate, AdStudyCenter studyCenter);

    Integer countWeekend(Date startDate, Date endDate, AdStudyCenter studyCenter);

    Integer countHoliday(Date startDate, Date endDate, AdStudyCenter studyCenter);

    boolean isAcademicDay(Date givenDate);

    boolean isWeekend(Date givenDate, AdStudyCenter studyCenter);

    boolean isHoliday(Date givenDate, AdStudyCenter studyCenter);

    boolean isExist(AdAcademicSession academicSession, AdStudyCenter studyCenter);

    // ====================================================================================================
    // CRUDS
    // ====================================================================================================
}
