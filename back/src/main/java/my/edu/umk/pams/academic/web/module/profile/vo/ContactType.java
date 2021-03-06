package my.edu.umk.pams.academic.web.module.profile.vo;

/**
 * @author PAMS
 */
public enum ContactType {
    HUSBAND,//0
    WIFE,//1
    SON,//2
    DAUGHTER,//3
    FATHER,//4
    MOTHER,//5
    BROTHER,//6
    SISTER,//7
    GRANDPARENT,//8
    GRANDCHILD,//9
    UNCLE,//10
    AUNT,//11
    NEPHEW,//12
    NIECE;//13

    public static ContactType get(int index){
        return values()[index];
    }
}
