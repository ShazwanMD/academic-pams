package my.edu.umk.pams.academic.web.module.term.vo;

import my.edu.umk.pams.academic.term.model.AdAssessmentCategory;
import my.edu.umk.pams.academic.web.module.profile.vo.AddressType;

public enum AssessmentType {
	
	

	 	QUIZ(AssessmentCategory.COURSE_WORK),               // 0   // cw
	    TEST(AssessmentCategory.COURSE_WORK),               // 1
	    REPORT(AssessmentCategory.COURSE_WORK),             // 2
	    ASSIGNMENT(AssessmentCategory.COURSE_WORK),         // 3
	    PROJECT(AssessmentCategory.COURSE_WORK),            // 4
	    PRESENTATION(AssessmentCategory.COURSE_WORK),       // 5
	    VIVA(AssessmentCategory.COURSE_WORK),               // 6
	    LAB_REPORT(AssessmentCategory.COURSE_WORK),         // 7
	    LAB_PRACTICAL(AssessmentCategory.COURSE_WORK),     // 8
	    FINAL_EXAM(AssessmentCategory.EXAM_WORK),         // 9  // ew
	    THESIS(AssessmentCategory.COURSE_WORK),             // 10
	    SURVEY(AssessmentCategory.COURSE_WORK),             // 12
	    EVALUATION(AssessmentCategory.COURSE_WORK),         // 13
	    TUTORIAL(AssessmentCategory.COURSE_WORK),           // 14
	    CASE_STUDIES(AssessmentCategory.COURSE_WORK),       // 15
	    FINAL_YEAR_PROJECT(AssessmentCategory.COURSE_WORK), // 16
	    IN_CLASS_EXERCISE(AssessmentCategory.COURSE_WORK),  // 17
	    REFLECTION_JOURNAL(AssessmentCategory.COURSE_WORK), // 18
	    PAIR_TEST(AssessmentCategory.COURSE_WORK),          // 19
	    PEER_GRADING(AssessmentCategory.COURSE_WORK),       // 20
	    PEER_EVALUATION(AssessmentCategory.COURSE_WORK),    // 21
	    JOURNAL(AssessmentCategory.COURSE_WORK),            // 22
	    HOMEWORK(AssessmentCategory.COURSE_WORK),           // 23
	    OTHER(AssessmentCategory.COURSE_WORK);              // 24
	
	private AssessmentCategory assessmentCategory;

    AssessmentType(AssessmentCategory assessmentCategory) {
        this.assessmentCategory = assessmentCategory;
    }
	
	public static AssessmentType get(int index){
		return values()[index];
		
	}
}
