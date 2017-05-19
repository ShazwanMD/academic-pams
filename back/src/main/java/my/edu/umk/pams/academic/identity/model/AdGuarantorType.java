package my.edu.umk.pams.academic.identity.model;

public enum AdGuarantorType {
    PRIMARY,
    SECONDARY;
	

    public static AdGuarantorType get(int index){
        return values()[index];
    }

}
