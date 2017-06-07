package my.edu.umk.pams.academic.web.module.profile.vo;

public enum AddressType {
    PERMANENT,     //0
    CURRENT;    //11
	
	public static AddressType get(int index){
		return values()[index];
		
	}
}
