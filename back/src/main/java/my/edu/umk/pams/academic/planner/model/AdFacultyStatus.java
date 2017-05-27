package my.edu.umk.pams.academic.planner.model;

public enum AdFacultyStatus {

	NEW, // 0
    ACTIVATED,// 1
    INACTIVATED;// 2

    public static AdFacultyStatus get(int index) {
        return values()[index];
    }
}
