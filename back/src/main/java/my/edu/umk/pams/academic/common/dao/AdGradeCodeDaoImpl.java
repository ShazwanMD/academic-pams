package my.edu.umk.pams.academic.common.dao;

import my.edu.umk.pams.academic.common.model.AdGradeCode;
import my.edu.umk.pams.academic.common.model.AdGradeCodeImpl;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("adGradeCodeDao")
public class AdGradeCodeDaoImpl extends GenericDaoSupport<Long, AdGradeCode> implements AdGradeCodeDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdGradeCodeDaoImpl.class);

    public AdGradeCodeDaoImpl() {
        super(AdGradeCodeImpl.class);
    }
    
    @Override
    public AdGradeCode findByScore(BigDecimal score) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradeCode s where " +
                ":score >= s.min and :score <= s.max " +
                "and s.metadata.state = :state");
        query.setBigDecimal("score", score);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdGradeCode) query.uniqueResult();
    }

    @Override
    public AdGradeCode findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradeCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdGradeCode) query.uniqueResult();
    }

    @Override
    public List<AdGradeCode> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradeCode s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state order by s.ordinal");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdGradeCode>) query.list();

    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdGradeCode s where " +
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
        Query query = session.createQuery("select count(*) from AdGradeCode s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

	@Override
	public List<AdGradeCode> find(AdGradeCode grade) {
		 Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("select s from AdGradeCode s where s.grade = :grade " +
	              "and s.metadata.state = :state ");
	     	        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
	      	        query.setCacheable(true);
	        return (List<AdGradeCode>) query.list();
	}
}
