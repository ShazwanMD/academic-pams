package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdCountryCode;
import my.edu.umk.pams.academic.common.model.AdCountryCodeImpl;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adCountryCode")
public class AdCountryCodeDaoImpl extends GenericDaoSupport<Long, AdCountryCode> implements AdCountryCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdCountryCodeDaoImpl.class);

    public AdCountryCodeDaoImpl() {
        super(AdCountryCodeImpl.class);
    }

    @Override
    public AdCountryCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCountryCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCountryCode) query.uniqueResult();
    }

    @Override
    public List<AdCountryCode> findCountryCodes(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCountryCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCountryCode>) query.list();
    }

    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCountryCode s where " +
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
        Query query = session.createQuery("select count(*) from AdCountryCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
