package my.edu.umk.pams.academic.term.model;


/**
 * @author PAMS
 */
public enum AdAssessmentType {

    QUIZ(AdAssessmentCategory.COURSE_WORK),               // 0   // cw
    TEST(AdAssessmentCategory.COURSE_WORK),               // 1
    REPORT(AdAssessmentCategory.COURSE_WORK),             // 2
    ASSIGNMENT(AdAssessmentCategory.COURSE_WORK),         // 3
    PROJECT(AdAssessmentCategory.COURSE_WORK),            // 4
    PRESENTATION(AdAssessmentCategory.COURSE_WORK),       // 5
    VIVA(AdAssessmentCategory.COURSE_WORK),               // 6
    LAB_REPORT(AdAssessmentCategory.COURSE_WORK),         // 7
    LAB_PRACTICAL(AdAssessmentCategory.COURSE_WORK),     // 8
    FINAL_EXAM(AdAssessmentCategory.EXAM_WORK),         // 9  // ew
    THESIS(AdAssessmentCategory.COURSE_WORK),             // 10
    SURVEY(AdAssessmentCategory.COURSE_WORK),             // 12
    EVALUATION(AdAssessmentCategory.COURSE_WORK),         // 13
    TUTORIAL(AdAssessmentCategory.COURSE_WORK),           // 14
    CASE_STUDIES(AdAssessmentCategory.COURSE_WORK),       // 15
    FINAL_YEAR_PROJECT(AdAssessmentCategory.COURSE_WORK), // 16
    IN_CLASS_EXERCISE(AdAssessmentCategory.COURSE_WORK),  // 17
    REFLECTION_JOURNAL(AdAssessmentCategory.COURSE_WORK), // 18
    PAIR_TEST(AdAssessmentCategory.COURSE_WORK),          // 19
    PEER_GRADING(AdAssessmentCategory.COURSE_WORK),       // 20
    PEER_EVALUATION(AdAssessmentCategory.COURSE_WORK),    // 21
    JOURNAL(AdAssessmentCategory.COURSE_WORK),            // 22
    HOMEWORK(AdAssessmentCategory.COURSE_WORK),           // 23
    OTHER(AdAssessmentCategory.COURSE_WORK);              // 24

    private AdAssessmentCategory category;

    AdAssessmentType(AdAssessmentCategory category) {
        this.category = category;
    }

}
