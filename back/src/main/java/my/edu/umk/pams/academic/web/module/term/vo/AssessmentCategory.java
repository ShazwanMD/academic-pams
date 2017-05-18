package my.edu.umk.pams.academic.web.module.term.vo;

public enum AssessmentCategory {
	
    COURSE_WORK("COURSE WORK"), // kerja kursus
    EXAM_WORK("EXAM WORK"); // peperiksaan akhir
	

    private String description;

    AssessmentCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	
	public static AssessmentCategory get(int index){
		return values()[index];
		
	}

}
