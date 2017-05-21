package my.edu.umk.pams.academic.web.module.planner.vo;

/**
 * @author PAMS
 */
public enum AcademicSemester  {
	
		SEMESTER_1, // 0
	    SEMESTER_2, // 1
	    SEMESTER_3;  // 2
	
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
