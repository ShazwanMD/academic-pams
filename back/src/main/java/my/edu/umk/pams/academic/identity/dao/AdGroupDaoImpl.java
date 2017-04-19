package my.edu.umk.pams.academic.identity.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.*;
import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static my.edu.umk.pams.academic.core.AdMetaState.ACTIVE;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("groupDao")
public class AdGroupDaoImpl extends GenericDaoSupport<Long, AdGroup> implements AdGroupDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdGroupDaoImpl.class);

    public AdGroupDaoImpl() {
        super(AdGroupImpl.class);
    }
    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public List<AdGroup> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from AdGroup g order by g.name");
        return (List<AdGroup>) query.list();
    }

    @Override
    public AdGroup findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from AdGroup g where g.name = :name");
        query.setString("name", name);
        return (AdGroup) query.uniqueResult();
    }


    @Override
    public List<AdGroup> findImmediate(AdPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.group from AdGroupMember gm inner join gm.principal where " +
                "gm.principal = :principal");
        query.setEntity("principal", principal);
        return (List<AdGroup>) query.list();
    }


    @Override
    public List<AdGroup> findImmediate(AdPrincipal principal, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.group from AdGroupMember gm inner join gm.principal where " +
                "gm.principal = :principal");
        query.setEntity("principal", principal);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdGroup>) query.list();
    }

    @Override
    public Set<AdGroup> findEffectiveAsNative(AdPrincipal principal) {
        Set<AdGroup> groups = new HashSet<AdGroup>();
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("WITH RECURSIVE " +
                "Q AS " +
                "( SELECT  GROUP_ID, PRINCIPAL_ID " +
                "    FROM    AD_GROP_MMBR " +
                "    WHERE   PRINCIPAL_ID = " + principal.getId() +
                "    UNION ALL " +
                "    SELECT  GM.GROUP_ID, GM.PRINCIPAL_ID " +
                "    FROM    AD_GROP_MMBR GM " +
                "    JOIN    Q " +
                "    ON      GM.PRINCIPAL_ID = Q.GROUP_ID " +
                ") " +
                "SELECT  GROUP_ID FROM  Q");
        query.addScalar("GROUP_ID", LongType.INSTANCE);
        List<Long> results = (List<Long>) query.list();
        for (Long result : results) {
            groups.add(findById(result));
        }
        return groups;
    }

    @Override
    public List<AdGroup> findAvailableGroups(AdUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdGroup p where " +
                "p not in (select gm.group from AdGroupMember gm where gm.principal = :user) " +
                "and p <> :user " +
                "and p.metadata.state = :state " +
                "order by p.name asc");
        query.setInteger("state", ACTIVE.ordinal());
        query.setEntity("user", user);
        return (List<AdGroup>) query.list();
    }

    @Override
    public List<AdPrincipal> findAvailableMembers(AdGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdPrincipal p where " +
                "p not in (select gm.principal from AdGroupMember gm where gm.group = :group) " +
                "and p <> :group " +
                "and p.metadata.state = :state " +
                "order by p.name asc");
        query.setInteger("state", ACTIVE.ordinal());
        query.setEntity("group", group);
        return (List<AdPrincipal>) query.list();
    }

    @Override
    public List<AdPrincipal> findMembers(AdGroup group, AdPrincipalType principalType) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.group from AdGroupMember gm inner join gm.principal where " +
                "gm.group = :group " +
                "and gm.principal.principalType= :principalType " +
                "and gm.principal.metadata.state = :state ");
        query.setEntity("group", group);
        query.setInteger("principalType", principalType.ordinal());
        return (List<AdPrincipal>) query.list();
    }

    @Override
    public List<AdPrincipal> findMembers(AdGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from AdGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.metadata.state = :state " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        query.setInteger("state", ACTIVE.ordinal());
        return (List<AdPrincipal>) query.list();
    }

    @Override
    public List<AdPrincipal> findMembers(AdGroup group, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from AdGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.metadata.state = :state " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdPrincipal>) query.list();
    }

    @Override
    public List<AdGroup> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct g from AdGroup g where " +
                "g.name like upper(:filter) ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdGroup>) query.list();
    }

    @Override
    public List<AdGroup> findMemberships(AdPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct gm.group from AdGroupMember gm where " +
                "gm.principal = :principal ");
        query.setEntity("principal", principal);
        return (List<AdGroup>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from AdGroup g");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from AdGroup g where " +
                "g.name like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countMember(AdGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(gm.principal) from AdGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.metadata.state = :state");
        query.setEntity("group", group);
        query.setInteger("state", ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from AdGroup g where " +
                "g.name = :name");
        query.setString("name", name);
        return ((Long) query.uniqueResult()).intValue() >= 1;
    }

    @Override
    public boolean hasMembership(AdGroup group, AdPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(gm) from AdGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return ((Long) query.uniqueResult()).intValue() >= 1;
    }

// =============================================================================
    // CRUD METHODS
    // =============================================================================

    @Override
    public void addMember(AdGroup group, AdPrincipal member, AdUser user) throws RecursiveGroupException {
        Validate.notNull(group, "Group should not be null");
        Validate.notNull(member, "Group member should not be null");

        if (member instanceof AdGroup) {
            if (checkRecursive(group, (AdGroup) member))
                throw new RecursiveGroupException("Recursive user group " + group.getName() + " > " + member.getName());
        }

        Session session = sessionFactory.getCurrentSession();
        AdGroupMember groupMember = new AdGroupMemberImpl();
        groupMember.setGroup(group);
        groupMember.setPrincipal(member);
        session.save(groupMember);
    }

    @Override
    public void addMembers(AdGroup group, List<AdPrincipal> members, AdUser user) throws RecursiveGroupException {
        List<AdPrincipal> currentMembers = findMembers(group);
        List<AdPrincipal> newMembers = new ArrayList<AdPrincipal>();

        for (AdPrincipal currentMember : currentMembers) {
            if (!newMembers.contains(currentMember)) {
                deleteMember(group, currentMember);
            }
        }
        for (AdPrincipal newMember : newMembers) {
            if (!currentMembers.contains(newMember)) {
                addMember(group, newMember, user);
            }
        }
    }

    @Override
    public void deleteMember(AdGroup group, AdPrincipal member) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from AdGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", member);
        AdGroupMember groupMember = (AdGroupMember) query.uniqueResult();
        session.delete(groupMember);
    }

    private boolean checkRecursive(AdGroup parent, AdGroup child) {
        Set<AdGroup> hierarchicalGroup = findEffectiveAsNative(parent);
        return !hierarchicalGroup.add(child);
    }

}
