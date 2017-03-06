package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicArea;
import my.edu.umk.pams.academic.studyplan.model.AdAcademicAreaImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adAcademicAreaDao")
public class AdAcademicAreaDaoImpl extends GenericDaoSupport<Long, AdAcademicArea> implements AdAcademicAreaDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdAcademicAreaDaoImpl.class);

    public AdAcademicAreaDaoImpl() {
        super(AdAcademicAreaImpl.class);
    }

    @Override
    public AdAcademicArea findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicArea s where " +
                "s.code = :code " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAcademicArea) query.uniqueResult();
    }

    @Override
    public List<AdAcademicArea> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAcademicArea s where " +
                "upper(s.code) like :filter " +
                "and s.metadata.state = :state " +
                "order by s.startDate desc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAcademicArea>) query.list();
    }


    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAcademicArea s where " +
                "upper(s.code) like :filter " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isCodeExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAcademicArea s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue() > 0;
    }
}
