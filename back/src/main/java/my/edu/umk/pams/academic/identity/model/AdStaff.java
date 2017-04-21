package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.planner.model.AdFaculty;
import my.edu.umk.pams.academic.planner.model.AdProgram;

public interface AdStaff extends AdActor {

    String getStaffNo();

    void setStaffNo(String staffNo);

    AdStaffType getStaffType();

    void setStaffType(AdStaffType staffType);
    
    AdFaculty getFaculty();
    
	void setFaculty(AdFaculty faculty);

	AdProgram getProgram();

	void setProgram(AdProgram program);
}
