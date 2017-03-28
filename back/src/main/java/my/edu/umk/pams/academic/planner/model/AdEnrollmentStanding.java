package my.edu.umk.pams.academic.planner.model;

/**
 * @author PAMS
 */
public enum AdEnrollmentStanding {

    UM("Ulang Kursus"), // DS - daftar semula bila kursus gagal
    UG("Ulang Gred"),   // DS - daftar semula untuk improve gred
    HS("Hadir Sahaja"),
    HW("Hadir Wajib"),
    MN("Kursus Minor");

    private String description;

    AdEnrollmentStanding(String description) {
        this.description = description;
    }

}
