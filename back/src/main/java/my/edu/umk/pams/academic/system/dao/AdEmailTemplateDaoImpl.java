package my.edu.umk.pams.academic.system.dao;

import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.system.model.AdEmailTemplate;
import my.edu.umk.pams.academic.system.model.AdEmailTemplateImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author canang technologies
 * @since 9/4/2016.
 */
@Repository("emailTemplateDao")
public class AdEmailTemplateDaoImpl extends GenericDaoSupport<Long, AdEmailTemplate> implements AdEmailTemplateDao {

    public AdEmailTemplateDaoImpl() {
        super(AdEmailTemplateImpl.class);
    }

    @Override
    public AdEmailTemplate findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdEmailTemplate s where " +
                "s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (AdEmailTemplate) query.uniqueResult();
    }

    @Override
    public Integer count(String filter) {
        return null;
    }

    @Override
    public List<AdEmailTemplate> find(String filter) {
        return null;
    }

    @Override
    public List<AdEmailTemplate> find(String filter, Integer offset, Integer limit) {
        return null;
    }
}
