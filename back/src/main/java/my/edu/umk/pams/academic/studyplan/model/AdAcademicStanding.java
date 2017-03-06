package my.edu.umk.pams.academic.studyplan.model;

/**
 * Kedudukan Baik (KB) PNGK ≥ 2.00
 * Kedudukan Bersyarat (KS) 1.70 ≤ PNGK < 2.00
 * Kedudukan Gagal (KG) PNGK < 1.70
 * (Diberhentikan)
 *
 * @author PAMS
 */
public enum AdAcademicStanding {

    TBD("To Be Determined"),
    KB("Kedudukan Baik"),
    KS("Kedudukan Bersyarat"),
    KG("Kedudukan Gagal");

    private String description;

    AdAcademicStanding(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


