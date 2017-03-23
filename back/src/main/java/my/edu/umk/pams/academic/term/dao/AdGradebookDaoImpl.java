package my.edu.umk.pams.academic.term.dao;


import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.term.model.AdEnrollment;
import my.edu.umk.pams.academic.term.model.AdGradebook;
import my.edu.umk.pams.academic.term.model.AdGradebookImpl;
import my.edu.umk.pams.academic.term.model.AdAssessment;
import my.edu.umk.pams.academic.term.model.AdOffering;
import my.edu.umk.pams.academic.term.model.AdSection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("adGradebookDao")
public class AdGradebookDaoImpl extends GenericDaoSupport<Long, AdGradebook> implements AdGradebookDao {

    public AdGradebookDaoImpl() {
        super(AdGradebookImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdGradebook findByAssessmentAndEnrollment(AdAssessment assessment, AdEnrollment enrollment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.assessment = :assessment " +
                "and s.enrollment = :enrollment " +
                "and  s.metadata.state = :state");
        query.setEntity("assessment", assessment);
        query.setEntity("enrollment", enrollment);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdGradebook) query.uniqueResult();
    }

    @Override
    public List<AdGradebook> find(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.assessment.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdOffering offering, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.enrollment.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdSection section) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.enrollment.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdSection section, AdAssessment assessment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.enrollment.section = :section " +
                "and s.assessment = :assessment " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setEntity("assessment", assessment);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdEnrollment enrollment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.enrollment = :enrollment " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("enrollment", enrollment);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdSection section, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.enrollment.section = :section " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdSection section, AdAssessment assessment, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.enrollment.section = :section " +
                "and s.assessment = :assessment " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setEntity("assessment", assessment);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdAssessment assessment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.assessment = :assessment " +
                "and s.metadata.state = :state " +
                "order by s.enrollment.student.name asc");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("assessment", assessment);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    @Override
    public List<AdGradebook> find(AdAssessment assessment, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdGradebook s where " +
                "s.assessment = :assessment " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("assessment", assessment);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdGradebook>) query.list();
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public Integer count(AdOffering offering) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdGradebook s where " +
                "s.enrollment.section.offering = :offering " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("offering", offering);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdSection section, AdAssessment assessment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdGradebook s where " +
                "s.section = :section " +
                "and s.assessment = :assessment " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("section", section);
        query.setEntity("assessment", assessment);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(AdAssessment assessment, AdEnrollment enrollment) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdGradebook s where " +
                "s.enrollment = :enrollment " +
                "and s.assessment = :assessment " +
                "and s.metadata.state = :state ");
        query.setEntity("enrollment", enrollment);
        query.setEntity("assessment", assessment);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
