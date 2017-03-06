package my.edu.umk.pams.academic.studyplan.model;

/**
 * @author PAMS
 */
public enum AdAcademicSemester {

    SEMESTER_1 ("1"), // 0
    SEMESTER_2 ("2"), // 1
    SEMESTER_3 ("3"); // 2

    private String description;

    AdAcademicSemester(String description) {
        this.description = description;
    }
}
