package my.edu.umk.pams.academic.identity.model;

import my.edu.umk.pams.academic.planner.model.AdProgramStatus;

public enum AdStudentStatus {
	MATRICULATED, //0
	ACTIVE,		  //1
	BARRED,		  //2
	INACTIVE,	  //3
	GRADUATED;	  //4
	
    public static AdStudentStatus get(int index) {
        return values()[index];
    }

}
