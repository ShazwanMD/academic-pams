package my.edu.umk.pams.academic.studyplan.model;

/**
 * http://www.usc.edu/dept/ARR/glossary/c.html
 * 000: preparatory courses (non-credit)
 * 100 and 200: lower-division courses primarily for freshmen and sophomores
 * 300 and 400: upper-division courses primarily for juniors and seniors (graduate credit available for 400-level courses)
 * 500, 600, and 700: graduate.
 * <p/>
 * <p/>
 * 'Pelajar Kanan' bermaksud mereka yang telah melalui dan lulus sekurang-kurangnya satu
 * semester pengajian di Universiti.
 *
 * @author PAMS
 */
public enum AdAcademicClassification {

    LEVEL_000,
    LEVEL_100, // baru
    LEVEL_200, // baru
    LEVEL_300, // kanan
    LEVEL_400, // kanan
    LEVEL_GRADUATED; // kanan

    public static AdAcademicClassification get(int index) {
        return values()[index];
    }
}
