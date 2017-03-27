package my.edu.umk.pams.academic.calendar.model;

/**
 * @author PAMS
 */
public enum AdAcademicCalendarType {

    ACADEMIC_DAY,    // 0

    WEEKEND,    // 1

    HOLIDAY;    // 2

    public static AdAcademicCalendarType get(int index) {
        return values()[index];
    }

}
