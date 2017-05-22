package my.edu.umk.pams.academic.identity.model;

public enum AdAddressType {
    MAILING,     //0
    BILLING;    //1
	
	public static AdAddressType get(int index){
        return values()[index];
    }
}

