package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.system.model.AdConfiguration;
import my.edu.umk.pams.academic.system.model.AdConfigurationImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("configurationDao")
public final class AdConfigurationDaoImpl extends GenericDaoSupport<Long, AdConfiguration> implements AdConfigurationDao {

    public AdConfigurationDaoImpl() {
        super(AdConfigurationImpl.class);
    }

    public AdConfigurationDaoImpl(Class clazz) {
        super(clazz);
    }

    @Override
    public AdConfiguration findByKey(String key) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdConfiguration s where " +
                "s.key = :key and  " +
                " s.metadata.state = :state");
        query.setString("key", key);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (AdConfiguration) query.uniqueResult();
    }

    @Override
    public List<AdConfiguration> findByPrefix(String prefix) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdConfiguration s where " +
                "upper(s.key) like upper(:prefix)  " +
                "and s.metadata.state = :state");
        query.setString("prefix", prefix + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<AdConfiguration> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdConfiguration s where " +
                "s.metadata.state = :state");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<AdConfiguration> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdConfiguration s where " +
                "(upper(s.key) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<AdConfiguration> find(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdConfiguration s where " +
                "upper(s.key) like upper(:filter)  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<AdConfiguration> findInverse(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdConfiguration s where " +
                "upper(s.key) not like upper(:filter)  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdConfiguration s where " +
                "(upper(s.key) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

}
