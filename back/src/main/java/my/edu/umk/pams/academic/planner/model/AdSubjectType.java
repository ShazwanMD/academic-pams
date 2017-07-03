package my.edu.umk.pams.academic.planner.model;

/**
 * subject type
 * @author PAMS
 */
public enum AdSubjectType {
    CORE, // teras fakulti
    REQUIRED, // Teras program/pengkhususan
    ELECTIVE, // elektif/Opsyen
    GENERAL, //Umum Universiti
    LANGUAGE, // english
    CURRICULUM,// kokurikulum
    OTHERS;

	
    public static AdSubjectType get(int index) {
        return values()[index];
    }
}
