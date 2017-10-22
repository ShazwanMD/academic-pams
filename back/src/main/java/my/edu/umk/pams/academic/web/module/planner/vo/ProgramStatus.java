package my.edu.umk.pams.academic.web.module.planner.vo;

/**
 * @author PAMS
 */
public enum ProgramStatus {
	NEW, // 0
    ACTIVE,// 1
    INACTIVE;// 2

    public static ProgramStatus get(int index) {
        return values()[index];
    }

}
