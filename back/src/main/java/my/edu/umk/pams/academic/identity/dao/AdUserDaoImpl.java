package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.*;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.identity.model.AdUserImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("userDao")
public class AdUserDaoImpl extends GenericDaoSupport<Long, AdUser> implements AdUserDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdUserDaoImpl.class);

    public AdUserDaoImpl() {
        super(AdUserImpl.class);
    }

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public List<AdGroup> findGroups(AdUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from AdGroup r inner join r.members m where m.id = :id");
        query.setLong("id", user.getId());
        return (List<AdGroup>) query.list();
    }

    @Override
    public boolean isExists(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdUser u where " +
                "upper(u.name) = upper(:username) ");
        query.setString("username", username);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasUser(AdActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdUser u where " +
                "u.actor = :actor");
        query.setEntity("actor", actor);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public AdUser findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from AdUser u where u.email = :email ");
        query.setString("email", email);
        return (AdUser) query.uniqueResult();
    }

    @Override
    public AdUser findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from AdUser u where u.name = :username ");
        query.setString("username", username);
        return (AdUser) query.uniqueResult();
    }

    @Override
    public AdUser findByActor(AdActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from AdUser u where u.actor = :actor ");
        query.setEntity("actor", actor);
        return (AdUser) query.uniqueResult();
    }

    @Override
    public List<AdUser> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdUser s where (" +
                "upper(s.name) like upper(:filter) " +
                "or upper(s.firstName) like upper(:filter) " +
                "or upper(s.lastName) like upper(:filter)) " +
                "order by s.firstName, s.lastName, s.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdUser>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(u) from AdUser u");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdUser s where " +
                "upper(s.name) like upper(:filter) " +
                "or upper(s.firstName) like upper(:filter) " +
                "or upper(s.lastName) like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
