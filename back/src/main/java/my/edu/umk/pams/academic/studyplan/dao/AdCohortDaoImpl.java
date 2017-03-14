package my.edu.umk.pams.academic.studyplan.dao;

import my.edu.umk.pams.academic.core.AdMetaState;
import my.edu.umk.pams.academic.core.GenericDaoSupport;
import my.edu.umk.pams.academic.identity.model.AdStudent;
import my.edu.umk.pams.academic.studyplan.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PAMS
 */
@Repository("acCohortDao")
public class AdCohortDaoImpl extends GenericDaoSupport<Long, AdCohort> implements AdCohortDao {

    public AdCohortDaoImpl() {
        super(AdCohortImpl.class);
    }

    // ====================================================================================================
    // FINDER
    // ====================================================================================================

    @Override
    public AdCohort findByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where s.code = :code and  " +
                " s.metadata.state = :state");
        query.setString("code", code);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCohort) query.uniqueResult();
    }

    @Override
    public AdCohort findByCodeAndProgram(String code, AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.code = :code " +
                "and s.program= :program " +
                "and s.metadata.state = :state");
        query.setString("code", code);
        query.setEntity("program", program);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCohort) query.uniqueResult();
    }

    @Override
    public AdCohort findByParent(AdCohort parent) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.code = :code " +
                "and s.parent = :parent " +
                "and s.metadata.state = :state");
        query.setEntity("parent", parent);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCohort) query.uniqueResult();
    }

    @Override
    public AdCohort findByProgramAndIntakeCode(AdProgram program, AdIntakeCode intakeCode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.program= :program " +
                "and s.intakeCode= :intakeCode " +
                "and s.metadata.state = :state");
        query.setEntity("program", program);
        query.setEntity("intakeCode", intakeCode);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (AdCohort) query.uniqueResult();
    }

    @Override
    public List<AdCohort> findRoots() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.parent is null " +
                "and s.metadata.state = :state");
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> findByProgram(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.program= :program " +
                "and s.metadata.state = :state");
        query.setEntity("program", program);
        query.setCacheable(true);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> find(AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }


    @Override
    public List<AdCohort> find(AdCurriculum curriculum, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.curriculum = :curriculum " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("curriculum", curriculum);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> find(String filter, AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> find(String filter, AdProgram program, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> findGraduated() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.classification = :classification " +
                "and s.metadata.state = :state ");
        query.setInteger("classification", AdAcademicClassification.LEVEL_GRADUATED.ordinal());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdCohort> findNonGraduated() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdCohort s where " +
                "s.classification != :classification " +
                "and s.metadata.state = :state ");
        query.setInteger("classification", AdAcademicClassification.LEVEL_GRADUATED.ordinal());
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setCacheable(true);
        return (List<AdCohort>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdCohort cohort) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStudent s where " +
                "s.cohort = :cohort " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("cohort", cohort);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(AdCohort cohort, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStudent s where " +
                "s.cohort = :cohort " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("cohort", cohort);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    @Override
    public List<AdStudent> findStudents(String filter, AdCohort cohort, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from AdStudent s where " +
                "(upper(s.identityNo) like upper(:filter) " +
                "or upper(s.name) like upper(:filter)) " +
                "and s.cohort = :cohort " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("cohort", cohort);
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        query.setCacheable(true);
        return (List<AdStudent>) query.list();
    }

    // ====================================================================================================
    // HELPER
    // ====================================================================================================

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCohort s where " +
                "s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCohort s where " +
                "(upper(s.code) like upper(:filter) " +
                "or upper(s.description) like upper(:filter)) " +
                "and s.metadata.state = :state ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdCohort parent) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCohort s where " +
                "s.parent = :parent " +
                "and s.metadata.state = :state ");
        query.setEntity("parent", parent);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(AdProgram program) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdCohort s where " +
                "s.program = :program " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("program", program);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStudent(AdCohort cohort) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStudent s where " +
                "s.cohort = :cohort " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setEntity("cohort", cohort);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer countStudent(String filter, AdCohort cohort) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from AdStudent s where " +
                "(upper(s.name) like upper(:filter) " +
                "or upper(s.identityNo) like upper(:filter)) " +
                "and s.cohort = :cohort " +
                "and s.metadata.state = :state ");
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setEntity("cohort", cohort);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExists(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from AdCohort s where " +
                "s.code = :code " +
                "and s.metadata.state = :state ");
        query.setString("code", code);
        query.setInteger("state", AdMetaState.ACTIVE.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }
}
