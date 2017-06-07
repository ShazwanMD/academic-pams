package my.edu.umk.pams.academic.web.module.term.vo;

/**
 * @author PAMS
 */
public enum EnrollmentApplicationAction {
    ADD,
    DROP;

    public static EnrollmentApplicationAction get(int index) {
        return values()[index];
    }
}
