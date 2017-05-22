package my.edu.umk.pams.academic.web.module.term.vo;

/**
 * @author PAMS
 */
public enum EnrollmentStatus {

	NEW("Baru"), // 0
	WAIT_LISTED("Dalam Proses"), // 1
	CONFIRMED("Sah"), // 2
	WITHDRAWN("Tangguh"); // 3

	private String description;

	EnrollmentStatus(String description) {
		this.description = description;
	}

	public String getEnrollmentStatus() {
		return description;
	}

	public void setEnrollmentStatus(String description) {
		this.description = description;
	}

	public static EnrollmentStatus get(int index) {
		return values()[index];

	}

}
