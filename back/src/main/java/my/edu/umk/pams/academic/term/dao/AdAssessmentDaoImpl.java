package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adAssessmentDao")
public class AdAssessmentDaoImpl extends GenericDaoSupport<Long, AdAssessment> implements AdAssessmentDao {

    public AdAssessmentDaoImpl() {
        super(AdAssessmentImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdAssessment findByCanonicalCode(String canonicalCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "upper(s.canonicalCode) = upper(:canonicalCode) " +
                "and s.metadata.state = :state");
        query.setString("canonicalCode", canonicalCode);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAssessment) query.uniqueResult();
    }

    @Override
    public AdAssessment findByCodeAndOfferingAndSession(String code, AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "upper(s.code) = upper(:code) " +
                "and s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAssessment) query.uniqueResult();
    }

    @Override
    public List<AdAssessment> find(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state " +
                "order by s.code");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setCacheable(true);
        return (List<AdAssessment>) query.list();
    }

    @Override
    public List<AdAssessment> find(AdAcademicSession academicSession, AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAssessment>) query.list();
    }

    @Override
    public List<AdAssessment> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                " s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAssessment>) query.list();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAssessment s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdAcademicSession academicSession, AdOffering offering, AdAssessmentType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.type = :type " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setInteger("type", type.ordinal());
        query.setEntity("academicSession", academicSession);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code, AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAssessment s where " +
                "upper(s.code) = upper(:code) " +
                "and s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setEntity("offering", offering);
        query.setEntity("academicSession", academicSession);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String canonicalCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAssessment s where " +
                "upper(s.canonicalCode) = upper(:canonicalCode) " +
                "and s.metadata.state = :state ");
        query.setString("canonicalCode", canonicalCode);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasAssessment(AdAcademicSession academicSession, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAssessment s where " +
                "s.session = :academicSession " +
                "and s.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setEntity("academicSession", academicSession);
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasGradebook(AdSection section, AdAssessment assessment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AcGradebook s where " +
                "s.assessment = :assessment " +
                "and s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("assessment", assessment);
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}