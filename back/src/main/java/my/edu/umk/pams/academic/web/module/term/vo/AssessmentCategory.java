package my.edu.umk.pams.academic.web.module.term.vo;

public enum AssessmentCategory {
	
    COURSE_WORK, // kerja kursus
    EXAM_WORK; // peperiksaan akhir

	
	public static AssessmentCategory get(int index){
		return values()[index];
		
	}

}
