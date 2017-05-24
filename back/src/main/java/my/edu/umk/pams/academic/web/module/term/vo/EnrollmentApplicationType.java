package my.edu.umk.pams.academic.web.module.term.vo;

public enum EnrollmentApplicationType {

	PRA("PRA DAFTAR"), // 0
	COMPULSORY("WAJIB DAFTAR"), // 1
	PENALTY("BERDENDA"); // 2

	private String description;

	EnrollmentApplicationType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static EnrollmentApplicationType get(int index) {
		return values()[index];

	}

}
