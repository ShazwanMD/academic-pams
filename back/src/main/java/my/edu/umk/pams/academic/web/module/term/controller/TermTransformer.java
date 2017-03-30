package my.edu.umk.pams.academic.web.module.term.controller;

import my.edu.umk.pams.academic.profile.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.web.module.term.vo.*;
import org.springframework.stereotype.Component;

/**
 * @author PAMS
 */
@Component("termTransformer")
public class TermTransformer {

    public Admission toAdmissionVo(AdAdmission admission) {
        Admission m = new Admission();
        m.setId(admission.getId());
        m.setGpa(admission.getGpa());
        m.setCgpa(admission.getCgpa());
        m.setCreditEarned(admission.getCreditEarned());
        m.setCreditTaken(admission.getCreditTaken());
        return m;
    }

    public Appointment toAppointmentVo(AdAppointment appointment) {
        Appointment m = new Appointment();
        m.setId(appointment.getId());
        return m;
    }
    public Enrollment toEnrollmentVo(AdEnrollment enrollment) {
        Enrollment m = new Enrollment();
        m.setId(enrollment.getId());
        return m;
    }
    public Offering toOfferingVo(AdOffering offering) {
        Offering m = new Offering();
        m.setId(offering.getId());
        return m;
    }
    public Section toSectionVo(AdSection section) {
        Section m = new Section();
        m.setId(section.getId());
        return m;
    }
}
