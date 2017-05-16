package my.edu.umk.pams.academic.web.module.profile.vo;

public enum AddressType {
    MAILING,     //0
    BILLING;    //1
	
	public static AddressType get(int index){
		return values()[index];
		
	}
}
