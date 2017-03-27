package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdEmploymentFieldCode;
import my.edu.umk.pams.academic.common.model.AdEmploymentFieldCodeImpl;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("InEmploymentFieldCodeDao")
public class AdEmploymentFieldCodeDaoImpl extends GenericDaoSupport<Long, AdEmploymentFieldCode> implements AdEmploymentFieldCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdEmploymentFieldCodeDaoImpl.class);

    public AdEmploymentFieldCodeDaoImpl() {
        super(AdEmploymentFieldCodeImpl.class);
    }

    @Override
    public AdEmploymentFieldCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEmploymentFieldCode s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdEmploymentFieldCode) query.uniqueResult();
    }

    @Override
    public List<AdEmploymentFieldCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEmploymentFieldCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdEmploymentFieldCode>) query.list();

    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdEmploymentFieldCode s where " +
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
        Query query = session.createQuery("select count(*) from AdEmploymentFieldCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
