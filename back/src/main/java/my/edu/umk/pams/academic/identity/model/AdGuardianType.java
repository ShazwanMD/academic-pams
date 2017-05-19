package my.edu.umk.pams.academic.identity.model;

public enum AdGuardianType {
    MOTHER, 
    FATHER, 
    GUARDIAN;
    
    public static AdGuardianType get(int index){
        return values()[index];
    }
}
