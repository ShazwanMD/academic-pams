package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.offering.model.AdAdmission;
import my.edu.umk.pams.academic.offering.model.AdAppointment;
import my.edu.umk.pams.academic.offering.model.AdEnrollment;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author PAMS
 */
@Repository("acSectionDao")
public class AdSectionDaoImpl extends GenericDaoSupport<Long, AdSection> implements AdSectionDao {

    public AdSectionDaoImpl() {
        super(AdSectionImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdSectionPolicy findPolicyById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (AdSectionPolicy) session.get(AdSectionPolicyImpl.class, id);
    }

    @Override
    public AdSection findByCanonicalCode(String canonicalCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.canonicalCode = :canonicalCode " +
                "and s.metadata.state = :state");
        query.setString("canonicalCode", canonicalCode);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdSection) query.uniqueResult();
    }

    @Override
    public AdSection findByCodeAndSessionAndOffering(String code, AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.code = :code " +
                "and s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdSection) query.uniqueResult();
    }

    @Override
    public List<AdSection> find(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(String filter, AdAcademicSession academicSession, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.offering.code) like upper(:filter) " +
                "or upper(s.offering.canonicalCode) like upper(:filter) " +
                "or upper(s.offering.title) like upper(:filter)) " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.session = :academicSession " +
                "and s.metadata.state = :state ");
//                "order by s.offering.program.code asc, s.offering.code asc, s.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(AdAcademicSession academicSession, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.session = :academicSession " +
                "and s.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("academicSession", academicSession);
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "s.session = :academicSession " +
                "and s.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("academicSession", academicSession);
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSection> find(String filter, AdAcademicSession academicSession, AdAdmission admission, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSection s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.offering.code) like upper(:filter) " +
                "or upper(s.offering.title) like upper(:filter)) " +
                "and s.session = :academicSession " +
                "and s.offering.program = :program " +
                "and s.metadata.state = :state " +
                "order by s.code asc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("academicSession", academicSession);
        query.setEntity("program", admission.getProgram());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdSection>) query.list();
    }

    @Override
    public List<AdSectionPolicy> findPolicies(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSectionPolicy s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdSectionPolicy>) query.list();
    }

    @Override
    public List<AdSectionPolicy> findPolicies(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSectionPolicy s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setMaxResults(limit);
        query.setCacheable(true);
        query.setCacheable(true);
        return (List<AdSectionPolicy>) query.list();
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.student.identityNo asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> findEnrollments(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.student.identityNo asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdAppointment> findAppointments(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> findAppointments(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> findAppointments(AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering.course = :course " +
                "and s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("course", course);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> findAppointments(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> findAppointments(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.student.name");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdStaff>) query.list();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.offering.code) like upper(:filter) " +
                "or upper(s.offering.course.title) like upper(:filter)) " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "s.offering = :offering  " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "s.offering.course = :course  " +
                "and s.metadata.state = :state ");
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "s.session = :academicSession  " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "s.session = :academicSession  " +
                "and s.offering = :offering  " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession, AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "s.session = :academicSession  " +
                "and s.offering.course = :course  " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession academicSession, AdAdmission admission) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSection s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.offering.code) like upper(:filter) " +
                "or upper(s.offering.course.title) like upper(:filter)) " +
                "and s.offering.program = :program " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("academicSession", academicSession);
        query.setEntity("program", admission.getProgram());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStudent(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section  " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStudent(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment e right join e.student s " +
                "left join e.section t left join t.offering c where " +
                "(c is null or (c is not null and c <> :offering)) " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStudent(AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment e right join e.student s " +
                "left join e.section t left join t.offering.course c where " +
                "(c is null or (c is not null and c <> :course)) " +
                "and s.metadata.state = :state ");
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStudent(String filter, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStudent s where " +
                "s not in (select e.student from AdEnrollment e where " +
                "e.section.offering = :offering) " +
                "and (upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter) " +
                "or upper(s.credentialNo) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStudent(String filter, AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStudent s where " +
                "s not in (select e.student from AdEnrollment e where " +
                "e.section.offering.course = :course) " +
                "and (upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter) " +
                "or upper(s.credentialNo) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setEntity("course", course);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStaff(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment e right join e.staff s " +
                "left join e.section t left join t.offering c where " +
                "(c is null or (c is not null and c <> :offering)) " +
                "and t.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countPolicy(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section  " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStaff(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment e right join e.staff s " +
                "left join e.section t left join t.offering c where " +
                "(c is null or (c is not null and c <> :offering)) " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAvailableStaff(AdCourse course) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment e right join e.staff s " +
                "left join e.section t left join t.offering.course c where " +
                "(c is null or (c is not null and c <> :course)) " +
                "and s.metadata.state = :state ");
        query.setEntity("course", course);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countEnrollment(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section  " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countAppointment(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section = :section  " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasSection(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSection s where " +
                "s.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasSection(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSection s where " +
                "s.session = :academicSession " +
                "and s.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String canonicalCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSection s where " +
                "s.canonicalCode = :canonicalCode " +
                "and s.metadata.state = :state ");
        query.setString("canonicalCode", canonicalCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isAppointmentExists(AdSection section, AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAppointment s where " +
                "s.section = :section " +
                "and s.staff = :staff " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setEntity("staff", staff);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }


    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    @Override
    public void addPolicy(AdSection section, AdSectionPolicy policy, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(section, "Section cannot be null");
        Validate.notNull(policy, "policy cannot be null");
        Session session = sessionFactory.getCurrentSession();
        policy.setSection(section);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        policy.setMetadata(metadata);
        session.save(policy);
    }

    @Override
    public void updatePolicy(AdSection section, AdSectionPolicy policy, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        policy.setSection(section);

        // prepare metadata
        AdMetadata metadata = policy.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        policy.setMetadata(metadata);
        session.update(policy);
    }

    @Override
    public void deletePolicy(AdSection section, AdSectionPolicy policy, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(policy);
    }

    @Override
    public void addEnrollment(AdSection section, AdEnrollment enrollment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(section, "Section cannot be null");
        Validate.notNull(enrollment, "enrollment cannot be null");
        Session session = sessionFactory.getCurrentSession();
        enrollment.setSection(section);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        enrollment.setMetadata(metadata);
        session.save(enrollment);
    }

    @Override
    public void updateEnrollment(AdSection section, AdEnrollment enrollment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        enrollment.setSection(section);

        // prepare metadata
        AdMetadata metadata = enrollment.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        enrollment.setMetadata(metadata);
        session.update(enrollment);
    }

    @Override
    public void deleteEnrollment(AdSection section, AdEnrollment enrollment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(enrollment);
    }

    @Override
    public void addAppointment(AdSection section, AdAppointment appointment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        appointment.setMetadata(metadata);
        session.save(appointment);
    }

    @Override
    public void updateAppointment(AdSection section, AdAppointment appointment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        AdMetadata metadata = appointment.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        appointment.setMetadata(metadata);
        session.update(appointment);
    }

    @Override
    public void deleteAppointment(AdSection section, AdAppointment appointment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(appointment);
    }
}
