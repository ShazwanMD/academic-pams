package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.model.AdStateCode;
import my.edu.umk.pams.academic.common.model.AdStateCodeImpl;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("stateCodeDao")
public class AdStateCodeDaoImpl extends GenericDaoSupport<Long, AdStateCode> implements AdStateCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdStateCodeDaoImpl.class);

    public AdStateCodeDaoImpl() {
        super(AdStateCodeImpl.class);
    }

    @Override
    public AdStateCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStateCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdStateCode) query.uniqueResult();
    }

    @Override
    public List<AdStateCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStateCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return query.list();
    }

    @Override
    public List<AdStateCode> find(AdCountryCode countryCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStateCode s where " +
                "s.countryCode = :countryCode " +
                "and s.metadata.state = :state ");
        query.setEntity("countryCode", countryCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdStateCode>) query.list();
    }

    @Override
    public List<AdStateCode> find(String filter, AdCountryCode countryCode, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStateCode s where " +
                "s.countryCode = :countryCode " +
                "and (upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setEntity("countryCode", countryCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdStateCode>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStateCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setCacheable(true);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdCountryCode countryCode) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStateCode s where " +
                "s.countryCode = :countryCode " +
                "and s.metadata.state = :state ");
        query.setEntity("countryCode", countryCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter, AdCountryCode countryCode) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStateCode s where " +
                "s.countryCode = :countryCode " +
                "and (upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter) " +
                "or upper(s.countryCode.code) like upper(:filter) " +
                "or upper(s.countryCode.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdStateCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
