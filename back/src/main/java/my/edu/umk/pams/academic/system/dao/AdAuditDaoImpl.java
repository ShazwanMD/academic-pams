package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.system.model.AdAudit;
import my.edu.umk.pams.academic.system.model.AdAuditImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 3/8/14
 */
@Repository("auditDao")
public class AdAuditDaoImpl extends GenericDaoSupport<Long, AdAudit> implements AdAuditDao {

    public AdAuditDaoImpl() {
        super(AdAuditImpl.class);
    }

    @Override
    public List<AdAudit> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAudit s where " +
                "(upper(s.message) like upper(:filter)  " +
                "or upper(s.className) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAudit s where " +
                "(upper(s.message) like upper(:filter)  " +
                "or upper(s.className) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}

