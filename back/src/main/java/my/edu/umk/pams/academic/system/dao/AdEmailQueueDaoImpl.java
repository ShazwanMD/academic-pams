package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.system.model.AdEmailQueue;
import my.edu.umk.pams.academic.system.model.AdEmailQueueImpl;
import my.edu.umk.pams.academic.system.model.AdEmailQueueStatus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 1/31/14
 */
@SuppressWarnings({"unchecked"})
@Repository("emailQueueDao")
public final class AdEmailQueueDaoImpl extends GenericDaoSupport<Long, AdEmailQueue> implements AdEmailQueueDao {

    public AdEmailQueueDaoImpl() {
        super(AdEmailQueueImpl.class);
    }

    @Override
    public List<AdEmailQueue> find(AdEmailQueueStatus status) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select eq from AdEmailQueue eq where " +
                "eq.queueStatus = (:status) ");
        query.setInteger("status", status.ordinal());
        return query.list();
    }

    @Override
    public List<AdEmailQueue> find(AdEmailQueueStatus... statuses) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select eq from AdEmailQueue eq where " +
                "eq.queueStatus in (:statuses) ");
        query.setParameterList("statuses", statuses);
        return query.list();
    }
}
