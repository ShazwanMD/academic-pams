package my.edu.umk.pams.academic.planner.model;

public enum AdProgramStatus {
	NEW, // 0
    ACTIVATED,// 1
    INACTIVATED;// 2

    public static AdProgramStatus get(int index) {
        return values()[index];
    }

}
