package my.edu.umk.pams.academic.studyplan.model;

/**
 * @author PAMS
 */
public enum AdAppointmentStatus {
    NEW("Baru"),
    CONFIRMED("Confirmed"),
    SUBSTITUTED("Diganti"),
    DISMISSED("Dilepaskan");

    private String description;

    AdAppointmentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
