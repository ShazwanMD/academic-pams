package my.edu.umk.pams.academic.calendar.model;

import my.edu.umk.pams.academic.common.model.AdStudyCenter;
import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;

import java.util.Date;

/**
 * @author PAMS
 */
public interface AdAcademicCalendar extends AdMetaObject {

    Date getAcademicDate();

    void setAcademicDate(Date academicDate);

    AdAcademicCalendarType getCalendarType();

    void setCalendarType(AdAcademicCalendarType calendarType);

    String getDescription();

    void setDescription(String description);

    AdStudyCenter getStudyCenter();

    void setStudyCenter(AdStudyCenter studyCenter);

    AdAcademicSession getSession();

    void setSession(AdAcademicSession session);

}
