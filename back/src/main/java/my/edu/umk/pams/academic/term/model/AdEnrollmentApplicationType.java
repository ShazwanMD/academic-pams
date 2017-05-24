package my.edu.umk.pams.academic.term.model;

/**
 * @author PAMS
 */
public enum AdEnrollmentApplicationType {

    PRA,
    WAJIB,
    BERDENDA;
	
	  public static AdEnrollmentApplicationType get(int index){
	        return values()[index];
	    }

	
}
