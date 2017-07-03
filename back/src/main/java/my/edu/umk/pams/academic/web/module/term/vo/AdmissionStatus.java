package my.edu.umk.pams.academic.web.module.term.vo;

public enum AdmissionStatus {

	REGULAR,
	PROBATION,
	ADMITTED,
    POSTPONED,
    SUSPENDED,
    CANCELLED;

	public static AdmissionStatus get(int index){
		return values()[index];
		
	}
}
