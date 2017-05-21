package my.edu.umk.pams.academic.web.module.term.vo;

/**
 * @author PAMS
 */
public enum EnrollmentStanding {

	UM("Ulang Kursus"), // DS - daftar semula bila kursus gagal
	UG("Ulang Gred"), // DS - daftar semula untuk improve gred
	HS("Hadir Sahaja"), // tak perlu ada
	HW("Hadir Wajib"), // tak perlu ada
	MN("Kursus Minor"); // tak perlu ada

	private String description;

	EnrollmentStanding(String description) {
		this.description = description;
	}

	public String getEnrollmentStanding() {
		return description;
	}

	public void setEnrollmentStanding(String description) {
		this.description = description;
	}

	public static EnrollmentStanding get(int index) {
		return values()[index];

	}

}
