package my.edu.umk.pams.academic.web.module.planner.vo;

/**
 * @author PAMS
 */
public enum AcademicSemester  {
	
		SEPTEMBER, // 0
	    FEBRUARY, // 1
	    DISEMBER;  // 2
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public static AcademicSemester get(int index){
        return values()[index];
    }
}
