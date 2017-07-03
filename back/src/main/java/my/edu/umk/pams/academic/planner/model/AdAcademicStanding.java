package my.edu.umk.pams.academic.planner.model;

/**
 * Kedudukan Baik (KB) PNGK ≥ 2.00
 * Kedudukan Bersyarat (KS) 1.70 ≤ PNGK < 2.00
 * Kedudukan Gagal (KG) PNGK < 1.70
 * (Diberhentikan)
 *
 * @author PAMS
 */
public enum AdAcademicStanding {

    KB("Kedudukan Baik"),
    KS("Kedudukan Bersyarat"),
    KG("Kedudukan Gagal"),
    TBD("To Be Determined");

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
    
    public static AdAcademicStanding get(int index) {
        return values()[index];
    }
}


