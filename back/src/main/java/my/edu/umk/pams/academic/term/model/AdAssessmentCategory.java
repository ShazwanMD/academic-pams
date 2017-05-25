package my.edu.umk.pams.academic.term.model;

/**
 * @author PAMS
 */
public enum AdAssessmentCategory {
    COURSE_WORK, // kerja kursus
    EXAM_WORK; // peperiksaan akhir

    public static AdAssessmentCategory get(int index){
        return values()[index];
    }

}
