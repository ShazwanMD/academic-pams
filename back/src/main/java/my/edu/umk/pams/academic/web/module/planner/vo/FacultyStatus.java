package my.edu.umk.pams.academic.web.module.planner.vo;

public enum FacultyStatus {

	NEW, // 0
    ACTIVE,// 1
    INACTIVE;// 2

    public static FacultyStatus get(int index) {
        return values()[index];
    }
}
