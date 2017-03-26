package my.edu.umk.pams.academic.planner.model;

/**
 * Semester Lazim
 *
 * @author PAMS
 */
public enum AdAcademicPeriod {
    I,
    II,
    III,
    IV,
    V,
    VI,
    VII,
    VIII;

    public static AdAcademicPeriod get(Integer index) {
        return values()[index];
    }
}
