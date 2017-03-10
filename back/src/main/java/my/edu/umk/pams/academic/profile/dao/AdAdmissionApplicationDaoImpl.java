package my.edu.umk.pams.academic.profile.dao;


import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStaff;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.profile.model.AdAdmissionApplication;
import my.edu.umk.pams.academic.profile.model.AdAdmissionApplicationImpl;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author AMS
 */
@Repository("adAdmissionApplicationDao")
public class AdAdmissionApplicationDaoImpl extends GenericDaoSupport<Long, AdAdmissionApplication> implements AdAdmissionApplicationDao {

    public AdAdmissionApplicationDaoImpl() {
        super(AdAdmissionApplicationImpl.class);
    }

    @Override
    public AdAdmissionApplication findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdAdmissionApplication p " +
                "where p.referenceNo = :referenceNo ");
        query.setString("referenceNo", referenceNo);
        return (AdAdmissionApplication) query.uniqueResult();
    }

    @Override
    public List<AdAdmissionApplication> find(AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where " +
                "p.session = :session ");
        query.setEntity("session", session);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(AdAcademicSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where " +
                "p.session = :session ");
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(String filter, AdAcademicSession session, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStudent student, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.student = :student");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("student", student);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public List<AdAdmissionApplication> find(String filter, AdAcademicSession session, AdStaff advisor, Integer offset, Integer limit) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select p from AdAdmissionApplication p where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.advisor = :advisor");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("advisor", advisor);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdAdmissionApplication>) query.list();
    }

    @Override
    public Integer count(AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " +
                "where p.session = :session");
        query.setEntity("session", session);
        return (Integer) query.uniqueResult();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session, AdStudent student) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.student = :student");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("student", student);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdAcademicSession session, AdStaff advisor) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdAdmissionApplication p " +
                "where " +
                "(upper(p.referenceNo) like upper(:filter) or " +
                "upper(p.description) like upper(:filter)) " +
                "and p.session = :session " +
                "and p.advisor = :advisor");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("session", session);
        query.setEntity("advisor", advisor);
        return ((Long) query.uniqueResult()).intValue();
    }
}
