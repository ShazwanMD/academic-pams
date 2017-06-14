package my.edu.umk.pams.academic.web.module.identity.vo;

/**
 * @author PAMS
 */

public enum StaffType {

	ACADEMIC, //0
	NON_ACADEMIC; //1
	
	  public static StaffType get(int index) {
	        return values()[index];
	    }
	
}