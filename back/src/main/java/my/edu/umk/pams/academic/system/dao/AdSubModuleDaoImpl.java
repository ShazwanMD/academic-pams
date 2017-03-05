package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.system.model.AdModule;
import my.edu.umk.pams.academic.system.model.AdSubModule;
import my.edu.umk.pams.academic.system.model.AdSubModuleImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Repository("subModuleDao")
public final class AdSubModuleDaoImpl extends GenericDaoSupport<Long, AdSubModule> implements AdSubModuleDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdSubModuleDaoImpl.class);

    public AdSubModuleDaoImpl() {
        super(AdSubModuleImpl.class);
    }

    @Override
    public AdSubModule findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from AdSubModule c where c.code = :code");
        query.setString("code", code);
        query.setCacheable(true);
        return (AdSubModule) query.uniqueResult();
    }

    @Override
    public List<AdSubModule> find(AdModule module, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from AdSubModule c where " +
                "c.module = :module");
        query.setEntity("module", module);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdSubModule>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(c) from AdSubModule c");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdModule module) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSubModule s where " +
                "s.module = :module");
        query.setEntity("module", module);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdSubModule s where " +
                "upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSubModule c where " +
                "c.code = :code");
        query.setString("code", code);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

}
