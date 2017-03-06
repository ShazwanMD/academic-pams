package my.edu.umk.pams.academic.offering.model;


import my.edu.umk.pams.academic.core.AdMetaObject;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.studyplan.model.AdAppointmentStatus;
import my.edu.umk.pams.academic.studyplan.model.AdSection;

/**
 * @author PAMS
 */
public interface AdAppointment extends AdMetaObject {

    AdStaff getStaff();

    void setStaff(AdStaff staff);

    AdSection getSection();

    void setSection(AdSection section);

    AdAppointmentStatus getStatus();

    void setStatus(AdAppointmentStatus status);

}
