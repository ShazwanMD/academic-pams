package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.identity.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static my.edu.umk.pams.academic.core.AdMetaState.ACTIVE;


/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("principalDao")
public final class AdPrincipalDaoImpl extends GenericDaoSupport<Long, AdPrincipal> implements AdPrincipalDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdPrincipalDaoImpl.class);

    public AdPrincipalDaoImpl() {
        super(AdPrincipalImpl.class);
    }

    @Override
    public List<AdPrincipal> findAllPrincipals() {
        Session session = sessionFactory.getCurrentSession();
        List<AdPrincipal> results = new ArrayList<AdPrincipal>();
        Query query = session.createQuery("select p from AdUser p order by p.name");
        results.addAll((List<AdPrincipal>) query.list());

        Query queryGroup = session.createQuery("select p from AdGroup p order by p.name ");
        results.addAll((List<AdPrincipal>) queryGroup.list());

        return results;
    }

    @Override
    public List<AdPrincipal> find(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdPrincipal p where p.name like :filter order by p.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return query.list();
    }

    @Override
    public List<AdPrincipal> find(String filter, AdPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdPrincipal p where " +
                "p.name like :filter " +
                "and p.principalType = :principalType " +
                "order by p.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("principalType", type.ordinal());
        return query.list();
    }

    @Override
    public List<AdPrincipal> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdPrincipal p where " +
                "p.id in (" +
                "select u.id from AdUser u where " +
                "(upper(u.name) like upper(:filter)" +
                "or upper(u.firstName) like upper(:filter)" +
                "or upper(u.lastName) like upper(:filter))" +
                ") " +
                "or p.id in (select g.id from AdGroup g  where upper(g.name) like upper(:filter)) " +
                "order by p.name");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public void addRole(AdPrincipal principal, AdPrincipalRole role, AdUser user) {
        Session session = sessionFactory.getCurrentSession();
        role.setPrincipal(principal);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(ACTIVE);
        role.setMetadata(metadata);
        session.save(role);
    }

    @Override
    public void deleteRole(AdPrincipal principal, AdPrincipalRole role, AdUser user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(role);
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(u) from AdPrincipal u where " +
                "u.name like :filter ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public AdPrincipal findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdPrincipal p where " +
                "upper(p.name) = upper(:name) ");
        query.setString("name", name);
        return (AdPrincipal) query.uniqueResult();
    }
}
