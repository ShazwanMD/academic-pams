package my.edu.umk.pams.academic.planner.model;

/**
 * @author PAMS
 */
public enum AdEnrollmentStanding {

    UM("Ulang Kursus"), // DS - daftar semula
    UG("Ulang Gred"),   // DS - daftar semula
    HS("Hadir Sahaja"),
    HW("Hadir Wajib"),
    MN("Kursus Minor");

    private String description;

    AdEnrollmentStanding(String description) {
        this.description = description;
    }

}
