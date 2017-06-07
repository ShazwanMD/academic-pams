package my.edu.umk.pams.academic.planner.model;

public enum AdCourseStatus {

	NEW, // 0
    ACTIVE,// 1
    INACTIVE;// 2

    public static AdCourseStatus get(int index) {
        return values()[index];
    }

}
