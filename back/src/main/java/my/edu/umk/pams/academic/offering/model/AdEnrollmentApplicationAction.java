package my.edu.umk.pams.academic.offering.model;

/**
 * @author rafizan.baharum@canang.com.my
 */
public enum AdEnrollmentApplicationAction {

    ADD,
    DROP;

    public static AdEnrollmentApplicationAction get(int index) {
        return values()[index];
    }


}
