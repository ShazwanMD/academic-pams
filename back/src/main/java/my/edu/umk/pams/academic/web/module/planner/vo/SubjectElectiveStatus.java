package my.edu.umk.pams.academic.web.module.planner.vo;

import my.edu.umk.pams.academic.planner.model.AdSubjectElectiveStatus;

public enum SubjectElectiveStatus {
	 NONE, //0
	    ENTREPRENEURSHIP,  //1
	    FINANCE, //2
	    MARKETING,  //3
	    HUMAN_RESOURCE_MANAGEMENT, //4
	    OTHERS; //5
		
	    public static SubjectElectiveStatus get(int index) {
	        return values()[index];
	    }
}

