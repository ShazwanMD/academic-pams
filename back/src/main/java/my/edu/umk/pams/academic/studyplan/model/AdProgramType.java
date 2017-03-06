package my.edu.umk.pams.academic.studyplan.model;

/**
 * @author PAMS
 */
public enum AdProgramType {

    CERTIFICATE, // 0
    DIPLOMA,     // 1
    BACHELOR,    // 2
    MASTER,      // 3
    PHD;         // 4

    public static AdProgramType get(int index) {
        return values()[index];
    }

}
