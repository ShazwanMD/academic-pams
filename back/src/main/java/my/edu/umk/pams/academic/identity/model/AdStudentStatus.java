package my.edu.umk.pams.academic.identity.model;

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
