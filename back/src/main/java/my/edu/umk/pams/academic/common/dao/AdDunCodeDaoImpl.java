package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdDunCode;
import my.edu.umk.pams.academic.common.model.AdDunCodeImpl;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("inDunCodeDao")
public class AdDunCodeDaoImpl extends GenericDaoSupport<Long, AdDunCode> implements AdDunCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdDunCodeDaoImpl.class);

    public AdDunCodeDaoImpl() {
        super(AdDunCodeImpl.class);
    }

    @Override
    public AdDunCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdDunCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdDunCode) query.uniqueResult();
    }

    @Override
    public List<AdDunCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdDunCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdDunCode>) query.list();

    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdDunCode s where " +
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
        Query query = session.createQuery("select count(*) from AdDunCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
