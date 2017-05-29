package my.edu.umk.pams.academic.web.module.term.vo;

public enum AppointmentStatus {

	NEW, // 0 -Baru
	CONFIRMED, // 1 -Confirmed
	SUBSTITUTED, // 2 -Diganti
	DISMISSED; // 3 -Dilepaskan

	public static AppointmentStatus get(int index) {
		return values()[index];

	}

}
