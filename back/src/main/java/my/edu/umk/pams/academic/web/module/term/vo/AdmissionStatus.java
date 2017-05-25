package my.edu.umk.pams.academic.web.module.term.vo;

public enum AdmissionStatus {

    ADMITTED,
    POSTPONED,
    SUSPENDED,
    CANCELLED;

	public static AdmissionStatus get(int index){
		return values()[index];
		
	}
}
