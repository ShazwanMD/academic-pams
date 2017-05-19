package my.edu.umk.pams.academic.term.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.AdMetadata;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdUser;
import my.edu.umk.pams.academic.term.model.*;
import my.edu.umk.pams.academic.planner.model.*;

import org.apache.commons.lang.Validate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
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
    public AdAssessment findByCodeAndOffering(String code, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "upper(s.code) = upper(:code) " +
                "and s.offering = :offering " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("offering", offering);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdAssessment) query.uniqueResult();
    }

    @Override
    public List<AdAssessment> find(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.metadata.state = :state " +
                "order by s.code");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdAssessment>) query.list();
    }

    @Override
    public List<AdAssessment> find(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdAssessment>) query.list();
    }

    @Override
    public List<AdAssessment> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdAssessment s where " +
                "s.metadata.state = :state ");
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
    public Integer count(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdOffering offering, AdAssessmentType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.session = :academicSession " +
                "and s.type = :type " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setInteger("type", type.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String canonicalCode, AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAssessment s where " +
                "upper(s.canonicalCode) = upper(:canonicalCode) " +
                "and s.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setString("canonicalCode", canonicalCode);
        query.setEntity("offering", offering);
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
    public boolean hasAssessment(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdAssessment s where " +
                "s.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setEntity("offering", offering);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasGradebook(AdSection section, AdAssessment assessment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdGradebook s where " +
                "s.assessment = :assessment " +
                "and s.section = :section " +
                "and s.metadata.state = :state ");
        query.setEntity("assessment", assessment);
        query.setEntity("section", section);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
    // ====================================================================================================
    // CRUD
    // ====================================================================================================

    @Override
    public void addAssessment(AdOffering offering, AdAssessment assessment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(offering, "Offering cannot be null");
        Validate.notNull(assessment, "assessment cannot be null");
        Session session = sessionFactory.getCurrentSession();
        assessment.setOffering(offering);

        // prepare metadata
        AdMetadata metadata = new AdMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreatorId(user.getId());
        metadata.setState(AdMetaState.ACTIVE);
        assessment.setMetadata(metadata);
        session.save(assessment);
    }

    @Override
    public void updateAssessment(AdOffering offering, AdAssessment assessment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        assessment.setOffering(offering);

        // prepare metadata
        AdMetadata metadata = assessment.getMetadata();
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifierId(user.getId());
        assessment.setMetadata(metadata);
        session.update(assessment);
    }

    @Override
    public void deleteAssessment(AdOffering offering, AdAssessment assessment, AdUser user) {
        Validate.notNull(user, "User cannot be null");
        Session session = sessionFactory.getCurrentSession();
        session.delete(assessment);
    }
}