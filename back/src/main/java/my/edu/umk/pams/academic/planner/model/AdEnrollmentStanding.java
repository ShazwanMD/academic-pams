package my.edu.umk.pams.academic.planner.model;

/**
 * @author PAMS
 */
public enum AdEnrollmentStanding {

    UM, // DS - daftar semula bila kursus gagal
    UG,   // DS - daftar semula untuk improve gred
    HS,   // tak perlu ada
    HW,		// tak perlu ada
    MN;		//tak perlu ada

  /*  private String description;

    AdEnrollmentStanding(String description) {
        this.description = description;
    }*/
	 public static AdEnrollmentStanding get(int index){
	        return values()[index];
	    }

}
