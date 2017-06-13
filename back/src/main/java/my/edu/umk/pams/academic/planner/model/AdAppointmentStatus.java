package my.edu.umk.pams.academic.planner.model;

/**
 * @author PAMS
 */
public enum AdAppointmentStatus {
    NEW,
    CONFIRMED,
    SUBSTITUTED,
    DISMISSED;

    /*private String description;

    AdAppointmentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }*/
	
	 public static AdAppointmentStatus get(int index){
	        return values()[index];
	    }
}
