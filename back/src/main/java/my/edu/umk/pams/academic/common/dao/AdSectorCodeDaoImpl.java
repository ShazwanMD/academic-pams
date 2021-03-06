package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdEmploymentSectorCode;
import my.edu.umk.pams.academic.common.model.AdEmploymentSectorCodeImpl;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InSectorCodeDao")
public class AdSectorCodeDaoImpl extends GenericDaoSupport<Long, AdEmploymentSectorCode> implements AdSectorCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdSectorCodeDaoImpl.class);

    public AdSectorCodeDaoImpl() {
        super(AdEmploymentSectorCodeImpl.class);
    }

    @Override
    public AdEmploymentSectorCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSectorCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdEmploymentSectorCode) query.uniqueResult();
    }

    @Override
    public List<AdEmploymentSectorCode> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSectorCode s where " +
                " s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdEmploymentSectorCode>) query.list();
    }

    @Override
    public List<AdEmploymentSectorCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdSectorCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEmploymentSectorCode>) query.list();

    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSectorCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSectorCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
