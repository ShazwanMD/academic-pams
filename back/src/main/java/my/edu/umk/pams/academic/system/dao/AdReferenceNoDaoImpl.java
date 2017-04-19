package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.system.model.AdReferenceNo;
import my.edu.umk.pams.academic.system.model.AdReferenceNoImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@Repository("referenceNoDao")
public class AdReferenceNoDaoImpl extends GenericDaoSupport<Long, AdReferenceNo> implements AdReferenceNoDao {

    public AdReferenceNoDaoImpl() {
        super(AdReferenceNoImpl.class);
    }

    @Override
    public AdReferenceNo findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdReferenceNo s where " +
        		"s.code = :code");
        //disable
              /*  "s.code = :code and  " +
                " s.metadata.state = :state");
        */
        query.setString("code", code);
        query.setCacheable(true);
//        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdReferenceNo) query.uniqueResult();
    }

    @Override
    public List<AdReferenceNo> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdReferenceNo s where " +
                "(upper(s.code) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setString("filter", filter);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdReferenceNo s where " +
                "(upper(s.code) like upper(:filter)  " +
                "or upper(s.description) like upper(:filter))  " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}
