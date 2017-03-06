package my.edu.umk.pams.academic.studyplan.model;

/**
 * MAJOR/MINOR
 * TANGGUH/GANTUNG/BATAL
 * DAFTAR SEMULA DS
 *
 * @author PAMS
 */
public enum AdAdmissionStatus {

    ADMITTED("BERDAFTAR"),
    POSTPONED("TANGGUH"),
    SUSPENDED("GANTUNG"),
    CANCELLED("BATAL");

    private String description;

    AdAdmissionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
