package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.system.model.AdModule;
import my.edu.umk.pams.academic.system.model.AdModuleImpl;
import my.edu.umk.pams.academic.system.model.AdSubModule;
import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * @author canang technologies
 * @since 4/18/14
 */
@Repository("moduleDao")
public class AdModuleDaoImpl extends GenericDaoSupport<Long, AdModule> implements AdModuleDao {

    public AdModuleDaoImpl() {
        super(AdModuleImpl.class);
    }

    @Override
    public AdModule findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from AdModule c where c.code = :code");
        query.setString("code", code);
        query.setCacheable(true);
        return (AdModule) query.uniqueResult();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdModule s where " +
                "upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdModule c where " +
                "c.code = :code");
        query.setString("code", code);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isSubModuleExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdSubModule c where " +
                "c.code = :code");
        query.setString("code", code);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public void addSubModule(AdModule module, AdSubModule subModule, AdUser user) {
        Validate.notNull(module, "Module should not be null");
        Validate.notNull(subModule, "SubModule member should not be null");

        Session session = sessionFactory.getCurrentSession();
        subModule.setModule(module);
        session.save(subModule);
    }

    @Override
    public void updateSubModule(AdModule module, AdSubModule subModule, AdUser user) {
        Validate.notNull(module, "Module should not be null");
        Validate.notNull(subModule, "SubModule member should not be null");

        Session session = sessionFactory.getCurrentSession();
        subModule.setModule(module);
        session.update(subModule);
    }

    @Override
    public void removeSubModule(AdModule module, AdSubModule subModule, AdUser user) {
        Validate.notNull(module, "Module should not be null");
        Validate.notNull(subModule, "SubModule member should not be null");

        Session session = sessionFactory.getCurrentSession();
        session.delete(subModule);
    }
}
