package my.edu.umk.pams.academic.planner.model;

public enum AdFacultyStatus {

	NEW, // 0
    ACTIVE,// 1
    INACTIVE;// 2

    public static AdFacultyStatus get(int index) {
        return values()[index];
    }
}
