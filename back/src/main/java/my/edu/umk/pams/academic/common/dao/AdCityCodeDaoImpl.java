package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCityCode;
import my.edu.umk.pams.academic.common.model.AdCityCodeImpl;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adCityCodeDao")
public class AdCityCodeDaoImpl extends GenericDaoSupport<Long, AdCityCode> implements AdCityCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdCityCodeDaoImpl.class);

    public AdCityCodeDaoImpl() {
        super(AdCityCodeImpl.class);
    }

    @Override
    public AdCityCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCityCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCityCode) query.uniqueResult();
    }

    // TODO:
    @Override
    public List<AdCityCode> find(AdStateCode stateCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdCityCode>) query.list();
    }

    @Override
    public List<AdCityCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCityCode>) query.list();
    }

    @Override
    public List<AdCityCode> find(String filter, AdStateCode stateCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCityCode>) query.list();
    }

    @Override
    public Integer count(AdStateCode stateCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCityCode s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdStateCode stateCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCityCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCityCode s where " +
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
        Query query = session.createQuery("select count(*) from AdCityCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
