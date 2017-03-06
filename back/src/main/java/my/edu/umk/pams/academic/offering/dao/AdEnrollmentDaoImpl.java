package my.edu.umk.pams.academic.offering.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.offering.model.AdAdmission;
import my.edu.umk.pams.academic.offering.model.AdEnrollment;
import my.edu.umk.pams.academic.offering.model.AdEnrollmentImpl;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("acEnrollmentDao")
public class AdEnrollmentDaoImpl extends GenericDaoSupport<Long, AdEnrollment> implements AdEnrollmentDao {

    public AdEnrollmentDaoImpl() {
        super(AdEnrollmentImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================
    @Override
    public AdEnrollment findByMatricNoAndOffering(String matricNo, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.student.identityNo = :matricNo " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setString("matricNo", matricNo);
        query.setCacheable(true);
        return (AdEnrollment) query.uniqueResult();
    }

    @Override
    public AdEnrollment findBySectionAndStudent(AdSection section, AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section = :section " +
                "and s.student = :student " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setEntity("student", student);
        query.setCacheable(true);
        return (AdEnrollment) query.uniqueResult();
    }

    @Override
    public List<AdEnrollment> find(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdAcademicSession academicSession, AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.session = :academicSession " +
                "and s.section.offering.program = :program " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.student = :student " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("student", student);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdAcademicSession academicSession, AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.student = :student " +
                "and s.section.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("student", student);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }


    @Override
    public List<AdEnrollment> find(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(String filter, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and (upper(s.student.identityNo) like upper(:filter) " +
                "or upper(s.student.credentialNo) like upper(:filter) " +
                "or upper(s.student.email) like upper(:filter) " +
                "or upper(s.student.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(String filter, AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and (upper(s.student.identityNo) like upper(:filter) " +
                "or upper(s.student.credentialNo) like upper(:filter) " +
                "or upper(s.student.email) like upper(:filter) " +
                "or upper(s.student.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(String filter, AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.section = :section " +
                "and (upper(s.student.identityNo) like upper(:filter) " +
                "or upper(s.student.credentialNo) like upper(:filter) " +
                "or upper(s.student.email) like upper(:filter) " +
                "or upper(s.student.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdStudent student, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.student = :student " +
                "and s.metadata.state = :state " +
                "order by s.section.offering.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("student", student);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdEnrollment> find(AdAdmission admission) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEnrollment s where " +
                "s.admission = :admission " +
                "and s.metadata.state = :state " +
                "order by s.section.offering.code asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("admission", admission);
        query.setCacheable(true);
        return (List<AdEnrollment>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section.offering.program = :program " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setEntity("program", program);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s.student from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state " +
                "order by s.student.name asc");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findAvailableStudents(AdOffering offering) {
        // TODO: 
        return null;
    }

    @Override
    public List<AdStudent> findAvailableStudents(AdOffering offering, Integer offset, Integer limit) {
        // TODO: 
        return null;
    }

    @Override
    public List<AdStudent> findAvailableStudents(String filter, AdOffering offering, Integer offset, Integer limit) {
        // TODO: 
        return null;
    }

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    @Override
    public Integer count(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and (upper(s.student.identityNo) like upper(:filter) " +
                "or upper(s.student.credentialNo) like upper(:filter) " +
                "or upper(s.student.email) like upper(:filter) " +
                "or upper(s.student.name) like upper(:filter) " +
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
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and (upper(s.student.identityNo) like upper(:filter) " +
                "or upper(s.student.credentialNo) like upper(:filter) " +
                "or upper(s.student.email) like upper(:filter) " +
                "or upper(s.student.name) like upper(:filter) " +
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
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdEnrollmentStatus status, AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section " +
                "and s.status = :status " +
                "and s.metadata.state = :state ");
        query.setInteger("status", status.ordinal());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section " +
                "and (upper(s.student.identityNo) like upper(:filter) " +
                "or upper(s.student.credentialNo) like upper(:filter) " +
                "or upper(s.student.email) like upper(:filter) " +
                "or upper(s.student.name) like upper(:filter) " +
                "or upper(s.section.code) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.student = :student " +
                "and s.metadata.state = :state ");
        query.setEntity("student", student);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAdmission admission) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.admission = :admission " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("admission", admission);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStudent(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStudent(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(AdSection section, AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdEnrollment s where " +
                "s.student = :student " +
                "and s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("student", student);
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isAnyExists(AdAcademicSession academicSession, AdOffering offering, AdStudent student) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdEnrollment s where " +
                "s.student = :student " +
                "and s.section.offering = :offering " +
                "and s.section.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setEntity("student", student);
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasEnrollment(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdEnrollment s where " +
                "s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
