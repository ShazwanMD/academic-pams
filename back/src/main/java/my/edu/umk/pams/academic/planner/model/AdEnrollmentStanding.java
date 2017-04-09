package my.edu.umk.pams.academic.planner.model;

/**
 * @author PAMS
 */
public enum AdEnrollmentStanding {

    UM("Ulang Kursus"), // DS - daftar semula bila kursus gagal
    UG("Ulang Gred"),   // DS - daftar semula untuk improve gred
    HS("Hadir Sahaja"),   // tak perlu ada
    HW("Hadir Wajib"),		// tak perlu ada
    MN("Kursus Minor");		//tak perlu ada

    private String description;

    AdEnrollmentStanding(String description) {
        this.description = description;
    }

}
