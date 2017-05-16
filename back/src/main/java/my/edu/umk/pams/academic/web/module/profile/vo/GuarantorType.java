package my.edu.umk.pams.academic.web.module.profile.vo;

public enum GuarantorType {

	 PRIMARY,//0
	 SECONDARY;//1

	public static GuarantorType get(int index){
		return values()[index];
		
	}
}
