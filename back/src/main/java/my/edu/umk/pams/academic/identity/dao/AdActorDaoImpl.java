package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.identity.model.AdActor;
import my.edu.umk.pams.academic.identity.model.AdActorImpl;
import my.edu.umk.pams.academic.identity.model.AdActorType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("actorDao")
public class
AdActorDaoImpl extends GenericDaoSupport<Long, AdActor> implements AdActorDao {

    public AdActorDaoImpl() {
        super(AdActorImpl.class);
    }

    @Override
    public AdActor findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdActor a where " +
                "a.code = :code");
        query.setString("code", code);
        return (AdActor) query.uniqueResult();
    }

    @Override
    public AdActor findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdActor a where " +
                "a.email = :email");
        query.setString("email", email);
        return (AdActor) query.uniqueResult();
    }

    @Override
    public AdActor findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdActor a where " +
                "a.identityNo = :identityNo");
        query.setString("identityNo", identityNo);
        return (AdActor) query.uniqueResult();
    }

    @Override
    public List<AdActor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdActor a where " +
                "(a.firsName like upper(:filter)" +
                "or a.lastName like uppoer(:filter)) " +
                "order by a.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return query.list();
    }

    @Override
    public List<AdActor> find(AdActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdActor a where " +
                "a.actorType = :actorType " +
                "order by a.name");
        query.setInteger("actorType", type.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<AdActor> find(String filter, AdActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdActor a where " +
                "(a.firsName like upper(:filter)" +
                "or a.lastName like uppoer(:filter)) " +
                "and a.actorType = :actorType " +
                "order by a.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setParameter("actorType", type);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from AdActor a where " +
                "(upper(a.firstName) like upper(:filter)  " +
                "or upper(a.lastName) like upper(:filter))  " +
                "and a.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from AdActor a where " +
                "(upper(a.firstName) like upper(:filter)  " +
                "or upper(a.lastName) like upper(:filter))  " +
                "and a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setInteger("actorType", type.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from AdActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setInteger("actorType", type.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
