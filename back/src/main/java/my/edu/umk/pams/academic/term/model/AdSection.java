package my.edu.umk.pams.academic.term.model;

import my.edu.umk.pams.academic.core.AdMetaObject;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdSection extends AdMetaObject {

    String getCode();

    void setCode(String code);

    String getCanonicalCode();

    void setCanonicalCode(String canonicalCode);

    Integer getOrdinal();

    void setOrdinal(Integer ordinal);

    Integer getCapacity();

    void setCapacity(Integer capacity);

    AdOffering getOffering();

    void setOffering(AdOffering offering);

    List<AdSectionPolicy> getPolicies();

    void setPolicies(List<AdSectionPolicy> policies);

    List<AdEnrollment> getEnrollments();

    void setEnrollments(List<AdEnrollment> enrollments);

    List<AdAppointment> getAppointments();

    void setAppointments(List<AdAppointment> appointments);

    Integer getAppointmentCount();

    void setAppointmentCount(Integer appointmentCount);
    
    Integer getEnrollmentCount();

    void setEnrollmentCount(Integer enrollmentCount);
    
    Integer getSectionCount();

    void setSectionCount(Integer sectionCount);
}
