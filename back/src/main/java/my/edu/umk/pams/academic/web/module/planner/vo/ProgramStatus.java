package my.edu.umk.pams.academic.web.module.planner.vo;

/**
 * @author PAMS
 */
public enum ProgramStatus {
    NEW, // 0
    ACTIVATED,// 1
    INACTIVATED;// 2

    public static ProgramStatus get(int index) {
        return values()[index];
    }

}
