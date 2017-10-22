package my.edu.umk.pams.academic.planner.model;/**
 * subject type
 * @author PAMS
 */
public enum AdSubjectType {
    CORE, //0 teras fakulti
    CORE_ELECTIVE, //1 Teras program/pengkhususan
    ELECTIVE, //2 elektif/Opsyen
    GENERAL, //3 Umum Universiti
    LANGUAGE, //4 english
    CURRICULUM,//5 kokurikulum
    OTHERS;
	
    public static AdSubjectType get(int index) {
        return values()[index];
    }
}
