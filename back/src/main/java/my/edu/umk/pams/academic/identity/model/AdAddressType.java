package my.edu.umk.pams.academic.identity.model;

public enum AdAddressType {
    PERMANENT,     //0
    CURRENT;    //1
	
	public static AdAddressType get(int index){
        return values()[index];
    }
}

