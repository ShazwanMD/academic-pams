package my.edu.umk.pams.academic.web.module.term.vo;

public enum AcademicStanding {

    KB,
    KS,
    KG,
    TBD;

	public static AcademicStanding get(int index){
		return values()[index];
		
	}
}
