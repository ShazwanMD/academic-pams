package my.edu.umk.pams.academic.graduation.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplication;
import my.edu.umk.pams.academic.graduation.model.AdGraduationApplicationImpl;
import my.edu.umk.pams.academic.planner.model.AdAcademicSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adGraduationApplicationDao")
public class AdGraduationApplicationDaoImpl extends GenericDaoSupport<Long, AdGraduationApplication> implements AdGraduationApplicationDao {

    private static final Logger LOG = LoggerFactory.getLogger(AdGraduationApplicationDaoImpl.class);

    public AdGraduationApplicationDaoImpl() {
        super(AdGraduationApplicationImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdGraduationApplication findByReferenceNo(String referenceNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdGraduationApplication a where " +
                "a.referenceNo = :referenceNo " +
                "and a.metadata.state = :state");
        query.setString("referenceNo", referenceNo);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdGraduationApplication) query.uniqueResult();
    }

    @Override
    public List<AdGraduationApplication> find(AdAcademicSession academicSession, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from AdGraduationApplication a where " +
                "a.session = :academicSession "+
                "and a.metadata.state = :state");
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdGraduationApplication>) query.list();
    }


    // ====================================================================================================
    // HELPER
    // ====================================================================================================


    @Override
    public Integer count(AdAcademicSession academicSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from AdGraduationApplication a where " +
                "a.session=:academicSession " +
                "and a.metadata.state = :metaState ");
        query.setEntity("academicSession", academicSession);
        query.setInteger("metaState", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }
}