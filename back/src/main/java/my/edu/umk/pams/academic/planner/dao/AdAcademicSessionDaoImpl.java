package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.planner.model.AdAcademicSemester;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import my.edu.umk.pams.academic.planner.model.AdAcademicSessionImpl;
import my.edu.umk.pams.academic.term.model.AdAdmission;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adAcademicSessionDao")
public class AdAcademicSessionDaoImpl extends GenericDaoSupport<Long, AdAcademicSession> implements AdAcademicSessionDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdAcademicSessionDaoImpl.class);

    public AdAcademicSessionDaoImpl() {
        super(AdAcademicSessionImpl.class);
    }

    @Override
    public AdAcademicSession findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicSession s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAcademicSession) query.uniqueResult();
    }

    @Override
    public AdAcademicSession findCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicSession s where " +
                "s.current = :current " +
                "and s.metadata.state = :state");
        query.setBoolean("current", true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (AdAcademicSession) query.uniqueResult();
    }

    @Override
    public AdAcademicSession findNextSession(AdAcademicSession current) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicSession s where " +
                "s.previous = :current " +
                "and s.metadata.state = :state " +
                "order by s.startDate asc");
        query.setEntity("current", current);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(0);
        query.setMaxResults(1);
        query.setCacheable(true);
        List<AdAcademicSession> list = (List<AdAcademicSession>) query.list();
        if (list.isEmpty()) return null;
        else return list.get(0);
    }

    @Override
    public AdAcademicSession findPreviousSession() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicSession s where " +
                "s.metadata.state = :state " +
                "order by s.startDate desc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(0);
        query.setMaxResults(1);
        query.setCacheable(true);
        List<AdAcademicSession> list = (List<AdAcademicSession>) query.list();
        if (list.isEmpty()) return null;
        else return list.get(0);
    }

    @Override
    public List<AdAcademicSession> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicSession s where " +
                "upper(s.code) like :filter " +
                "and s.metadata.state = :state " +
                "order by s.startDate desc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAcademicSession>) query.list();
    }
    
    @Override
    public List<AdAcademicSession> find(String filter, AdAcademicSemester semester, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicSession s where " +
                "upper(s.code) like :filter " +
                "and s.semester = :semester " +
                "and s.metadata.state = :state " +
                "order by s.startDate desc");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("semester", semester);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAcademicSession>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAcademicSession s where " +
                "upper(s.code) like :filter " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isCodeExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAcademicSession s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue() > 0;
    }

    @Override
    public boolean isCurrent(boolean b) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAcademicSession s where " +
                "s.current = true ");
        return ((Long) query.uniqueResult()).intValue() == 1;
    }

	
	
}
