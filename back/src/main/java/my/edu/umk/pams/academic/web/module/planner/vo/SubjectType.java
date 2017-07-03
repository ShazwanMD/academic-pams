package my.edu.umk.pams.academic.web.module.planner.vo;

import my.edu.umk.pams.academic.planner.model.AdSubjectType;

public enum SubjectType {
	
	CORE, // teras fakulti
    REQUIRED, // Teras program/pengkhususan
    ELECTIVE, // elektif/Opsyen
    GENERAL, //Umum Universiti
    LANGUAGE, // english
    CURRICULUM,// kokurikulum
    OTHERS;

	
    public static SubjectType get(int index) {
        return values()[index];
    }
}

