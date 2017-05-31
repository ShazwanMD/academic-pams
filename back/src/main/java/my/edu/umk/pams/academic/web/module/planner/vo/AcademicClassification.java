package my.edu.umk.pams.academic.web.module.planner.vo;

/**
 * @author PAMS
 */
public enum AcademicClassification {

    LEVEL_000, //0
    LEVEL_100, // 1-baru
    LEVEL_200, // 2-baru
    LEVEL_300, // 3-kanan
    LEVEL_400, // 4-kanan
    LEVEL_GRADUATED, // 5-kanan
	LEVEL_MASTER,// 6-MASTER
	LEVEL_DOCTORATE;// 7-PHD

    public static AcademicClassification get(int index) {
        return values()[index];
    }
}
