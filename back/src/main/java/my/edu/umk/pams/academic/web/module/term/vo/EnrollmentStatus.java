package my.edu.umk.pams.academic.web.module.term.vo;

/**
 * @author PAMS
 */
public enum EnrollmentStatus {

	NEW, // 0-baru
	WAIT_LISTED, // 1-dalam proses
	CONFIRMED, // 2-sah
	WITHDRAWN; // 3-tangguh

	public static EnrollmentStatus get(int index) {
		return values()[index];

	}

}
