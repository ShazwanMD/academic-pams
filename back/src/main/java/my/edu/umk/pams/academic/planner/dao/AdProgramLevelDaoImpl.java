package my.edu.umk.pams.academic.planner.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.planner.model.AdProgramLevel;
import my.edu.umk.pams.academic.planner.model.AdProgramLevelImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adProgramLevelDao")
public class AdProgramLevelDaoImpl extends GenericDaoSupport<Long, AdProgramLevel> implements AdProgramLevelDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdProgramLevelDaoImpl.class);

    public AdProgramLevelDaoImpl() {
        super(AdProgramLevelImpl.class);
    }

    @Override
    public AdProgramLevel findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from AdProgramLevel r where r.code = :code");
        query.setString("code", code);
        return (AdProgramLevel) query.uniqueResult();
    }


    @Override
    public List<AdProgramLevel> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from AdProgramLevel p where " +
                "(upper(p.code) like upper(:filter) or upper(p.description) like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<AdProgramLevel>) query.list();
    }

    @Override
    public Integer count(String filter) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select count(p) from AdProgramLevel p " +
                "where upper(p.code) like  upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
