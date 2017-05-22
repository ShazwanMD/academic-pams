package my.edu.umk.pams.academic.term.model;

/**
 * @author PAMS
 */
public enum AdAssessmentCategory {
    COURSE_WORK("COURSE WORK"), // kerja kursus
    EXAM_WORK("EXAM WORK"); // peperiksaan akhir

    private String description;

    AdAssessmentCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static AdAssessmentCategory get(int index){
        return values()[index];
    }

}
