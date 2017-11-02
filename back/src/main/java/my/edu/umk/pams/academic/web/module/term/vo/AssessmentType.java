package my.edu.umk.pams.academic.web.module.term.vo;

public enum AssessmentType {

	QUIZ, // 0 // cw
	TEST, // 1
	REPORT, // 2
	ASSIGNMENT, // 3
	REACTION_PAPERS, // 4
	PROJECT, // 5
	PRESENTATION, // 6
	VIVA, // 7
	LAB_REPORT, // 8
	LAB_PRACTICAL, // 9
	MID_TERM_EXAM, // 10
	FINAL_EXAM, // 11 // ew
	THESIS, // 12
	SURVEY, // 13
	EVALUATION, // 14
	TUTORIAL, // 15
	CASE_STUDIES, // 16
	FINAL_YEAR_PROJECT, // 17
	IN_CLASS_EXERCISE, // 18
	REFLECTION_JOURNAL, // 19
	PAIR_TEST, // 20
	PEER_GRADING, // 21
	PEER_EVALUATION, // 22
	JOURNAL, // 23
	HOMEWORK, // 24
	OTHERS; // 25

	public static AssessmentType get(int index) {
		return values()[index];

	}
}
