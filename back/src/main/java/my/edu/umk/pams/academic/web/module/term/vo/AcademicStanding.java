package my.edu.umk.pams.academic.web.module.term.vo;

public enum AcademicStanding {

    TBD,
    KB,
    KS,
    KG;

	public static AcademicStanding get(int index){
		return values()[index];
		
	}
}
