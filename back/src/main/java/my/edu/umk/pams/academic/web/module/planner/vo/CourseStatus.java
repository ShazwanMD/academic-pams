package my.edu.umk.pams.academic.web.module.planner.vo;

/**
 * @author PAMS
 */
public enum CourseStatus {

	NEW, // 0
    ACTIVE,// 1
    INACTIVE;// 2

	public static CourseStatus get(int index) {
		return values()[index];
	}
}