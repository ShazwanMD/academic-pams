package my.edu.umk.pams.academic.term.dao;


import my.edu.umk.pams.academic.core.GenericDao;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import my.edu.umk.pams.academic.studyplan.model.AdProgram;

import java.util.List;

/**
 * @author PAMS
 */
public interface AdAppointmentDao extends GenericDao<Long, AdAppointment> {

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    AdAppointment findByStaffNoAndOffering(String staffNo, AdOffering offering);

    AdAppointment findBySectionAndStaff(AdSection section, AdStaff staff);

    List<AdAppointment> find(AdAcademicSession adAcemicSession);

    List<AdAppointment> find(AdProgram program);

    List<AdAppointment> find(AdOffering offering);

    List<AdAppointment> find(AdSection section);

    List<AdAppointment> find(AdStaff staff);

    List<AdAppointment> find(AdAcademicSession adAcemicSession, AdOffering offering);

    List<AdAppointment> find(AdAcademicSession adAcemicSession, AdStaff staff);

    List<AdAppointment> find(AdAcademicSession adAcemicSession, AdStaff staff, Integer offset, Integer limit);

    List<AdAppointment> find(AdOffering offering, Integer offset, Integer limit);

    List<AdAppointment> find(String filter, AdOffering offering, Integer offset, Integer limit);

    List<AdAppointment> find(AdAcademicSession adAcemicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdAppointment> find(String filter, AdAcademicSession adAcemicSession, AdOffering offering, Integer offset, Integer limit);

    List<AdAppointment> find(AdSection section, Integer offset, Integer limit);

    List<AdAppointment> find(String filter, AdSection section, Integer offset, Integer limit);

    List<AdAppointment> find(AdStaff staff, Integer offset, Integer limit);

    List<AdStaff> findStaffs(AdProgram program);

    List<AdStaff> findStaffs(AdProgram program, Integer offset, Integer limit);

    List<AdStaff> findStaffs(AdOffering offering);

    List<AdStaff> findStaffs(AdOffering offering, Integer offset, Integer limit);

    List<AdStaff> findStaffs(AdSection section);

    List<AdStaff> findStaffs(AdSection section, Integer offset, Integer limit);

    List<AdStaff> findAvailableStaffs(AdOffering offering);

    List<AdStaff> findAvailableStaffs(AdOffering offering, Integer offset, Integer limit);

    List<AdStaff> findAvailableStaffs(String filter, AdOffering offering, Integer offset, Integer limit);

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    Integer count(AdOffering offering);

    Integer count(String filter, AdOffering offering);

    Integer count(AdAcademicSession adAcemicSession, AdOffering offering);

    Integer count(AdAcademicSession adAcemicSession, AdStaff staff);

    Integer count(String filter, AdAcademicSession adAcemicSession, AdOffering offering);

    Integer count(AdSection section);

    Integer count(String filter, AdSection section);

    Integer count(AdStaff staff);

    Integer countStaff(AdOffering offering);

    Integer countStaff(AdSection section);

    boolean isExists(AdSection section, AdStaff staff);

    boolean isAnyExists(AdAcademicSession adAcemicSession, AdOffering offering, AdStaff staff);

    boolean isClashed(AdSection section, AdStaff staff);

    boolean hasAppointment(AdSection section);
}
