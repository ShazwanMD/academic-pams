package my.edu.umk.pams.academic.web.module.planner.vo;

public enum FacultyStatus {

	NEW, // 0
    ACTIVATED,// 1
    INACTIVATED;// 2

    public static FacultyStatus get(int index) {
        return values()[index];
    }
}