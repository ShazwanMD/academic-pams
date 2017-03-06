package my.edu.umk.pams.academic.studyplan.model;


import static my.edu.umk.pams.academic.studyplan.model.AdAssessmentCategory.COURSE_WORK;
import static my.edu.umk.pams.academic.studyplan.model.AdAssessmentCategory.EXAM_WORK;

/**
 * @author PAMS
 */
public enum AdAssessmentType {

    QUIZ(COURSE_WORK),               // 0   // cw
    TEST(COURSE_WORK),               // 1
    REPORT(COURSE_WORK),             // 2
    ASSIGNMENT(COURSE_WORK),         // 3
    PROJECT(COURSE_WORK),            // 4
    PRESENTATION(COURSE_WORK),       // 5
    VIVA(COURSE_WORK),               // 6
    LAB_REPORT(COURSE_WORK),         // 7
    LAB_PRACTICAL(COURSE_WORK),     // 8
    FINAL_EXAM(EXAM_WORK),         // 9  // ew
    THESIS(COURSE_WORK),             // 10
    SURVEY(COURSE_WORK),             // 12
    EVALUATION(COURSE_WORK),         // 13
    TUTORIAL(COURSE_WORK),           // 14
    CASE_STUDIES(COURSE_WORK),       // 15
    FINAL_YEAR_PROJECT(COURSE_WORK), // 16
    IN_CLASS_EXERCISE(COURSE_WORK),  // 17
    REFLECTION_JOURNAL(COURSE_WORK), // 18
    PAIR_TEST(COURSE_WORK),          // 19
    PEER_GRADING(COURSE_WORK),       // 20
    PEER_EVALUATION(COURSE_WORK),    // 21
    JOURNAL(COURSE_WORK),            // 22
    HOMEWORK(COURSE_WORK),           // 23
    OTHER(COURSE_WORK);              // 24

    private AdAssessmentCategory category;

    AdAssessmentType(AdAssessmentCategory category) {
        this.category = category;
    }

}
