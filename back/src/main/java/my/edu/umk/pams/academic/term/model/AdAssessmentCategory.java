package my.edu.umk.pams.academic.term.model;

/**
 * @author PAMS
 */
public enum AdAssessmentCategory {
    COURSE_WORK, //0 kerja kursus
    EXAM_WORK; //1 peperiksaan akhir

    public static AdAssessmentCategory get(int index){
        return values()[index];
    }

}
