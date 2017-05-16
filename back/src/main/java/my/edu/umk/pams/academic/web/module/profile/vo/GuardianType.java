package my.edu.umk.pams.academic.web.module.profile.vo;

public enum GuardianType {
	
	  MOTHER, //0
	  FATHER, //1
	  GUARDIAN; //2
	
	public static GuardianType get(int index){
		return values()[index];
	}

}
