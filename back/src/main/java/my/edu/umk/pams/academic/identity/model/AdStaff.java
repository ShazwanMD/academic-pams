package my.edu.umk.pams.academic.identity.model;

public interface AdStaff extends AdActor {

    String getStaffNo();

    void setStaffNo(String staffNo);

    AdStaffType getStaffType();

    void setStaffType(AdStaffType staffType);
}
