package my.edu.umk.pams.academic.web.module.planner.vo;

public enum SubjectType {
    CORE, // teras fakulti
    CORE_ELECTIVE, // Teras program/pengkhususan
    ELECTIVE, // elektif/Opsyen
    GENERAL, //Umum Universiti
    LANGUAGE, // english
    CURRICULUM,// kokurikulum
    OTHERS;

    public static SubjectType get(int index) {
        return values()[index];
    }
}

