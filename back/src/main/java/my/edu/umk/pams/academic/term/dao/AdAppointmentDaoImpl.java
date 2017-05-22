package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.term.model.AdAdmission;
import my.edu.umk.pams.academic.term.model.AdAppointment;
import my.edu.umk.pams.academic.term.model.AdAppointmentImpl;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdProgram;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adAppointmentDao")
public class AdAppointmentDaoImpl extends GenericDaoSupport<Long, AdAppointment> implements AdAppointmentDao {

    public AdAppointmentDaoImpl() {
        super(AdAppointmentImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdAppointment findByStaffNoAndOffering(String staffNo, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.staff.identityNo = :staffNo " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setString("staffNo", staffNo);
        query.setCacheable(true);
        return (AdAppointment) query.uniqueResult();
    }

    @Override
    public AdAppointment findBySectionAndStaff(AdSection section, AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section = :section " +
                "and s.staff = :staff " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setEntity("staff", staff);
        query.setCacheable(true);
        return (AdAppointment) query.uniqueResult();
    }
    
    @Override
    public AdAppointment findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select o from AdAppointment o where " +
                "o.id = :id " +
                "and o.metadata.state = :state");
        query.setLong("id", id);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAppointment) query.uniqueResult();
    }

    @Override
    public List<AdAppointment> find(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdAcademicSession academicSession, AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("staff", staff);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdAcademicSession academicSession, AdStaff staff, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("staff", staff);
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("staff", staff);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(String filter, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and (upper(s.staff.identityNo) like upper(:filter) " +
                "or upper(s.staff.email) like upper(:filter) " +
                "or upper(s.staff.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(String filter, AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.section.offering.session = :academicSession " +
                "and (upper(s.staff.identityNo) like upper(:filter) " +
                "or upper(s.staff.email) like upper(:filter) " +
                "or upper(s.staff.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(String filter, AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.section = :section " +
                "and (upper(s.staff.identityNo) like upper(:filter) " +
                "or upper(s.staff.email) like upper(:filter) " +
                "or upper(s.staff.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdAppointment> find(AdStaff staff, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.metadata.state = :state " +
                "order by s.section.offering.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("staff", staff);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAppointment>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section.offering.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section.offering.program = :program " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findStaffs(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.staff from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
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
                "and s.metadata.state = :state " +
                "order by s.staff.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findAvailableStaffs(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStaff s where " +
                "s not in (select e.staff from AdAppointment e where " +
                "e.section.offering = :offering) " +
                "and s.metadata.state = :state " +
                "order by s.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findAvailableStaffs(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStaff s where " +
                "s not in (select e.staff from AdAppointment e where " +
                "e.section.offering = :offering) " +
                "and s.metadata.state = :state " +
                "order by s.name asc");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    @Override
    public List<AdStaff> findAvailableStaffs(String filter, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStaff s where " +
                "s not in (select e.staff from AdAppointment e where " +
                "e.section.offering = :offering) " +
                "and (upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.name asc");
        query.setEntity("offering", offering);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStaff>) query.list();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public Integer count(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and (upper(s.staff.identityNo) like upper(:filter) " +
                "or upper(s.staff.email) like upper(:filter) " +
                "or upper(s.staff.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.offering.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession, AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("staff", staff);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public Integer count(String filter, AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.section.offering.session = :academicSession " +
                "and (upper(s.staff.identityNo) like upper(:filter) " +
                "or upper(s.staff.email) like upper(:filter) " +
                "or upper(s.staff.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section = :section " +
                "and (upper(s.staff.identityNo) like upper(:filter) " +
                "or upper(s.staff.email) like upper(:filter) " +
                "or upper(s.staff.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.metadata.state = :state ");
        query.setEntity("staff", staff);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStaff(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStaff(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(AdSection section, AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("staff", staff);
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isAnyExists(AdAcademicSession academicSession, AdOffering offering, AdStaff staff) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAppointment s where " +
                "s.staff = :staff " +
                "and s.section.offering = :offering " +
                "and s.section.offering.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setEntity("staff", staff);
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isClashed(AdSection section, AdStaff staff) {
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

    @Override
    public boolean hasAppointment(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAppointment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
